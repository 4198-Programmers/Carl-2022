package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Sensors;

public class IntakeSensorSeesBall extends CommandBase{
    Sensors sensors;
    public IntakeSensorSeesBall(Sensors sensors){
        this.sensors = sensors;
    }
    @Override
    public boolean isFinished() {
        return(sensors.isBallInFeed());
    }
}
