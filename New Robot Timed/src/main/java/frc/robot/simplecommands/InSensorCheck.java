package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyAndSensors;

public class InSensorCheck extends CommandBase {
    FlyAndSensors sensors;
    Boolean inBallStatus;
    boolean wantBall;

    public InSensorCheck(FlyAndSensors flyAndSensorsSub, boolean wantBallArg) {
        sensors = flyAndSensorsSub;
        wantBall = wantBallArg;
        addRequirements(flyAndSensorsSub);
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
