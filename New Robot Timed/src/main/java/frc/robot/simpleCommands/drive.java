package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class drive extends CommandBase{
    public interface drivespeedRetriever{
        double getSpeed();
    }
    driveTrain driveTrain;
    drivespeedRetriever forwardDriveSpeedRetriever;
    drivespeedRetriever sideDriveSpeedRetriever;

    public void Drive(){
        driveTrain.drive(forwardDriveSpeedRetriever.getSpeed(), sideDriveSpeedRetriever.getSpeed());
        this.forwardDriveSpeedRetriever = forwardDriveSpeedRetriever;
        this.sideDriveSpeedRetriever = sideDriveSpeedRetriever;
        addRequirements(driveTrain);
    }
}
