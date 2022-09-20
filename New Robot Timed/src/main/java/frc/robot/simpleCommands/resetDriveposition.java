package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class resetDriveposition extends CommandBase{
    DriveTrain driveTrain;
    boolean reset;
    public resetDriveposition(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.setDrivePosition(0);
        reset = true;
    }
    @Override
    public boolean isFinished() {
        return reset;
    }
}
