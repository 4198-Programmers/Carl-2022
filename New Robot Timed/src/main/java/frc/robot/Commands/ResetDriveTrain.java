package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveTrain;

public class ResetDriveTrain extends CommandBase{
    DriveTrain driveTrain;
    boolean youdone;
    public ResetDriveTrain(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        youdone = false;
    }
    @Override
    public void execute() {
        driveTrain.resetPosition();
        youdone = true;
    }
    @Override
    public boolean isFinished() {
        return youdone;
    }

}
