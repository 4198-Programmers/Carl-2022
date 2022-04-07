package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LimelightMode;

public class Target extends CommandBase{
    Limelight limelight;
    DriveTrain driveTrain;
    public Target(Limelight limelight, DriveTrain driveTrain){
        this.limelight = limelight;
        this.driveTrain = driveTrain;
        addRequirements(limelight, driveTrain);
    }
    @Override
    public void initialize() {
        limelight.setPipelineMode(LimelightMode.forceOn);
    }
    @Override
    public void execute() {
        if(limelight.xOffset() > Constants.WIDE_X_OFFSET){
            driveTrain.drive(0, 0.5);
    }
        if(limelight.xOffset() < -Constants.WIDE_X_OFFSET){
            driveTrain.drive(0, -0.5);
        }
        if(limelight.xOffset() < Constants.WIDE_X_OFFSET){
            if(limelight.xOffset() > - Constants.WIDE_X_OFFSET){
                driveTrain.drive(0, 0.25);
            }
        }
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
