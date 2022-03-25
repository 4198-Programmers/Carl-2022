package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveTrain;

public class Drive extends CommandBase{
    public interface ForwardDriveSpeedRetriever {
        double getDriveSpeed();
    }
    public interface TurningDriveSpeedRetriever {
        double getDriveSpeed();
    }
    DriveTrain driveTrain;
    ForwardDriveSpeedRetriever forwardDriveSpeedRetriever;
    TurningDriveSpeedRetriever turningDriveSpeedRetriever;
    public Drive(DriveTrain driveTrain, ForwardDriveSpeedRetriever forwardDriveSpeedRetriever, TurningDriveSpeedRetriever turningDriveSpeedRetriever){
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
