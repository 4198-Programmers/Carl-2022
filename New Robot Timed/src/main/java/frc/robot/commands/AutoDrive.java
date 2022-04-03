package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
    DriveTrain driveTrain;
    double forwardSpeed;
    double turningSpeed;
    double wantedDistance;

    public AutoDrive(DriveTrain driveTrain, double forwardSpeed, double turningSpeed, double wantedDistance) {
        this.driveTrain = driveTrain;
        this.forwardSpeed = forwardSpeed;
        this.turningSpeed = turningSpeed;
        this.wantedDistance = wantedDistance;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.resetPosition();
    }

    @Override
    public void execute() {
        if (driveTrain.getPostion() < wantedDistance) {
            driveTrain.drive(forwardSpeed, turningSpeed);
        }
    }

    @Override
    public boolean isFinished() {
        return driveTrain.getPostion() >= wantedDistance;
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.drive(0, 0);
    }
}