package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;

public class MoveCloserToZeroDegrees extends CommandBase {
    private AngleHooks arm;

    public MoveCloserToZeroDegrees(AngleHooks angleHooksSub) {
        arm = angleHooksSub;
        addRequirements(arm);
    }
    @Override
    public void initialize() {
        
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
        return true;
    }

}
