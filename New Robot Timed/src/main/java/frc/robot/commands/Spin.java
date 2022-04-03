package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class Spin extends CommandBase {
    DriveTrain driveTrain;
    double degrees;
    double forwardSpeed;
    double turningSpeed;

    public Spin(DriveTrain driveTrain, double degrees, double forwardSpeed, double turningSpeed) {
        this.driveTrain = driveTrain;
        this.degrees = degrees;
        this.forwardSpeed = forwardSpeed;
        this.turningSpeed = turningSpeed;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.resetPosition();
    }

    @Override
    public void execute() {
        if (driveTrain.getPostion() < Maths.spinDistanceByDegree(degrees)) {
            driveTrain.drive(forwardSpeed, turningSpeed);
        }
    }

    @Override
    public boolean isFinished() {
        return driveTrain.getPostion() >= Maths.spinDistanceByDegree(degrees);
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.drive(0, 0);
    }
}