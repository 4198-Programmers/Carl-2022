package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drivetrain;

public class DriveCommand extends CommandBase {
    
    public interface speedRetriever{

        double getSpeed();
    }

    speedRetriever srForward;
    speedRetriever srTurning;
    Drivetrain drivetrain;

    public DriveCommand(speedRetriever srForward, speedRetriever srTurning, Drivetrain drivetrain){

        this.srForward = srForward;
        this.srTurning = srTurning;
        this.drivetrain = drivetrain;

        addRequirements(drivetrain);

    }

    @Override
    public void execute() {
        drivetrain.driveBoy(srTurning.getSpeed(), srForward.getSpeed());
    }

}
