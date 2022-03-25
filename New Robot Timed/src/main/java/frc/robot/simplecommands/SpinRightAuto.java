package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class SpinRightAuto extends CommandBase {
    DriveTrain driver;
    double calculatedDistance;
    double degreesOfRotation;
    boolean youDone;

    public SpinRightAuto(DriveTrain driveArg, double degrees) {
        driver = driveArg;
        degreesOfRotation = degrees;
        addRequirements(driveArg);
    }

    @Override
    public void initialize() {
        youDone = false;
    }

    @Override
    public void execute() {
        double rotationsToSpin = Maths.spinDistanceByDegree((degreesOfRotation - 10));  //subtracting 10 cause it turns too far consistently
        double position = driver.findPosition();

        if (Math.abs(position) < Math.abs(rotationsToSpin)) // just reads the values, does not care about direction
        {
            driver.greenLight(0.5, 0);
        } else {
            driver.greenLight(0, 0);
            youDone = true;
            System.out.println("Successfully Completed");

        }
    }

    @Override
    public boolean isFinished() {
        return youDone;
    }

}
