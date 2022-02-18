package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LedMode;

public class ChooseLimelightLedMode extends CommandBase{
    Limelight limelight;
    LedMode mode;
    public ChooseLimelightLedMode(Limelight limelightArg, Limelight.LedMode modeArg){
        limelight = limelightArg;
        mode = modeArg;
        addRequirements(limelight);
    }
    @Override
    public void execute() {
        limelight.setLedMode(mode); 
    }

    @Override
    public boolean isFinished(){
        return limelight.getLedMode() == mode;
    }
}
