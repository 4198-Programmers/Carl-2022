package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class Spin extends CommandBase{
    DriveTrain driveTrain;
    double rotations;
    public Spin(DriveTrain driveTrain, double rotations){
        this.driveTrain = driveTrain;
        this.rotations = rotations;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        driveTrain.resetPositon();
    }
    @Override
    public void execute() {
        if(driveTrain.getPostion() < Maths.rotationConversion(rotations)){
            driveTrain.drive(0, 1);
        }
        else if(driveTrain.getPostion() >= Maths.rotationConversion(rotations)){
            driveTrain.drive(0, 0);
        }
    }
    @Override
    public boolean isFinished() {
        return(driveTrain.getPostion() >= Maths.rotationConversion(rotations));
    }
}
