package frc.robot.simplecommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class Targeting extends CommandBase {
    private DriveTrain vroomVroomT;
    private Limelight visionT;
    double autoTime;

    public Targeting(DriveTrain vroomVroomSub, Limelight visionSub) {
        vroomVroomT = vroomVroomSub;
        visionT = visionSub;
        addRequirements(vroomVroomT, visionT);
    }

    @Override
    public void initialize() {
        autoTime = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("Distance", visionT.distanceToTarget());
        visionT.setPipeline(Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);

        if (visionT.xOffsetFromCenter() <= -Constants.WIDE_OFFSET_TOLERANCE) {
            vroomVroomT.greenLight(-0.25, 0);
            System.out.println("targeting left");
        } else if (visionT.xOffsetFromCenter() > Constants.WIDE_OFFSET_TOLERANCE) {
            vroomVroomT.greenLight(0.25, 0);
            System.out.println("targeting right");
        } else if (visionT.xOffsetFromCenter() <= -Constants.SLIM_OFFSET_TOLERANCE) {
            vroomVroomT.greenLight(-0.15, 0);
            System.out.println("targeting left");
        } else if (visionT.xOffsetFromCenter() > Constants.SLIM_OFFSET_TOLERANCE) {
            vroomVroomT.greenLight(0.15, 0);
            System.out.println("targeting right");
        } else {
            vroomVroomT.greenLight(Constants.FREEZE, Constants.FREEZE);
            System.out.println("I got time");
        }

    }

    @Override
    public boolean isFinished() {
        return (visionT.hasTarget() && visionT.xOffsetFromCenter() >= -Constants.SLIM_OFFSET_TOLERANCE
                && visionT.xOffsetFromCenter() < Constants.SLIM_OFFSET_TOLERANCE
                && (System.currentTimeMillis() - autoTime) >= 1500);
    }
}
