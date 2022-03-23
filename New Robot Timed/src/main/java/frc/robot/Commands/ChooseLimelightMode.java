package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Limelight;

public class ChooseLimelightMode extends CommandBase{
    Limelight limelight;
    double mode;
    public ChooseLimelightMode(Limelight limelight, double mode){
        this.limelight = limelight;
        this.mode = mode;
        addRequirements(limelight);
    }
    @Override
    public void execute() {
        limelight.setpipelineMode(mode);
    }
    @Override
    public boolean isFinished(){
        return(limelight.setpipelineMode(mode) == mode);
    }
}
