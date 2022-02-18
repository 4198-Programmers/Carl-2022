package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
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

    }
    
}
