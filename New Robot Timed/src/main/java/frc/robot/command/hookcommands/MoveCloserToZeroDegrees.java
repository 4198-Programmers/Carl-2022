package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class MoveCloserToZeroDegrees extends CommandBase {
    private Hooks arm;

    public MoveCloserToZeroDegrees(Hooks hooksArg) {
        arm = hooksArg;
        addRequirements(arm);
    }

    @Override
    public void execute() {
        arm.moveAngledHooks(Constants.ANGLE_HOOK_SPEED);
    }

}
