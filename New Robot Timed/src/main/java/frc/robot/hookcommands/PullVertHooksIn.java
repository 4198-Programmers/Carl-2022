package frc.robot.hookcommands;

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
    }

    @Override
    public void execute() {
        grab.moveVertHooks(-Constants.VERT_HOOK_SPEED);
    }

    @Override
    public boolean isFinished() {
        double height = grab.getVerticalHookHeight();
        return height >= distanceDown;
    }
}
