package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SetDriveSpeed extends CommandBase{
    DriveTrain driveTrain;
    boolean done;
    public SetDriveSpeed(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.drive(0, 0);
        done = true;
    }
    @Override
    public boolean isFinished() {
        return done == true;
    }

}