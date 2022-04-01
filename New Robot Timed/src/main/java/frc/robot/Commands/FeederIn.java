package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Sensors;

public class FeederIn extends CommandBase {
    Intake intake;
    Sensors sensors;

    public FeederIn(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        if (!sensors.isBallInFeed()) {
            intake.intake(Constants.FEEDER_INTAKE_SPEED);
        } else {
            intake.intake(0);
        }
    }

@Override
public void end(boolean interrupted) {
    intake.intake(0);
}

}
