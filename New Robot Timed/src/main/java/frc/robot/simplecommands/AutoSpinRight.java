package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

/**
 * {@link AutoSpinRight} Takes in user input in degrees out of 360, to turn the
 * robot to the right oriented from the Intake as 'front'
 */
public class AutoSpinRight extends CommandBase {
    DriveTrain driveTrain;
    double calculatedDistance;
    double degreesOfRotation;
    boolean youDone;

    /**
     * {@link AutoSpinRight} Takes in user input in degrees out of 360, to turn the
     * robot to the right oriented from the Intake as 'front'
     */
    public AutoSpinRight(DriveTrain driveTrainArg, double degrees) {
        driveTrain = driveTrainArg;
        degreesOfRotation = degrees;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        youDone = false;
    }

    @Override
    public void execute() {
        double rotationsToSpin = Maths.spinDistanceByDegree((degreesOfRotation - 10)); // subtracting 10 cause it turns too far consistently
        double position = driveTrain.findPosition();

        if (Math.abs(position) < Math.abs(rotationsToSpin)) // just reads the values, does not care about direction
        {
            driveTrain.greenLight(0.5, 0);
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
