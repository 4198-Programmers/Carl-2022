package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DoNotMove extends CommandBase{
    DriveTrain driveTrain;
    public DoNotMove(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.greenLight(0, 0);
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
