package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Sensors extends SubsystemBase {
    private DigitalInput ballInSensor = new DigitalInput(Constants.BALL_IN_SENSOR_PORT);
    private DigitalInput ballOutSensor = new DigitalInput(Constants.BALL_OUT_SENSOR_PORT);
    private boolean ballHasBeenSeenAtShooter = false;
    private boolean ballHasBeenSeenAtIntake = false;

    private boolean isBallAtIntake() {
        return ballInSensor.get();
    }

    private boolean isBallAtShooter() {
        return ballOutSensor.get();
    }

    public boolean hasBallBeenSeenAtShooter() {
        return ballHasBeenSeenAtShooter;
    }

    public boolean hasBallBeenSeenAtIntake() {
        return ballHasBeenSeenAtIntake;
    }

    @Override
    public void periodic() {
        if (isBallAtShooter()) {
            ballHasBeenSeenAtShooter = true;
        }
        if (isBallAtIntake()) {
            ballHasBeenSeenAtIntake = true;
        }
    }

    public void forgetShooterBall() {
        ballHasBeenSeenAtShooter = false;
    }

    public void forgetIntakeBall() {
        ballHasBeenSeenAtIntake = false;
    }

}
