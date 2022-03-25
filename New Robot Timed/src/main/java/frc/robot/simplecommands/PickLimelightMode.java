package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class PickLimelightMode extends CommandBase {
    private Limelight visionSLM;
    double mode;

    public PickLimelightMode(Limelight visionSub, double modeArg) {
        visionSLM = visionSub;
        mode = modeArg;
        addRequirements(visionSLM);
    }

    @Override
    public void execute() {
        visionSLM.setPipeline(mode);
    }

    @Override
    public boolean isFinished() {
        return (visionSLM.getPipeline() == mode);
    }

}
