package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveForDeterminedDistance extends CommandBase{
    DriveTrain driveTrain;
    double distance;
    public DriveForDeterminedDistance(DriveTrain driveTrain, double distance){
        this.driveTrain = driveTrain;
        this.distance = distance;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        driveTrain.resetPositon();
    }
    @Override
    public void execute() {
        if(driveTrain.getPostion() < distance){
            driveTrain.drive(1, 0);
        }
        else if(driveTrain.getPostion() >= distance){
            driveTrain.drive(0, 0);
        }
    }
    @Override
    public boolean isFinished() {
        return(driveTrain.getPostion() >= distance);
    }
}
