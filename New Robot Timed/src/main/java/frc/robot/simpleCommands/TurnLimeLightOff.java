package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class TurnLimeLightOff extends CommandBase{
    Limelight limelight;
    double limelightmode;
    boolean limelightoff;
    public TurnLimeLightOff(Limelight limelight, double limelightmode){
        this.limelight = limelight;
        this.limelightmode = limelightmode;
        addRequirements(limelight);
    }
    @Override
    public void execute() {
        limelight.setPipeline(limelightmode);
        limelightoff = true;
        System.out.println(limelight.getPipeline());
    }
    @Override
    public boolean isFinished() {
        return limelightoff;
    }
}