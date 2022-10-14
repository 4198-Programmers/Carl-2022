package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyAndSensors;

/**
 * {@link OutSensorCheck} User inputs true/false for if they want a ball to the
 * reading on the sensor closest to the FlyWheel, command acts as a pause until
 * condition is met
 */
public class OutSensorCheck extends CommandBase {
    FlyAndSensors sensors;
    Boolean outBallStatus;
    boolean wantBall;

    /**
     * {@link OutSensorCheck} User inputs true/false for if they want a ball to the
     * reading on the sensor closest to the FlyWheel, command acts as a pause until
     * condition is met
     */
    public OutSensorCheck(FlyAndSensors flyAndSensorsArg, boolean wantBallArg) {
        sensors = flyAndSensorsArg;
        wantBall = wantBallArg;
        addRequirements(sensors);
    }

    @Override
    public void initialize() {
        outBallStatus = null;
    }

    @Override
    public void execute() {
        if (sensors.ballOut()) {
            outBallStatus = true;
        } else {
            outBallStatus = false;
        }
    }

    @Override
    public boolean isFinished() {
        return (wantBall == outBallStatus);
    }
}
