package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ResetDriveTrainPosition extends CommandBase{
    private DriveTrain vroomVroomRDTS;
    public ResetDriveTrainPosition(DriveTrain vroomVroomArgs){
        vroomVroomRDTS = vroomVroomArgs;
        addRequirements(vroomVroomRDTS);   
    }

    @Override
    public void initialize() {
        vroomVroomRDTS.resetPosition();
    }
}
