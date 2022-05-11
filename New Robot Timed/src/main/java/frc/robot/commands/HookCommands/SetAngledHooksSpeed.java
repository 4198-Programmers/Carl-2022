package frc.robot.commands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hooks.AngledHooks;

public class SetAngledHooksSpeed extends CommandBase{
    boolean done;
    AngledHooks angledHooks;
    
    public SetAngledHooksSpeed(AngledHooks angledHooks){
        this.angledHooks = angledHooks;
        addRequirements(angledHooks);
    }
    @Override
    public void execute() {
        angledHooks.setSpeed(0);
        done = true;
    }
    @Override
    public boolean isFinished() {
        return done == true;
    }
}
