package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;

public class FlyWheelStop extends CommandBase{
    FlyAndSensors flyAndSensors;
    boolean stopped;
    @Override
    public void initialize() {
        stopped = false;
    }
    @Override
    public void execute() {
        flyAndSensors.setFlySpeed(Constants.FREEZE);
        stopped = true;
    }
    @Override
    public boolean isFinished() {
        return stopped;
    }
}
