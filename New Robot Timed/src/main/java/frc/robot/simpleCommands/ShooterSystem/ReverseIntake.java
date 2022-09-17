package frc.robot.simpleCommands.ShooterSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class ReverseIntake extends CommandBase{
    Intake intake;
    public ReverseIntake(Intake intake){
        this.intake = intake;
        addRequirements(intake);
    }
    @Override
    public void execute() {
        intake.setintakespeed(Constants.INTAKE_REVERSE_SPEED);
    }
    @Override
    public void end(boolean interrupted) {
        intake.setintakespeed(Constants.FREEZE);
    }
}
