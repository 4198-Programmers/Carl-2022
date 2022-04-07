package frc.robot.commands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hooks.AngledHooks;

public class MoveAngledHooks extends CommandBase{
    public interface AngledHookSpeedRetriever{
        double getSpeed();
    }
    AngledHookSpeedRetriever angledHookSpeedRetriever;
    AngledHooks angledHooks;
    public MoveAngledHooks(AngledHookSpeedRetriever angledHookSpeedRetriever, AngledHooks angledHooks){
        this.angledHookSpeedRetriever = angledHookSpeedRetriever;
        this.angledHooks = angledHooks;
        addRequirements(angledHooks);
    }
    @Override
    public void initialize() {
        angledHooks.setPosition(0);
    }
    @Override
    public void execute() {
        angledHooks.setSpeed(angledHookSpeedRetriever.getSpeed());
    }
}
