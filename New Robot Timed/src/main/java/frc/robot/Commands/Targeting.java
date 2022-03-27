package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Limelight.LimelightMode;

public class Targeting extends CommandBase {
    Limelight limelight;
    DriveTrain driveTrain;

    public Targeting(Limelight limelight, DriveTrain driveTrain) {
        this.limelight = limelight;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain, limelight);
    }

    @Override
    public void initialize() {
        limelight.setpipelineMode(LimelightMode.forceOn);
        driveTrain.resetPosition();
    }

    @Override
    public void execute() {
        if (limelight.xOffset() >= Constants.X_OFFSET_TARGETING_TO_THE_RIGHT && limelight.hasTarget() != true) {
            driveTrain.greenLight(-1, 0);
        } else if (limelight.xOffset() <= Constants.X_OFFSET_TARGETING_TO_THE_LEFT && limelight.hasTarget() != true) {
            driveTrain.greenLight(1, 0);
        } else if (limelight.hasTarget() == true && limelight.xOffset() <= Constants.X_OFFSET_TARGETING_TO_THE_RIGHT) {
            driveTrain.greenLight(-0.5, 0);
        } else if (limelight.hasTarget() == true && limelight.xOffset() >= Constants.X_OFFSET_TARGETING_TO_THE_LEFT) {
            driveTrain.greenLight(0.5, 0);
        } else if (limelight.hasTarget() == true
                && limelight.xOffset() <= Constants.X_OFFSET_TARGETING_TO_THE_RIGHT_SLIM
                && limelight.xOffset() >= Constants.X_OFFSET_TARGETING_TO_THE_LEFT_SLIM) {
            driveTrain.greenLight(0, 0);
        }
    }

    @Override
    public boolean isFinished() {
        return (limelight.hasTarget() == true && limelight.xOffset() <= Constants.X_OFFSET_TARGETING_TO_THE_RIGHT_SLIM
                && limelight.xOffset() >= Constants.X_OFFSET_TARGETING_TO_THE_LEFT_SLIM);
    }
}
