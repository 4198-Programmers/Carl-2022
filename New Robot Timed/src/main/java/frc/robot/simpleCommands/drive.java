package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class drive extends CommandBase{
    public interface drivespeedRetriever{
        double getSpeed();
    }
    driveTrain drivetrain;
    drivespeedRetriever forwardDriveSpeedRetriever;
    drivespeedRetriever sideDriveSpeedRetriever;

    public drive(drivespeedRetriever forwardDriveSpeedRetriever, drivespeedRetriever sideDriveSpeedRetriever, driveTrain drivetrain){
        this.forwardDriveSpeedRetriever = forwardDriveSpeedRetriever;
        this.sideDriveSpeedRetriever = sideDriveSpeedRetriever;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }
    @Override
    public void execute() {
        drivetrain.drive(forwardDriveSpeedRetriever.getSpeed(), sideDriveSpeedRetriever.getSpeed());
    }
}
