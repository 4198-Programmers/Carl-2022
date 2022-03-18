package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;

public class MoveCloserToZeroDegrees extends CommandBase {
    private AngleHooks arm;

    public MoveCloserToZeroDegrees(AngleHooks hooksArg) {
        arm = hooksArg;
        addRequirements(arm);
    }

    @Override
    public void execute() {
        arm.moveAngledHooks(Constants.ANGLE_HOOK_SPEED);
    }


}
