package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

/**
 * {@link AutoCurveCarver} Works to curve instead of travelling directly to a
 * point
 * Still in testing phases, does not work consistently
 */
public class AutoCurveCarver extends CommandBase {
    DriveTrain driveTrain;
    double calculatedDistance;
    double degreesOfRotation;
    double travelDistance;
    boolean youDone;

    /**
     * {@link AutoCurveCarver} Works to curve instead of travelling directly to a
     * point
     * Still in testing phases, does not work consistently
     */
    public AutoCurveCarver(DriveTrain driveTrainArg, double distance, double degrees) {
        driveTrain = driveTrainArg;
        degreesOfRotation = degrees;
        travelDistance = distance;
        addRequirements(driveTrain);
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
        double position = driveTrain.findPosition();

        if (Math.abs(position) < rotations) // just reads the values, does not care about direction
        {
            driveTrain.greenLight(-0.3, 0.5);
        } else {
            driveTrain.greenLight(0, 0);
            youDone = true;
            System.out.println("Successfully Completed");

        }
    }

    @Override
    public boolean isFinished() {
        return youDone;
    }

}
