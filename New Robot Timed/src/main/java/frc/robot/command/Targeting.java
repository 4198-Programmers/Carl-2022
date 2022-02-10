package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class Targeting extends CommandBase {
    private DriveTrain vroomVroomT;
    private Limelight visionT;

    public Targeting(DriveTrain driveTrainArg, Limelight limelightArg) {
        vroomVroomT = driveTrainArg;
        visionT = limelightArg;
        addRequirements(vroomVroomT, visionT);
    }

    @Override
    public void execute() {
        if (!visionT.hasTarget() || visionT.xOffsetFromCenter() < -Constants.OFFSET_TOLERANCE_INCHES) {
            vroomVroomT.greenLight(-0.35, 0);
            System.out.println("targeting left");
        } else if (visionT.xOffsetFromCenter() > Constants.OFFSET_TOLERANCE_INCHES) {
            vroomVroomT.greenLight(0.35, 0);
            System.out.println("targeting right");
        } else {
            vroomVroomT.greenLight(Constants.FREEZE, Constants.FREEZE);
            System.out.println("I am frozen");
        }

    }

    @Override
    public boolean isFinished() {
        return (visionT.hasTarget() && visionT.xOffsetFromCenter() > -0.1 && visionT.xOffsetFromCenter() < 0.1);
    }
}
