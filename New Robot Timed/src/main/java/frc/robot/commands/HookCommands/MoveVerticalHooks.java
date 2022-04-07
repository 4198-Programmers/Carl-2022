package frc.robot.commands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hooks.VerticalHooks;

public class MoveVerticalHooks extends CommandBase{
    public interface VerticalHookRetriever{
        double getSpeed();
    }
    VerticalHookRetriever verticalHookRetriever;
    VerticalHooks verticalHooks;
    public MoveVerticalHooks(VerticalHookRetriever verticalHookRetriever, VerticalHooks verticalHooks){
        this.verticalHookRetriever = verticalHookRetriever;
        this.verticalHooks = verticalHooks;
        addRequirements(verticalHooks);
    }
    @Override
    public void initialize() {
        verticalHooks.setPosition(0);
    }
    @Override
    public void execute() {
        verticalHooks.setSpeed(verticalHookRetriever.getSpeed());
    }
}