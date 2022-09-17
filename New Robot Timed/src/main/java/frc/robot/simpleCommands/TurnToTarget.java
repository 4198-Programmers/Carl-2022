package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class TurnToTarget extends CommandBase{
    DriveTrain drivetrain;
    Limelight limelight;

    public TurnToTarget(DriveTrain drivetrain, Limelight limelight){
        this.drivetrain = drivetrain;
        this.limelight = limelight;
        addRequirements(drivetrain, limelight);
    }
    @Override
    public void initialize() {
        drivetrain.setDrivePosition(0);
        limelight.setPipeline(3); // pipeline 3 = forceOn
    }
    @Override
    public void execute() {
    if(limelight.xOffset() > Constants.WIDE_OFFSET_TOLERANCE){
        drivetrain.autoDrive(0.5, 0);
    }
    else if(limelight.xOffset() < -Constants.WIDE_OFFSET_TOLERANCE){
        drivetrain.autoDrive(0, 0.5);
    }
    else if(limelight.xOffset() > Constants.SLIM_OFFSET_TOLERANCE){
        drivetrain.autoDrive(0.25, 0);
    }
    else if(limelight.xOffset() < -Constants.SLIM_OFFSET_TOLERANCE){
        drivetrain.autoDrive(0, 0.25);
    }
    else{
        drivetrain.autoDrive(1, 0);
    }
}
@Override
public boolean isFinished() {
    return limelight.xOffset() > -Constants.SLIM_OFFSET_TOLERANCE && limelight.xOffset() < Constants.SLIM_OFFSET_TOLERANCE;
}
@Override
public void end(boolean interrupted) {
    drivetrain.autoDrive(0, 0);
    limelight.setPipeline(1);  //  pipeline 1 = forceoff
}
}
