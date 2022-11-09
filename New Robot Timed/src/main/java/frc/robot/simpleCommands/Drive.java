package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
    public interface drivespeedRetriever{
        double getSpeed();
    }

    DriveTrain drivetrain;
    drivespeedRetriever forwardRetriever;
    drivespeedRetriever sideRetriever;

    public Drive(drivespeedRetriever forwardRetriever, drivespeedRetriever sideRetriever, DriveTrain drivetrain){
        this.forwardRetriever = forwardRetriever;
        this.sideRetriever = sideRetriever;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain); 
    }
    @Override
    public void execute() {
        drivetrain.alldrive(forwardRetriever.getSpeed(), -(sideRetriever.getSpeed()));
    }
}