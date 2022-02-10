package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class MoveCloserToZeroDegrees extends CommandBase {
    private Hooks arm;
    private double degreesDown;

    public MoveCloserToZeroDegrees(Hooks hooksArg) {
        arm = hooksArg;
        addRequirements(arm);
    }
    @Override
    public void initialize() {
        degreesDown = Constants.ANGLED_HOOK_DEGREES_DOWN;
    }

    @Override
    public void execute() {
        arm.moveAngledHooks(Constants.ANGLE_HOOK_SPEED);
    }
    @Override
    public boolean isFinished() {
        double angle = arm.getAngledHookDegree();
        return angle >= degreesDown;
    }

}
