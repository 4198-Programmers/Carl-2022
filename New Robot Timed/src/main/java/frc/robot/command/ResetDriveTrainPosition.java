package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
<<<<<<< Updated upstream

public class  ResetDriveTrainPosition extends CommandBase{
    /**still vroomVroom from robot, just used in this class(TAS)**/
=======
public class ResetDriveTrainPosition extends CommandBase{
    /**Still vroomVroom from robot, just used in this class(TAS) **/
>>>>>>> Stashed changes
    private DriveTrain vroomVroomTAS;
    public ResetDriveTrainPosition(DriveTrain vroomVroomArg){
        vroomVroomTAS = vroomVroomArg;
        addRequirements(vroomVroomTAS);
    }
    @Override
<<<<<<< Updated upstream
    public void initialize() {
        vroomVroomTAS.resetPosition();
    }
}
=======
    public void initialize(){
        vroomVroomTAS.resetPosition();
    }
}
>>>>>>> Stashed changes
