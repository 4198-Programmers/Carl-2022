package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class Targeting extends CommandBase{
    Limelight limelight;
    DriveTrain vroomVroom;
    Targeting(DriveTrain drivetrainArg, Limelight limelightArg){
        vroomVroom = drivetrainArg;
        limelight = limelightArg;
        addRequirements(vroomVroom, limelight);
    }
    @Override
    public void initialize() {
        vroomVroom.resetPosition();
    }
    @Override
    public void execute(){
        if(limelight.offsetTarget < -(Constants.OFF_SET_FACTOR))
        {
            vroomVroom.greenLight(1,-1);
        }
        else if(limelight.offsetTarget > Constants.OFF_SET_FACTOR)
        {
            vroomVroom.greenLight(-1,1);
        }
        else if(isFinished ==true){
            vroomVroom.greenLight(0,0);
        }
        }
    }
    @Override
    public boolean isFinished() {
        return 
    }
    
}
