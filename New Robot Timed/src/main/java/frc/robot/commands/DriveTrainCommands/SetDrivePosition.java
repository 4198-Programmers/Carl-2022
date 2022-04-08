package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SetDrivePosition extends CommandBase {
    DriveTrain driveTrain;
    double position;

    public SetDrivePosition(DriveTrain driveTrain, double position) {
        this.driveTrain = driveTrain;
        this.position = position;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        driveTrain.setPosition(position);
    }

    @Override
    public boolean isFinished() {
        return driveTrain.getPosition() == position;
    }
}
