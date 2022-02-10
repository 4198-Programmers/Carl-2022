package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class  ResetDriveTrainPosition extends CommandBase{
    /**still vroomVroom from robot, just used in this class(RDTP)**/
    private DriveTrain vroomVroomRDTP;

    public ResetDriveTrainPosition(DriveTrain vroomVroomArg){
        vroomVroomRDTP = vroomVroomArg;
        addRequirements(vroomVroomRDTP);
    }

    @Override
    public void initialize() {
        vroomVroomRDTP.resetPosition();
    }
}
