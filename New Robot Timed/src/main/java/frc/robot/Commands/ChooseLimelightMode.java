package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Limelight;

public class ChooseLimelightMode extends CommandBase{
    Limelight limelight;
    public ChooseLimelightMode(Limelight limelight){
        this.limelight = limelight;
        addRequirements(limelight);
    }
    @Override
    public void execute() {
        
    }
}
