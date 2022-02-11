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
        arm.resetAngleHooksPosition();
    }

    @Override
    public void execute() {
        arm.moveAngledHooks(Constants.ANGLE_HOOK_SPEED);
        if(isFinished() == true){
            arm.moveAngledHooks(Constants.FREEZE);
        }
    }
    @Override
    public boolean isFinished() {
        double angle = arm.getAngledHookDegree();
        return angle >= degreesDown;
    }
    @Override
    public void end(boolean interrupted) {
        arm.moveAngledHooks(Constants.FREEZE);
    }

}
