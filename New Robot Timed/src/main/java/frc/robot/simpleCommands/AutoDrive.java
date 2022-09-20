package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase{
    DriveTrain drivetrain;
    double distanceRequired;
    double xspeed;
    double zrotation;
    public AutoDrive(DriveTrain drivetrain, double distanceRequired, double xspeed, double zrotation){
        this.drivetrain = drivetrain;
        this.distanceRequired = distanceRequired;
        this.xspeed = xspeed;
        this.zrotation = zrotation;
        addRequirements(drivetrain);
}
        @Override
    public void initialize() {
        drivetrain.setDrivePosition(0);
    }
    @Override
    public void execute() {
        drivetrain.alldrive(xspeed, zrotation);
    }
    @Override
    public boolean isFinished() {
        return Math.abs(drivetrain.getPosition()) >= distanceRequired;
        
    }
    @Override
    public void end(boolean interrupted) {
        drivetrain.autoDrive(0, 0);
    }
}