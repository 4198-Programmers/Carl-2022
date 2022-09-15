package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
    public interface drivespeedRetriever{
        double getSpeed();
    }
    DriveTrain drivetrain;
    drivespeedRetriever forwardDriveSpeedRetriever;
    drivespeedRetriever sideDriveSpeedRetriever;

    public Drive(drivespeedRetriever forwardDriveSpeedRetriever, drivespeedRetriever sideDriveSpeedRetriever, DriveTrain drivetrain){
        this.forwardDriveSpeedRetriever = forwardDriveSpeedRetriever;
        this.sideDriveSpeedRetriever = sideDriveSpeedRetriever;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }
    @Override
    public void execute() {
        DriveTrain.drive(forwardDriveSpeedRetriever.getSpeed(), sideDriveSpeedRetriever.getSpeed());
    }
}
