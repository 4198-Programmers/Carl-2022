package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
    public interface DriveSpeedRetriever{
        double getDriveSpeed();
    }
    DriveTrain driveTrain;
    DriveSpeedRetriever forwardSpeedRetriever;
    DriveSpeedRetriever turningSpeedRetriever;
    public Drive(DriveTrain driveTrain, DriveSpeedRetriever forwardSpeedRetriever, DriveSpeedRetriever turningSpeedRetriever){
        this.driveTrain = driveTrain;
        this.forwardSpeedRetriever = forwardSpeedRetriever;
        this.turningSpeedRetriever = turningSpeedRetriever;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.drive(forwardSpeedRetriever.getDriveSpeed(), turningSpeedRetriever.getDriveSpeed());
    }
}