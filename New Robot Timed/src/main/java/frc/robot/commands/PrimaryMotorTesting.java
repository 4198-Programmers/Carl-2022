package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PrimaryMotor;

public class PrimaryMotorTesting extends CommandBase {

    double test;

    private PrimaryMotor primaryMotor;

    public PrimaryMotorTesting(double test, PrimaryMotor primaryMotor) {

        this.test = test;

        this.primaryMotor = primaryMotor;
        addRequirements(primaryMotor);

    }

    @Override
    public void execute() {
        primaryMotor.primaryMotorTest(test);
    }

}
