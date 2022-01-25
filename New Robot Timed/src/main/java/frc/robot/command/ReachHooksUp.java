package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Hooks;

public class ReachHooksUp extends CommandBase{
    private Hooks grabbers;

    public ReachHooksUp(Hooks hooksArg)
    {
        grabbers = hooksArg;
    }

    @Override
    public void execute()
    {
        grabbers.moveVertHooks(0.5);
    }
    
}
