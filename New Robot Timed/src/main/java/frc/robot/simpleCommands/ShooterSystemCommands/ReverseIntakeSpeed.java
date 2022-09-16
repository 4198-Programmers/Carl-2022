package frc.robot.simpleCommands.ShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class ReverseIntakeSpeed extends CommandBase{
    Intake intake;
    public ReverseIntakeSpeed(Intake intake){
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
