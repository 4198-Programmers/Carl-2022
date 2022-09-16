package frc.robot.simpleCommands.ShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class SetIntakeReverseSpeed extends CommandBase{
    Intake intake;
    @Override
    public void execute() {
        intake.setintakespeed(Constants.INTAKE_REVERSE_SPEED);
    }
}
