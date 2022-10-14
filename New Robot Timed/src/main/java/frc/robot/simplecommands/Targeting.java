package frc.robot.simplecommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

/**
 * {@link Targeting} Uses limelight to spin the robot to center on the VISIBLE
 * targets
 */
// If targeting is not working be sure to check that the robot can actually see
// the targets at 10.41.98.11:5800 while connected to the limelight
public class Targeting extends CommandBase {
    DriveTrain driveTrain;
    Limelight limelight;
    double autoTime;

    /**
     * {@link Targeting} Uses limelight to spin the robot to center on the VISIBLE
     * targets
     */
    public Targeting(DriveTrain driveTrainArg, Limelight limelightArg) {
        driveTrain = driveTrainArg;
        limelight = limelightArg;
        addRequirements(driveTrain, limelight);
    }

    @Override
    public void initialize() {
        autoTime = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("Distance", limelight.distanceToTarget());
        limelight.setPipeline(Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);

        if (limelight.xOffsetFromCenter() <= -Constants.WIDE_OFFSET_TOLERANCE) {
            driveTrain.greenLight(-0.25, 0);
            System.out.println("targeting left");
        } else if (limelight.xOffsetFromCenter() > Constants.WIDE_OFFSET_TOLERANCE) {
            driveTrain.greenLight(0.25, 0);
            System.out.println("targeting right");
        } else if (limelight.xOffsetFromCenter() <= -Constants.SLIM_OFFSET_TOLERANCE) {
            driveTrain.greenLight(-0.15, 0);
            System.out.println("targeting left");
        } else if (limelight.xOffsetFromCenter() > Constants.SLIM_OFFSET_TOLERANCE) {
            driveTrain.greenLight(0.15, 0);
            System.out.println("targeting right");
        } else {
            driveTrain.greenLight(Constants.FREEZE, Constants.FREEZE);
            System.out.println("I got time");
        }

    }

    @Override
    public boolean isFinished() {
        return (limelight.hasTarget() && limelight.xOffsetFromCenter() >= -Constants.SLIM_OFFSET_TOLERANCE
                && limelight.xOffsetFromCenter() < Constants.SLIM_OFFSET_TOLERANCE
                && (System.currentTimeMillis() - autoTime) >= 1500);
    }
}
