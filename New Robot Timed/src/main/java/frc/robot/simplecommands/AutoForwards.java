package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

/**
 * {@link AutoForwards} Move the robot straight forward according to user input.
 * Forwards is to 'Taxi Off Tarmac'
 */
public class AutoForwards extends CommandBase {
    DriveTrain driveTrain;
    boolean youDone;
    double distanceOff; // distance in inches to travel off the tarmac

    /**
     * {@link AutoForwards} Move the robot straight forward according to user input.
     * Forwards is to 'Taxi Off Tarmac'
     */
    public AutoForwards(DriveTrain driveTrainArg, double travelDistance) {
        driveTrain = driveTrainArg;
        distanceOff = travelDistance;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        youDone = false;
    }

    @Override
    public void execute() {
        double rotations = Maths.rotationConversion(distanceOff);
        double position = driveTrain.findPosition();

        if (Math.abs(position) < Math.abs(rotations)) // just reads the values, does not care about direction
        {
            driveTrain.greenLight(0, 0.5);
            System.out.println(rotations);
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
