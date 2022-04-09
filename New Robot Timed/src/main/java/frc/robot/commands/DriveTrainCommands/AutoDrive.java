package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
    DriveTrain driveTrain;
    double distance;

    public AutoDrive(DriveTrain driveTrain, double distance) {
        this.driveTrain = driveTrain;
        this.distance = distance;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.setPosition(0);
    }

    @Override
    public void execute() {
        driveTrain.drive(0, 1);
    }

    @Override
    public boolean isFinished() {
        return driveTrain.getPosition() >= distance;
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.drive(0, 0);
    }
}
