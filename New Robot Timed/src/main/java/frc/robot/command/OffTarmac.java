package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

<<<<<<< Updated upstream
public class OffTarmac extends CommandBase{
=======
/** Autonomous movement used to exit the tarmac during Autonomous */
public class OffTarmac extends CommandBase {
>>>>>>> Stashed changes
    private DriveTrain vroomVroomOT;
    boolean youDone;
    double distanceOff;

<<<<<<< Updated upstream
    OffTarmac(DriveTrain driveTrainArg)
    {
=======
    /** Pulls in the current DriveTrain instance to use in the specific class */
    OffTarmac(DriveTrain driveTrainArg) {
>>>>>>> Stashed changes
        vroomVroomOT = driveTrainArg;
    }

    @Override
    public void initialize() {
        distanceOff = 40;
        youDone = false;
    }

    @Override
    public void execute() {
        double rotations = Maths.rotationConversion(distanceOff);
        double position = vroomVroomOT.findPosition();

        if (position < rotations) {
            vroomVroomOT.greenLight(-1, 0);
        } else {
            vroomVroomOT.greenLight(0, 0);
            youDone = true;

        }
    }

    @Override
    public boolean isFinished() {
        return youDone;
    }

}
