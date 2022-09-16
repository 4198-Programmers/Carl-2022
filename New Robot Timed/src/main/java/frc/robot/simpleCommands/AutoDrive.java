package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase{
    DriveTrain driveTrain;
    double rightdistanceRequired;
    double leftdistanceRequired;
    double rightspeed;
    double leftspeed;
    public AutoDrive(DriveTrain driveTrain, double rightdistanceRequired, double leftdistanceRequired, double rightspeed, double leftspeed){
        this.driveTrain = driveTrain;
        this.rightdistanceRequired = rightdistanceRequired;
        this.leftdistanceRequired = leftdistanceRequired;
        this.rightspeed = rightspeed;
        this.leftspeed = leftspeed;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.autoDrive(rightspeed, leftspeed);
    }
    @Override
    public boolean isFinished() {
        return driveTrain.getRightposition() >= rightdistanceRequired && driveTrain.getLeftPosition() >= leftdistanceRequired;
    }
    @Override
    public void end(boolean interrupted) {
        driveTrain.autoDrive(0, 0);
    }
}