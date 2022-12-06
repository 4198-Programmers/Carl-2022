package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drivetrain;

/* REMEMBER!!
* All time-based auto code needs the following:
* An execute,
* Isfinished,
* and stop method
*/


/**This is a challenge to figure out how to make the robot move forward for a certain amount of time.
 * Look back at your AutoDrive command to help you do this.
 */
public class AutoDriveForward extends CommandBase {
    
    Drivetrain drivetrain;
    Timer timer;
    double time;
    
    public AutoDriveForward(double time, Drivetrain drivetrain){

        this.time = time;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);

    }
    
    @Override
    public void initialize(){
        timer.reset();
    }

    @Override
    public void execute(){
        drivetrain.oliverscrazycoolautocodedotcom(.5, .5);
    }

    @Override
    public boolean isFinished() {
        return(timer.get() >= time);
    }

    public void stop(){
        drivetrain.oliverscrazycoolautocodedotcom(0, 0);
    }
}
