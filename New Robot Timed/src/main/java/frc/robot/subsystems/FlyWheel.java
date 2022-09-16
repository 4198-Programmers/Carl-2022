package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase{
    CANSparkMax FlyWheelMotor = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_DEVICE_ID, MotorType.kBrushless);
    public void setFlyWheelSpeed(double speed){
        FlyWheelMotor.set(speed);
    }
}
