package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
    public interface DriveSpeedRetriever{
        double getDriveSpeed();
    }
    DriveTrain driveTrain;
    DriveSpeedRetriever forwarddriveSpeedRetriever;
    DriveSpeedRetriever turningDriveSpeedRetriever;
    public Drive(DriveTrain driveTrain, DriveSpeedRetriever forwardAndBackwardRetriever, DriveSpeedRetriever leftAndRightRetriever){
        this.driveTrain = driveTrain;
        forwarddriveSpeedRetriever = forwardAndBackwardRetriever;
        turningDriveSpeedRetriever = leftAndRightRetriever;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.drive(forwarddriveSpeedRetriever.getDriveSpeed(), turningDriveSpeedRetriever.getDriveSpeed());
    }
}
