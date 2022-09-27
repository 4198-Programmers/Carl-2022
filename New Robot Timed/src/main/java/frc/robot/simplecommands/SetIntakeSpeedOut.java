package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

/**
 * {@link SetIntakeSpeedOut} Sets the Intake speed to push balls out of the
 * robot
 */
public class SetIntakeSpeedOut extends CommandBase {
    Intake intake;

    /**
     * {@link SetIntakeSpeedOut} Sets the Intake speed to push balls out of the
     * robot
     */
    public SetIntakeSpeedOut(Intake intakeArg) {
        intake = intakeArg;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.setIntakeSpeed(Constants.INTAKE_REVERSE_SPEED);
    }
}
