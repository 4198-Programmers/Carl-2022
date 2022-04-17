package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
    DriveTrain driveTrain;
    double distance;
    double leftSpeed;
    double rightSpeed;
    public AutoDrive(DriveTrain driveTrain, double distance, double leftSpeed, double rightSpeed) {
        this.driveTrain = driveTrain;
        this.distance = distance;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.setPosition(0);
    }

    @Override
    public void execute() {
        driveTrain.allSpeed(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(driveTrain.getPosition()) >= Math.abs(distance);
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.allSpeed(0, 0);
    }
}
