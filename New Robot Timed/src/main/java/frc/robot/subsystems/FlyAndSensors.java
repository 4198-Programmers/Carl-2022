package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyAndSensors extends SubsystemBase {
    private CANSparkMax flyWheelMotor = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private DigitalInput ballInSensor = new DigitalInput(Constants.BALL_IN_SENSOR_PORT);
    private DigitalInput ballOutSensor = new DigitalInput(Constants.BALL_OUT_SENSOR_PORT);

    /** top of shooter wheel speeds (go pew pew fast) */
    public void setFlySpeed(double speed) {
        flyWheelMotor.set(speed);
    }

    public double getFlySpeed() {
        return flyWheelMotor.get();
    }

    public boolean ballIn(){
        return ballInSensor.get();
    }

    public boolean ballOut(){
        return ballOutSensor.get();
    }

}
