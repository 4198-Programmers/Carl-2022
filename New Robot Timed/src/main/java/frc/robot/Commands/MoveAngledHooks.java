package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.AngledHooks;

public class MoveAngledHooks extends CommandBase{
    public interface HookSpeedRetriever {
        double getHookSpeed();
    }

    AngledHooks angledHooks;
    HookSpeedRetriever hookSpeedRetriever;
    public MoveAngledHooks(AngledHooks angledHooks, HookSpeedRetriever hookSpeedRetriever){
        this.angledHooks = angledHooks;
        this.hookSpeedRetriever = hookSpeedRetriever;
        addRequirements(angledHooks);
    }
    @Override
    public void initialize() {
        angledHooks.resetPostition();
    }
    @Override
    public void execute() {
        angledHooks.moveHooks(hookSpeedRetriever.getHookSpeed());
    }
}
