package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Sensors extends SubsystemBase {
    DigitalInput ballInSensor = new DigitalInput(Constants.BALL_IN_SENSOR_PORT);
    DigitalInput ballOutSensor = new DigitalInput(Constants.BALL_OUT_SENSOR_PORT);
    boolean ballIsAtShootSensor = false;
    boolean ballHasBeenSeenAtShooter = false;
    boolean ballIsAtIntakeSensor = false;
    boolean ballHasBeenSeenAtIntake = false;

    public boolean isBallAtIntake() {
        return ballInSensor.get();
    }

    public boolean isBallAtShooter() {
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
            ballIsAtShootSensor = true;
        }
        if (ballIsAtShootSensor) {
            ballHasBeenSeenAtShooter = true;
        }
        if (isBallAtIntake()) {
            ballIsAtIntakeSensor = true;
        }
        if (ballIsAtIntakeSensor) {
            ballHasBeenSeenAtIntake = true;
        }
    }

    public void forgetShooterBall() {
        ballIsAtShootSensor = false;
        ballHasBeenSeenAtShooter = false;
    }

    public void forgetIntakeBall() {
        ballIsAtIntakeSensor = false;
        ballHasBeenSeenAtIntake = false;
    }

}
