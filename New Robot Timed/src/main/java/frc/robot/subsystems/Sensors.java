package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Sensors extends SubsystemBase{
    DigitalInput intakeSensor = new DigitalInput(Constants.BALL_IN_SENSOR_PORT);
    DigitalInput outtakeSensor = new DigitalInput(Constants.BALL_OUT_SENSOR_PORT);
    boolean intakeSensorSeenBall = false;
    boolean outtakeSensorSeenBall = false;

    public boolean isBallAtIntake(){
       return intakeSensor.get();
    }
    public boolean isBallAtOuttake(){
       return outtakeSensor.get();
    }
    public boolean hasinSensorSeenBall(){
        return intakeSensorSeenBall;
    }
    public boolean hasoutSensorSeenBall(){
        return outtakeSensorSeenBall;
    }
    @Override
    public void periodic() {
        if(isBallAtIntake()){
            intakeSensorSeenBall = true;
        }
        if(isBallAtOuttake()){
            outtakeSensorSeenBall = true;
        }
    }
    public void forgetintakeBall(){
        intakeSensorSeenBall = false;
    }
    public void forgetOuttakeBall(){
        outtakeSensorSeenBall = false;
    }
}
