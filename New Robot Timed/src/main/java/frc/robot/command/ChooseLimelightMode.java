package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LimelightMode;

public class ChooseLimelightMode extends CommandBase{
    Limelight limelight;
    LimelightMode limeLightMode;
    public ChooseLimelightMode(Limelight limelight, LimelightMode limeLightMode){
        this.limelight = limelight;
        this.limeLightMode = limeLightMode;
        addRequirements(limelight);
    }
    @Override
    public void execute() {
        limelight.setPipelineMode(limeLightMode);
    }
}
