package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VertHooks;

public class PullVertHooksIn extends CommandBase {
    VertHooks grab;
    private double distanceDown;

    public PullVertHooksIn(VertHooks hooksArg) {
        grab = hooksArg;
        addRequirements(grab);

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
