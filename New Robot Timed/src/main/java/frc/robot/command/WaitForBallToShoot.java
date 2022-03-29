package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sensors;

public class WaitForBallToShoot extends CommandBase{
    Sensors sensors;
    public WaitForBallToShoot(Sensors sensors){
        this.sensors = sensors;
    }
    @Override
    public boolean isFinished() {
        return(sensors.hasBallBeenShot());
    }
    @Override
    public void end(boolean interrupted) {
        sensors.forget();
    }
}
