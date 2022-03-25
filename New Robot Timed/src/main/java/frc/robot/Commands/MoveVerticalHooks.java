package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.VerticalHooks;

public class MoveVerticalHooks extends CommandBase{
    public interface HookSpeedRetriever {
        double getHookSpeed();
    }
    VerticalHooks verticalHooks;
    HookSpeedRetriever hookSpeedRetriever;
    public MoveVerticalHooks(VerticalHooks verticalHooks, HookSpeedRetriever hookSpeedRetriever){
        this.verticalHooks = verticalHooks;
        this.hookSpeedRetriever = hookSpeedRetriever;
        addRequirements(verticalHooks);
    }
    @Override
    public void initialize() {
        verticalHooks.resetPosition();
    }
    @Override
    public void execute() {
        verticalHooks.moveHooks(hookSpeedRetriever.getHookSpeed());
    }
}
