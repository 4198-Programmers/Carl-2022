package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class ChooseLimelightMode extends CommandBase{
    Limelight limelight;
    double mode;
    public ChooseLimelightMode(Limelight limelightArg, double modeArg){
        limelight = limelightArg;
        mode = modeArg;
        addRequirements(limelight);
    }
    @Override
    public void execute() {
        limelight.pipeLine(mode);
    }

    @Override
    public boolean isFinished(){
        return limelight.pipeLine() == mode;
    }
}
