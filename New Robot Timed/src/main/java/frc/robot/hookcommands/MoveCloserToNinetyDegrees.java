package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;

public class MoveCloserToNinetyDegrees extends CommandBase {
    private AngleHooks angleHooks;

    public MoveCloserToNinetyDegrees(AngleHooks angleHooksSub) {
        angleHooks = angleHooksSub;
        addRequirements(angleHooks);
    }

    @Override
    public void execute() {
        angleHooks.moveAngledHooks(-Constants.ANGLE_HOOK_SPEED);
    }

}
