package frc.robot.simpleCommands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VerticalHooks;

public class VerticalHooksDown extends CommandBase{
    VerticalHooks verticalHooks;
    public VerticalHooksDown(VerticalHooks verticalHooks){
        this.verticalHooks = verticalHooks;
        addRequirements(verticalHooks);
    }
    @Override
    public void execute() {
        verticalHooks.setVerticalhookSpeed(-Constants.VERTICAL_HOOK_SPEED);
        System.out.println(verticalHooks.getverticalHookPosition());
    }
    @Override
    public void end(boolean interrupted) {
        verticalHooks.setVerticalhookSpeed(Constants.FREEZE);
    }
}