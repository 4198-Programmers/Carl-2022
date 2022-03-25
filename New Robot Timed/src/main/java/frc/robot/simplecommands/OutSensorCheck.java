package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyAndSensors;

public class OutSensorCheck extends CommandBase {
    FlyAndSensors sensors;
    Boolean outBallStatus;
    boolean wantBall;

    public OutSensorCheck(FlyAndSensors flyAndSensorsSub, boolean wantBallArg) {
        sensors = flyAndSensorsSub;
        wantBall = wantBallArg;
        addRequirements(flyAndSensorsSub);
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
