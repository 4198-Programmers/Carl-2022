package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class ReachVertHooksUp extends CommandBase {
    private Hooks grabbers;
    double distanceUp;

    public ReachVertHooksUp(Hooks hooksArg) {
        grabbers = hooksArg;
        addRequirements(grabbers);
    }
    @Override
    public void initialize()
    {
        grabbers.resetPosition();
        distanceUp = Constants.DISTANCE_UP;
    }

    @Override
    public void execute() {
        grabbers.moveVertHooks(Constants.VERT_HOOK_SPEED);
        if(isFinished() == true){
            grabbers.moveVertHooks(Constants.FREEZE);
        }
    }

    @Override
    public boolean isFinished() {
        double height = grabbers.getVerticalHookHeight();
        return height >= distanceUp;
    }
    
}
