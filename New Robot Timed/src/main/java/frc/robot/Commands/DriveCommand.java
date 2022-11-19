package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
    
    public interface speedRetriever{

        double getSpeed();
    }

    speedRetriever srForward;
    
}
