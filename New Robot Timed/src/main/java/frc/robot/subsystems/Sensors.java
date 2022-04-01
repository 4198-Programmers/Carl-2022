package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase{
    DigitalInput intakeSensor = new DigitalInput(0);
    DigitalInput flyWheelSensor =  new DigitalInput(1);
    boolean isSensorSeeingBall = false;
    boolean hasSensorSeenBall = false;

    public boolean isBallInFeed(){
        return intakeSensor.get();
    }
    public boolean isBallAtShooter(){
        return flyWheelSensor.get();
    }
    public boolean hasBallBeenShot(){
        return hasSensorSeenBall;
    }

    @Override
    public void periodic() {
       if (isBallAtShooter()){
           isSensorSeeingBall = true;
       }
       else if(isSensorSeeingBall){
           hasSensorSeenBall = true;
       }
    }
    public void forget(){
        isSensorSeeingBall = false;
        hasSensorSeenBall = false;
    }
}
