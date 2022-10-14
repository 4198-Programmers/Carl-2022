package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

/**
 * {@link PickLimelightMode} User inputs Limelight mode they wish to set, values
 * can be found in {@link Constants}
 */
public class PickLimelightMode extends CommandBase {
    Limelight limelight;
    double mode;

    /**
     * {@link PickLimelightMode} User inputs Limelight mode they wish to set, values
     * can be found in {@link Constants}
     */
    public PickLimelightMode(Limelight limelightArg, double modeArg) {
        limelight = limelightArg;
        mode = modeArg;
        addRequirements(limelight);
    }

    @Override
    public void execute() {
        limelight.setPipeline(mode);
    }

    @Override
    public boolean isFinished() {
        return (limelight.getPipeline() == mode);
    }
}
