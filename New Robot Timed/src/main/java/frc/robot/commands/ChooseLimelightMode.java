package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Limelight.LimelightMode;

public class ChooseLimelightMode extends CommandBase{
    Limelight limelight;
    LimelightMode mode;
    public ChooseLimelightMode(Limelight limelightArg, Limelight.LimelightMode modeArg){
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
        return limelight.getLimelightMode() == mode;
    }
}
