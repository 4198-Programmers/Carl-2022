package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
    public interface DriveSpeedRetriever{
        double getDriveSpeed();
    }
    DriveTrain driveTrain;
    DriveSpeedRetriever forwardRetriever;
    DriveSpeedRetriever turningRetriever;
    public Drive(DriveTrain driveTrain, DriveSpeedRetriever forwardRetriever, DriveSpeedRetriever turningRetriever){
        this.driveTrain = driveTrain;
        this.forwardRetriever = forwardRetriever;
        this.turningRetriever = turningRetriever;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.drive(forwardRetriever.getDriveSpeed(), turningRetriever.getDriveSpeed());
    }
}
