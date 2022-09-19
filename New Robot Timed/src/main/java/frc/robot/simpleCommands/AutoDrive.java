package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase{
    DriveTrain drivetrain;
    double rightdistanceRequired;
    double leftdistanceRequired;
    double rightspeed;
    double leftspeed;
    public AutoDrive(DriveTrain drivetrain, double rightdistanceRequired, double leftdistanceRequired, double rightspeed, double leftspeed){
        this.drivetrain = drivetrain;
        this.rightdistanceRequired = rightdistanceRequired;
        this.leftdistanceRequired = leftdistanceRequired;
        this.rightspeed = rightspeed;
        this.leftspeed = leftspeed;
        addRequirements(drivetrain);
    }
    @Override
    public void execute() {
        drivetrain.autoDrive(rightspeed, leftspeed);
    }
    @Override
    public boolean isFinished() {
        return Math.abs(drivetrain.getRightposition()) >= rightdistanceRequired && Math.abs(drivetrain.getLeftPosition()) >= leftdistanceRequired;
    }
    @Override
    public void end(boolean interrupted) {
        drivetrain.autoDrive(0, 0);
    }
}