package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LimelightMode;

public class ChooseLimeLightMode extends CommandBase {
    Limelight limelight;
    LimelightMode mode;

    public ChooseLimeLightMode(Limelight limelight, LimelightMode mode) {
        this.limelight = limelight;
        this.mode = mode;
    }

    @Override
    public void execute() {
        limelight.setPipelineMode(mode);
    }
}
