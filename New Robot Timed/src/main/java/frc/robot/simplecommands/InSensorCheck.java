package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyAndSensors;

/**
 * {@link InSensorCheck} Used for the sensor closer to the Intake, used as a
 * pause/wait until the sensor reads as true
 */
public class InSensorCheck extends CommandBase {
    FlyAndSensors sensors;
    Boolean inBallStatus;
    boolean wantBall;

    /**
     * {@link InSensorCheck} Used for the sensor closer to the Intake, used as a
     * pause/wait until the sensor reads as true
     */
    public InSensorCheck(FlyAndSensors flyAndSensorsArg, boolean wantBallArg) {
        sensors = flyAndSensorsArg;
        wantBall = wantBallArg;
        addRequirements(sensors);
    }

    @Override
    public void initialize() {
        inBallStatus = null;
    }

    @Override
    public void execute() {
        if (sensors.ballIn()) {
            inBallStatus = true;
        } else {
            inBallStatus = false;
        }
    }

    @Override
    public boolean isFinished() {
        return (wantBall == inBallStatus);
    }

}
