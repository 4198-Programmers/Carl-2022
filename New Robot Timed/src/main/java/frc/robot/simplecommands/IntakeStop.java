package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

/** {@link IntakeStop} Specifically sets Intake to 0 */
public class IntakeStop extends CommandBase {
    private Intake intake;
    boolean done;

    /** {@link IntakeStop} Specifically sets Intake to 0 */
    public IntakeStop(Intake intakeArg) {
        intake = intakeArg;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        done = false;
    }

    @Override
    public void execute() {
        intake.setIntakeSpeed(Constants.FREEZE);
        done = true;
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}