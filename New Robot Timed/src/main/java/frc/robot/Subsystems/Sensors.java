package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Sensors extends SubsystemBase{
    DigitalInput ballInSensor = new DigitalInput(Constants.BALL_IN_SENSOR_PORT);
    DigitalInput ballOutSensor = new DigitalInput(Constants.BALL_OUT_SENSOR_PORT);
    public boolean getBallIn(){
        return ballInSensor.get();
    }
    public boolean getBallOut(){
        return ballOutSensor.get();
    }
}
