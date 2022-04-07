package frc.robot.subsystems.ShooterSystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase{
    CANSparkMax flyWheelMotor = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_PORT, MotorType.kBrushless);
    RelativeEncoder flyWheelMotorEncoder = flyWheelMotor.getEncoder();

    public void setSpeed(double speed){
        flyWheelMotor.set(speed);
    }
    public double getSpeed(){
        return flyWheelMotorEncoder.getVelocity();
    }
}
