package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Sensors extends SubsystemBase{
    DigitalInput intakeSensor = new DigitalInput(Constants.INTAKE_SENSOR_CHANNEL);
    DigitalInput shootSensor = new DigitalInput(Constants.SHOOT_SENSOR_CHANNEL);
    boolean hasShootSensorSeenBall = false;
    boolean ballIsAtSensor = false;
    public boolean isBallAtIntakeSensor(){
        return(intakeSensor.get());
    }
    public boolean isBallAtShootSensor(){
        return(shootSensor.get());
    }
    public boolean hasBallBeenSeen(){
        return(hasShootSensorSeenBall);
    }
    @Override
    public void periodic() {
        if(isBallAtShootSensor()){
            hasShootSensorSeenBall = true;
            ballIsAtSensor = true;
        }
        if(hasBallBeenSeen()){
            
        }

    }
}
