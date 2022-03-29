package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class Target extends CommandBase{
    Limelight limelight;
    DriveTrain driveTrain;
    public Target(Limelight limelight, DriveTrain driveTrain){
        this.limelight = limelight;
        this.driveTrain = driveTrain;
        addRequirements(limelight);
    }
    @Override
    public void execute() {
        if(limelight.xOffsetTarget() >= Constants.WIDE_X_OFFSET){
            driveTrain.drive(0, -1);
        }
        else if(limelight.xOffsetTarget() <= -Constants.WIDE_X_OFFSET){
            driveTrain.drive(0, 1);
        }
        else if(limelight.xOffsetTarget() >= Constants.SLIM_X_OFFSET){
            driveTrain.drive(0, -0.5);
        }
        else if(limelight.xOffsetTarget() <= -Constants.SLIM_X_OFFSET){
            driveTrain.drive(0, 0.5);
        }
        else if(limelight.xOffsetTarget() >= -Constants.SLIM_X_OFFSET && limelight.hasTarget()){
            driveTrain.drive(0, 0);
        }
        else if(limelight.xOffsetTarget() <= Constants.SLIM_X_OFFSET && limelight.hasTarget()){
            driveTrain.drive(0, 0);
        }
    }
}
