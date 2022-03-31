package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class AutoCurveCarver extends CommandBase{
    DriveTrain driver;
    double calculatedDistance;
    double degreesOfRotation;
    double travelDistance;
    boolean youDone;

    public AutoCurveCarver(DriveTrain vroomVroomSub, double distance, double degrees) {
        driver = vroomVroomSub;
        degreesOfRotation = degrees;
        travelDistance = distance;
        addRequirements(vroomVroomSub);
    }

    @Override
    public void initialize() {
        youDone = false;
    }

    @Override
    public void execute() {
        double rotationsToSpin = Maths.spinDistanceByDegree((degreesOfRotation - 10)); // subtracting 10 cause it turns
        double rotationsToMove = Maths.rotationConversion(travelDistance);
        double rotations = Math.abs(rotationsToMove) + Math.abs(rotationsToSpin);
        double position = driver.findPosition();

        if (Math.abs(position) < rotations) // just reads the values, does not care about direction
        {
            driver.greenLight(-0.3, 0.5);
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
