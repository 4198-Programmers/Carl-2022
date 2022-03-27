package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Limelight.LimelightMode;

public class ChooseLimelightMode extends CommandBase {
    Limelight limelight;
    LimelightMode mode;

    public ChooseLimelightMode(Limelight limelight, LimelightMode mode) {
        this.limelight = limelight;
        this.mode = mode;
        addRequirements(limelight);
    }

    @Override
    public void execute() {
        limelight.setpipelineMode(mode);
    }

    @Override
    public boolean isFinished() {
        return (limelight.getpipelineMode() == mode);
    }
}
