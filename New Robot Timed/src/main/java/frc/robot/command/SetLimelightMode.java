package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class SetLimelightMode extends CommandBase{
    private Limelight visionSLM;
    double mode;

    public SetLimelightMode(Limelight limelightArg, double modeArg)
    {
        visionSLM = limelightArg;
        mode = modeArg;
        addRequirements(visionSLM);
    }
    @Override
    public void execute(){
        visionSLM.setPipeline(mode);
    }
    
}
