package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class WaitCommand extends CommandBase{
    DriveTrain driveTrain;
    double timewanted;
    Timer time;
    double distance;
    double direction = 1;
    public WaitCommand(DriveTrain driveTrain, double timewanted, double distance){
        this.driveTrain = driveTrain;
        this.timewanted = timewanted;
        this.distance = distance;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        time.reset();
        driveTrain.setDrivePosition(0);
        direction = 1;
    }
    @Override
    public void execute() {

        if(driveTrain.getPosition() > distance){
            direction = -1;
        }
        else if(driveTrain.getPosition() < -distance){
            direction = 1;
        }
        driveTrain.autoDrive(direction, direction);
    }
    @Override
    public boolean isFinished() {
        return time.hasElapsed(timewanted);
    }
    @Override
    public void end(boolean interrupted) {
        driveTrain.autoDrive(0, 0);
    }
    
}