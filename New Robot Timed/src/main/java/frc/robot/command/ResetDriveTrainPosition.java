package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class  ResetDriveTrainPosition extends CommandBase{
    /**still vroomVroom from robot, just used in this class(TAS)**/
    private DriveTrain vroomVroomTAS;
    public ResetDriveTrainPosition(DriveTrain vroomVroomArg){
        vroomVroomTAS = vroomVroomArg;
        addRequirements(vroomVroomTAS);
    }
    @Override
    public void initialize() {
        vroomVroomTAS.resetPosition();
    }
}
