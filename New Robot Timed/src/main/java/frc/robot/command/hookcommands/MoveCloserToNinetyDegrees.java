package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class MoveCloserToNinetyDegrees extends CommandBase {
    private Hooks elbow;
    double hookDegrees = Constants.ANGLE_HOOK_DEGREES;

    public MoveCloserToNinetyDegrees(Hooks hookArg) {
        elbow = hookArg;
        addRequirements(elbow);
    }

    @Override
    public void initialize()
    {
        elbow.resetAngleHooksPosition();
    }

    @Override
    public void execute() {
        elbow.moveAngledHooks(Constants.ANGLE_HOOK_SPEED);
    }

    public boolean isFinished(){
        double endingHookAngle = elbow.getAngledHookDegree();
        return endingHookAngle >= hookDegrees;
    }
    @Override
    public void end(boolean interrupted) {
        elbow.moveAngledHooks(Constants.FREEZE);
    }
}
