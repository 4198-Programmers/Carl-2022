package frc.robot.simpleCommands.AutoShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Sensors;

public class AutoSetIntakeForwardSpeed extends CommandBase{
    Intake intake;
    Sensors sensors;
public AutoSetIntakeForwardSpeed(Intake intake){
    this.intake = intake;
    addRequirements(intake);
}
    @Override
    public void execute() {
        intake.setintakespeed(Constants.INTAKE_FORWARD_SPEED);
    }
    @Override
    public boolean isFinished() {
        return sensors.hasinSensorSeenBall();
    }
    @Override
    public void end(boolean interrupted) {
        sensors.forgetintakeBall();
        intake.setintakespeed(Constants.FREEZE);
    }
}
