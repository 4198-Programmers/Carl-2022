package frc.robot.commands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hooks.VerticalHooks;

public class SetVerticalSpeed extends CommandBase{
    VerticalHooks verticalHooks;
    boolean done;
    public SetVerticalSpeed(VerticalHooks verticalHooks){
        this.verticalHooks = verticalHooks;
        addRequirements(verticalHooks);
    }
    @Override
    public void execute() {
        verticalHooks.setSpeed(0);
        done = true;
    }
    @Override
    public boolean isFinished() {
       return done == true;
    }
}
