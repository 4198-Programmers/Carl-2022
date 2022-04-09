package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
    DriveTrain driveTrain;
    double distance;
    double forwardSpeed;
    double turningSpeed;
    public AutoDrive(DriveTrain driveTrain, double distance, double forwardSpeed, double turningSpeed) {
        this.driveTrain = driveTrain;
        this.distance = distance;
        this.forwardSpeed = forwardSpeed;
        this.turningSpeed = turningSpeed;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.setPosition(0);
    }

    @Override
    public void execute() {
        driveTrain.drive(turningSpeed, forwardSpeed);
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
