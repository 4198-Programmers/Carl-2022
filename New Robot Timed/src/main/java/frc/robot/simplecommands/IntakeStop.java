package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class IntakeStop extends CommandBase{

    private Intake intake;

    public IntakeStop(Intake shooterPathMovementArg) {
        intake = shooterPathMovementArg;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.setIntakeSpeed(Constants.FREEZE);
    }
    
}
