package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngledHooks;

public class AngledHookMove extends CommandBase{
    public interface HookSpeedRetriever{
        double getHookSpeed();
    }
    AngledHooks angledHooks;
    HookSpeedRetriever hookSpeedRetriever;
    public AngledHookMove(AngledHooks angledHooks, HookSpeedRetriever hookSpeedRetriever){
        this.angledHooks = angledHooks;
        this.hookSpeedRetriever = hookSpeedRetriever;
        addRequirements(angledHooks);
    }
    @Override
    public void execute() {
        angledHooks.moveHooks(hookSpeedRetriever.getHookSpeed());
    }
}
