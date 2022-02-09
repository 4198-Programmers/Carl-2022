package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class PullVertHooksIn extends CommandBase {
    Hooks grab;

    public PullVertHooksIn(Hooks hooksArg) {
        grab = hooksArg;
        addRequirements(grab);
    }

    @Override
    public void execute() {
        grab.moveVertHooks(-Constants.VERT_HOOK_SPEED);
    }

}
