package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Sensors extends SubsystemBase{
    DigitalInput intakeSensor = new DigitalInput(Constants.BALL_IN_SENSOR_PORT);
    DigitalInput outtakeSensor = new DigitalInput(Constants.BALL_OUT_SENSOR_PORT);
    boolean intakeSensorSeenBall = false;
    boolean outtakeSensorSeenBall = false;

    public boolean hasinSensorSeenBall(){
        return intakeSensorSeenBall;
    }
    public boolean hasoutSensorSeenBall(){
        return outtakeSensorSeenBall;
    }
    public boolean ballatInSensor(){
        if(intakeSensor == true){
            intakeSensorSeenBall = true;
        }
    }
}
