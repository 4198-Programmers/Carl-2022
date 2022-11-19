package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.IntakeThing;

public class IntakeSpeed extends CommandBase{
    IntakeThing intakething;
    double multiplier;
    double speed;
    public IntakeSpeed(IntakeThing intakething, double speed, double multiplier){
        this.intakething = intakething;
        this.speed = speed;
        this.multiplier = multiplier;

        addRequirements(intakething);
    }
    @Override
    public void execute() {
        intakething.intakeSpeed(multiplier * speed);
    }

}
