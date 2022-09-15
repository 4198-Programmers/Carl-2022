package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class drive extends CommandBase{
    public interface drivespeedRetriever{

    }
    driveTrain driveTrain;
    drivespeedRetriever forwardDriveSpeedRetriever;
    drivespeedRetriever sideDriveSpeedRetriever;
}
