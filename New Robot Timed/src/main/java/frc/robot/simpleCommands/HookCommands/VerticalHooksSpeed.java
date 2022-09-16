package frc.robot.simpleCommands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VerticalHooks;

public class VerticalHooksSpeed extends CommandBase{
    VerticalHooks verticalHooks;
    public interface SpeedRetriever{
        double getvertspeed();
    }
    SpeedRetriever vertSpeedRetriever;
    public VerticalHooksSpeed(VerticalHooks verticalHooks, SpeedRetriever vertSpeedRetriever){
        this.verticalHooks = verticalHooks;
        this.vertSpeedRetriever = vertSpeedRetriever;
        addRequirements(verticalHooks);
    }
    @Override
    public void execute() {
        verticalHooks.setVerticalhookSpeed(vertSpeedRetriever.getvertspeed());
    }
    @Override
    public void end(boolean interrupted) {
        verticalHooks.setVerticalhookSpeed(Constants.FREEZE);
    }
}
