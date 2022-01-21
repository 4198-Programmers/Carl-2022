package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Shooter {
    private CANSparkMax flyWheelMotor = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax internalMoverMotor = new CANSparkMax(Constants.BALL_MOVER_MOTOR_DEVICE_ID, MotorType.kBrushless);

    /**top of shooter wheel speeds (go pew pew fast)*/
    public void setFlySpeed(double speed)
    {
        flyWheelMotor.set(speed);
    }

}
