package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;

public class AutoAngleHooksIn extends CommandBase{
    private AngleHooks arm;
    private double position;
    private double limit;
    
    public AutoAngleHooksIn(AngleHooks angleHooksSub, double limit) {
        arm = angleHooksSub;
        this.limit = limit;
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
