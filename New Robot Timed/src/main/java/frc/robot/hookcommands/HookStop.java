package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VertHooks;

public class HookStop extends CommandBase{

    private VertHooks intake;

    public HookStop(VertHooks shooterPathMovementArg) {
        intake = shooterPathMovementArg;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.moveVertHooks(Constants.FREEZE);
    }
    
}
