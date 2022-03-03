package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class Dance extends CommandBase{
    Hooks hooks;
    public Dance(Hooks hooks) {
    this.hooks = hooks;
    addRequirements(hooks);
    }
    @Override
    public void initialize() {
        hooks.resetPositionHooks();
    }
    @Override
    public void execute() {
        hooks.vertHookExtend(Constants.VERT_HOOK_DANCE_HEIGHT);
        if(hooks.currentPositionVertHooks() >= Constants.VERT_HOOK_DANCE_HEIGHT - 0.01 && hooks.currentPositionVertHooks() <= 45){
            hooks.vertHookExtend(0);
        }
        hooks.angledHookMove(Constants.ANGLED_HOOK_DANCE_ANGLE);
        if(hooks.currentPositionAngledHooks() >= Constants.ANGLED_HOOK_DANCE_ANGLE - 0.01 && hooks.currentPositionAngledHooks() <= Constants.ANGLED_HOOK_DANCE_ANGLE){
            hooks.angledHookMove(0);
        }
        if(isFinished() == true){
            hooks.resetPositionHooks();
        }
    }
    @Override
    public boolean isFinished() {
        return hooks.currentPositionAngledHooks() == 0 && hooks.currentPositionVertHooks() ==0;
    }
}
