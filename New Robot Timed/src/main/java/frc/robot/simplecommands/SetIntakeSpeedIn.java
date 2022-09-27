package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

/** {@link SetIntakeSpeedIn} Sets Intake to push balls further into the robot */
public class SetIntakeSpeedIn extends CommandBase {
    Intake intake;
    boolean youDone;
    double autoTime;

    /** {@link SetIntakeSpeedIn} Sets Intake to push balls further into the robot */
    public SetIntakeSpeedIn(Intake intakeArg) {
        intake = intakeArg;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        youDone = false;
        autoTime = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        intake.setIntakeSpeed(Constants.INTAKE_FORWARD_SPEED);
        youDone = true;
    }

    @Override
    public boolean isFinished() {
        return (youDone && (System.currentTimeMillis() - autoTime) >= 250);
    }
}