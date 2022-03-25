package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;

public class MoveCloserToNinetyDegrees extends CommandBase {
    private AngleHooks elbow;

    public MoveCloserToNinetyDegrees(AngleHooks angleHooksSub) {
        elbow = angleHooksSub;
        addRequirements(elbow);
    }

    @Override
    public void execute() {
        elbow.moveAngledHooks(-Constants.ANGLE_HOOK_SPEED);
    }

}
