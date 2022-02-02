package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class ReachVertHooksUp extends CommandBase{
    private Hooks grabbers;

    public ReachVertHooksUp(Hooks hooksArg)
    {
        grabbers = hooksArg;
        addRequirements(grabbers);
    }

    @Override
    public void execute()
    {
        grabbers.moveVertHooks(Constants.VERT_HOOK_SPEED);
    }
    
}
