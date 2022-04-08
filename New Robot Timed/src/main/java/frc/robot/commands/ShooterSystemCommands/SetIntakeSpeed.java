package frc.robot.commands.ShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem.Intake;

public class SetIntakeSpeed extends CommandBase {
    Intake intake;
    double speed;

    public SetIntakeSpeed(Intake intake, double speed) {
        this.intake = intake;
        this.speed = speed;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.setSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setSpeed(0);
    }
}
