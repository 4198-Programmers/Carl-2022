package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoCodeShake extends CommandBase{ 

    DriveTrain driveTrain; 
    double timewanted; 
    Timer time = new Timer();
    double speed = 1;
    double distance;

    public AutoCodeShake(DriveTrain driveTrain, double timewanted, double distance){
        this.driveTrain = driveTrain;
        this.timewanted = timewanted; 
        this.distance = distance;
        addRequirements (driveTrain);
    }

    @Override
    public void initialize () {
        time.reset();
        driveTrain.resetposition();
    }

    @Override 
    public void execute() { 

        if (driveTrain.findposition() > distance){
         speed = -1;
        }
        else if (driveTrain.findposition() < -distance){
         speed = 1;
        }
        driveTrain.autoDrive(speed, speed);
    }

    @Override 
    public boolean isFinished(){
        return time.hasElapsed(timewanted);
    }
    @Override 
    public void end(boolean interrupted) {
        driveTrain.autoDrive(0,0);
    } 
}

