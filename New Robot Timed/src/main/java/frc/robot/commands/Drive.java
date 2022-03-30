package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
    public interface DriveSpeedRetriever{
        double getDriveSpeed();
    }
    DriveTrain driveTrain;
    DriveSpeedRetriever forwardSpeedRetriever;
    DriveSpeedRetriever turningDriveSpeedRetriever;
    public Drive(DriveTrain driveTrain, DriveSpeedRetriever fowardSpeedRetriever, DriveSpeedRetriever turningSpeedRetriever){
        this.forwardSpeedRetriever = forwardSpeedRetriever;
        this.turningDriveSpeedRetriever = turningDriveSpeedRetriever;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.drive(forwardSpeedRetriever.getDriveSpeed(), turningDriveSpeedRetriever.getDriveSpeed());
    }
}