package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

/**
 * {@link AutoForwardsFast} Move the robot forward according to user input
 * faster than {@link AutoForwards}
 * This could be used to 'Taxi Off Tarmac' faster than it is currently moving,
 * without altering commands,
 * or using the same command twice in a sequence
 */
public class AutoForwardsFast extends CommandBase {
    DriveTrain driveTrain;
    boolean youDone;
    double distanceOff;

    /**
     * {@link AutoForwardsFast} Move the robot forward according to user input
     * faster than {@link AutoForwards}
     * This could be used to 'Taxi Off Tarmac' faster than it is currently moving,
     * without altering commands,
     * or using the same command twice in a sequence
     */
    public AutoForwardsFast(DriveTrain driveTrainArg, double travelDistance) {
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
            driveTrain.greenLight(0, 0.75);
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