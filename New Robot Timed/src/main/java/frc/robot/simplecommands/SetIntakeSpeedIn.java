package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class SetIntakeSpeedIn extends CommandBase {
    private Intake intake;

    public SetIntakeSpeedIn(Intake intakeSub) {
        intake = intakeSub;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.setIntakeSpeed(Constants.INTAKE_FORWARD_SPEED);
    }

}
