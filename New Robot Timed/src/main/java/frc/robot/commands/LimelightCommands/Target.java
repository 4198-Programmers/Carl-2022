package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LimelightMode;

public class Target extends CommandBase {
    Limelight limelight;
    DriveTrain driveTrain;
    double speed;
    public Target(Limelight limelight, DriveTrain driveTrain) {
        this.limelight = limelight;
        this.driveTrain = driveTrain;
        addRequirements(limelight, driveTrain);
    }

    @Override
    public void initialize() {
        limelight.setPipelineMode(LimelightMode.forceOn);
        speed = 0;
    }

    @Override
    public void execute() {
        if(limelight.hasTarget() == false){
            speed = 0.75;
        }
        else if(limelight.xOffset() > Constants.WIDE_X_OFFSET){
            speed = -0.75;
        }
        else if(limelight.xOffset() < -Constants.WIDE_X_OFFSET){
            speed = 0.75;
        }
        else if(limelight.xOffset() < Constants.WIDE_X_OFFSET){
            if(limelight.xOffset() > -Constants.WIDE_X_OFFSET){
                speed = -0.5;
                }
                else{
                    speed = 0.5;
                }
            }
        driveTrain.drive(speed, 0);
    }

    @Override
    public boolean isFinished() {
        return limelight.xOffset() < Constants.SLIM_X_OFFSET && limelight.xOffset() > -Constants.SLIM_X_OFFSET;
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.drive(0, 0);
        limelight.setPipelineMode(LimelightMode.forceOff);
    }
}
