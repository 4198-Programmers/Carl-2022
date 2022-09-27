package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

/**
 * {@link AutoBackwards} Takes in a distance from the user to move straight
 * backwards, as well as the current DriveTrainSub
 */
public class AutoBackwards extends CommandBase {
    DriveTrain driveTrain;
    boolean youDone;
    double distanceOff;

    /**
     * {@link AutoBackwards} Takes in a distance from the user to move straight
     * backwards, as well as the current DriveTrainSub
     */
    public AutoBackwards(DriveTrain driveTrainArg, double travelDistance) {
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
            driveTrain.greenLight(0, -0.25);
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
