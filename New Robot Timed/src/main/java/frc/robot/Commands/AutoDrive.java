package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drivetrain;

public class AutoDrive extends CommandBase {

    Drivetrain drivetrain;
    Timer timer;
    double time;
    public AutoDrive(double time, Drivetrain drivetrain){

        this.time = time;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
        
    }

    @Override
    public void initialize() {
        timer.reset();
    }
    
    @Override
    public void execute() {
        drivetrain.oliverscrazycoolautocodedotcom(-.1, .1);

    }

    @Override
    public boolean isFinished() {
        return(timer.get() >= time);
        
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.oliverscrazycoolautocodedotcom(0, 0);
    }
}