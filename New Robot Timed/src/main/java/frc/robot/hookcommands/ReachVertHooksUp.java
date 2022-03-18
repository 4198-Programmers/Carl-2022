package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VertHooks;

public class ReachVertHooksUp extends CommandBase {
    private VertHooks grabbers;
    double distanceUp;

    public ReachVertHooksUp(VertHooks hooksArg) {
        grabbers = hooksArg;
        addRequirements(grabbers);
    }

    @Override
    public void initialize() {
        grabbers.resetHookPosition();
        distanceUp = Constants.VERT_HOOK_DISTANCE_UP;
    }

    @Override
    public void execute() {
        grabbers.moveVertHooks(Constants.VERT_HOOK_SPEED);
    }

    @Override
    public boolean isFinished() {
        double height = grabbers.getVerticalHookHeight();
        return height >= distanceUp;
    }

}
