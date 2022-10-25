package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;

public class AutoAngleHooksOut extends CommandBase{
    private AngleHooks arm;
    private double position;
    private double limit;

    public AutoAngleHooksOut(AngleHooks angleHooksSub, double limit) {
        this.limit = limit;
        arm = angleHooksSub;
        addRequirements(arm);
    }

    @Override
    public void execute() {
        arm.moveAngledHooks(Constants.ANGLE_HOOK_SPEED);
        position = arm.anglePosition();
    }

    @Override
    public boolean isFinished() {
        return position >= limit;
    }
}
