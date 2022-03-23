package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.DriveTrain;
import frc.Subsystems.Limelight;
import frc.robot.Constants;

public class Targeting extends CommandBase{
    Limelight limelight;
    DriveTrain driveTrain;
    public Targeting(Limelight limelight, DriveTrain driveTrain){
        this.limelight = limelight;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain, limelight);
    }
    @Override
    public void initialize() {
        limelight.pipelineMode(1);
        driveTrain.resetPosition();
    }
    @Override
    public void execute() {
        if(limelight.xOffset() >= Constants.X_OFFSET_TARGETING_TO_THE_RIGHT  && limelight.hasTarget() != 1){
            driveTrain.greenLight(-1, 0);
        }
        else if(limelight.xOffset() >= Constants.X_OFFSET_TARGETING_TO_THE_LEFT && limelight.hasTarget() != 1){
            driveTrain.greenLight(1, 0);
        }
    }
}
