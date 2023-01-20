package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SecondaryMotor;

public class SecondaryMotorTesting extends CommandBase {

    double test;

    private SecondaryMotor secondaryMotor;

    public SecondaryMotorTesting(double test, SecondaryMotor secondaryMotor) {

        this.test = test;

        this.secondaryMotor = secondaryMotor;
        addRequirements(secondaryMotor);

    }

    @Override
    public void execute() {
        secondaryMotor.secondaryMotorTest(test);
    }

}