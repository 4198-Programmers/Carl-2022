package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class PullVertHooksIn extends CommandBase {
    Hooks grab;
    private double distanceDown;

    public PullVertHooksIn(Hooks hooksArg) {
        grab = hooksArg;
        addRequirements(grab);

    }
    @Override
    public void initialize() {
        distanceDown = Constants.VERT_HOOK_DISTANCE_DOWN;
        grab.resetVertHooksPosition();
    }

    @Override
    public void execute() {
        grab.moveVertHooks(-Constants.VERT_HOOK_SPEED);
        if(isFinished() == true){
            grab.moveVertHooks(Constants.FREEZE);
        }
    }

    @Override
    public boolean isFinished() {
        double height = grab.getVerticalHookHeight();
        return height >= distanceDown;
    }
    @Override
    public void end(boolean interrupted) {
        grab.moveVertHooks(Constants.FREEZE);
    }
}
