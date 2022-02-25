package frc.robot.commands.ShootingCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LimelightMode;

public class Targeting extends CommandBase{
    Limelight limelight;
    DriveTrain vroomVroom;
    public Targeting(DriveTrain drivetrainArg, Limelight limelightArg){
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
        limelight.setPipelineMode(LimelightMode.forceOn);
        if( !limelight.hasTarget() || limelight.xOffsetTarget() < - Constants.OFF_SET_FACTOR || limelight.xOffsetTarget() > Constants.OFF_SET_FACTOR){
            if(limelight.xOffsetTarget() < - Constants.OFF_SET_FACTOR){
                vroomVroom.greenLight(-0.35, 0);
            }
            if(limelight.xOffsetTarget() > Constants.OFF_SET_FACTOR){
                vroomVroom.greenLight(0.35, 0);
            }
        }
    }
    @Override
    public boolean isFinished() {
        return limelight.hasTarget() && limelight.xOffsetTarget() > -(Constants.OFF_SET_FACTOR) && limelight.xOffsetTarget() < Constants.OFF_SET_FACTOR;
    }
    @Override
    public void end(boolean interrupted) {
        limelight.setPipelineMode(LimelightMode.forceOff);
    }
    
}
