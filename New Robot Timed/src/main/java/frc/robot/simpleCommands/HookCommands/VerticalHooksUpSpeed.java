package frc.robot.simpleCommands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VerticalHooks;

public class VerticalHooksUpSpeed extends CommandBase{
    VerticalHooks verticalHooks;
    public VerticalHooksUpSpeed(VerticalHooks verticalHooks){
        this.verticalHooks = verticalHooks;
        addRequirements(verticalHooks);
    }
    @Override
    public void execute() {
        verticalHooks.setVerticalhookSpeed(Constants.VERTICAL_HOOK_SPEED);
    }
    @Override
    public void end(boolean interrupted) {
        verticalHooks.setVerticalhookSpeed(Constants.FREEZE);
    }
}
