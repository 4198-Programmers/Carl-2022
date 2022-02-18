package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class ChooseLEDMode extends CommandBase{
    Limelight limelight;
    public ChooseLEDMode(Limelight limelightArg){
        limelight = limelightArg;
        addRequirements(limelight);
    }
    @Override
    public void execute() {
        
    }
}
