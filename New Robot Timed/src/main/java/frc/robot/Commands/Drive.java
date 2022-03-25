package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveTrain;

public class Drive extends CommandBase{
    public interface DriveSpeedRetriever {
        double getDriveSpeed();
    }
    DriveTrain driveTrain;
    DriveSpeedRetriever forwardDriveSpeedRetriever;
    DriveSpeedRetriever turningDriveSpeedRetriever;
    public Drive(DriveTrain driveTrain, DriveSpeedRetriever forwardDriveSpeedRetriever, DriveSpeedRetriever turningDriveSpeedRetriever){
        this.forwardDriveSpeedRetriever = forwardDriveSpeedRetriever;
        this.turningDriveSpeedRetriever = turningDriveSpeedRetriever;
        this.driveTrain = driveTrain;

        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.greenLight(forwardDriveSpeedRetriever.getDriveSpeed(), turningDriveSpeedRetriever.getDriveSpeed());
    }
}
