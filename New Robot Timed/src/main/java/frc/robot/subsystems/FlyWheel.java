package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {
    CANSparkMax flyWheelmotor = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_PORT, MotorType.kBrushless);

    public void setSpeed(double speed) {
        flyWheelmotor.set(speed);
    }
}