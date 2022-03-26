package frc.robot.Subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Sensors extends SubsystemBase{
    DigitalInput ballInSensor = new DigitalInput(Constants.BALL_IN_SENSOR_PORT);
    DigitalInput ballOutSensor = new DigitalInput(Constants.BALL_OUT_SENSOR_PORT);
    boolean hasBallOutSensorSeenBall = false;
    boolean shotBall = false;

    public boolean isBallInFeed(){
        return ballInSensor.get();
    }
    public boolean isBallAtFlyWheel(){
        return ballOutSensor.get();
    }
    public boolean hasBallBeenShot(){
            return shotBall;


    }

    @Override
    public void periodic() {
       if (ballOutSensor.get()){
           hasBallOutSensorSeenBall = true;
       }
       else if (hasBallOutSensorSeenBall){
        shotBall = true;
       }
    }
}
