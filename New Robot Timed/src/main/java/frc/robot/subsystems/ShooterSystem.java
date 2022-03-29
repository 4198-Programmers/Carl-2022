package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSystem extends SubsystemBase{
    CANSparkMax flyWheel = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_PORT, MotorType.kBrushless);
    CANSparkMax tunnelMotor = new CANSparkMax(Constants.TUNNEL_MOTOR_PORT, MotorType.kBrushless);
    CANSparkMax intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_PORT, MotorType.kBrushless);
    public void setFlyWheelSpeed(double speed){
        flyWheel.set(speed);
    }
    public void setTunnelMotorSpeed(double speed){
        tunnelMotor.set(speed);
    }
    public void setIntakeMotorSpeed(double speed){
        intakeMotor.set(speed);
    }
    public double getSpeed() {
        return(flyWheel.get());
    }
}
