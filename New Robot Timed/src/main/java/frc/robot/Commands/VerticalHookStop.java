package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.VerticalHooks;

public class VerticalHookStop extends CommandBase {
    VerticalHooks verticalHooks;
    public VerticalHookStop(VerticalHooks verticalHooks){
        this.verticalHooks = verticalHooks;
        addRequirements(verticalHooks);
    }
    @Override
    public void execute() {
        verticalHooks.verticalHookMove(0);
    }
}
