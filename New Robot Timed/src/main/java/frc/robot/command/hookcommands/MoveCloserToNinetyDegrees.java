package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class MoveCloserToNinetyDegrees extends CommandBase{
    private Hooks elbow;
    

    public MoveCloserToNinetyDegrees(Hooks hookArg)
    {
        elbow = hookArg;
        addRequirements(elbow);
    }
    @Override
    public void initialize()
    {
        elbow.resetPosition();
        double hookDegrees = Constants.ANGLE_DEGREES;
        boolean youDone = false;
    }
    @Override
    public void execute()
    {
        elbow.moveAngledHooks(Constants.ANGLE_HOOK_SPEED);
    }
    
}
