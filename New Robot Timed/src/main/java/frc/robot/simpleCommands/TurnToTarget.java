package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LimelightMode;

public class TurnToTarget extends CommandBase{
    Limelight limelight;
    DriveTrain driveTrain;
    public TurnToTarget(Limelight limelight, DriveTrain driveTrain){
        this.limelight = limelight;
        this.driveTrain = driveTrain;
        addRequirements(limelight, driveTrain);
    }
    @Override
    public void execute() {
        limelight.setPipelineMode(LimelightMode.forceOn);
        if(limelight.xOffset() > Constants.WIDE_OFFSET_TOLERANCE){
            driveTrain.autoDrive(0.5, 0);
            if(limelight.xOffset() < -Constants.WIDE_OFFSET_TOLERANCE){
                driveTrain.autoDrive(0, 0.5);
                if(limelight.xOffset() > Constants.SLIM_OFFSET_TOLERANCE){
                    driveTrain.autoDrive(0.25, 0);
                    if(limelight.xOffset() < -Constants.SLIM_OFFSET_TOLERANCE){
                        driveTrain.autoDrive(0, 0.25);
                    }
                }
            }
            }
        }
        @Override
        public boolean isFinished() {
            return limelight.xOffset() < Constants.SLIM_OFFSET_TOLERANCE && limelight.xOffset() > -Constants.SLIM_OFFSET_TOLERANCE;
        }
        @Override
        public void end(boolean interrupted) {
            driveTrain.autoDrive(0, 0);
            limelight.setPipelineMode(LimelightMode.forceOff);
        }
    }
