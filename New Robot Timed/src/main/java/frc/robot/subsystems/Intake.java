package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    CANSparkMax intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_DEVICE_ID, MotorType.kBrushless);
    public void setintakespeed(double speed){
        intakeMotor.set(speed);
    }
    public double getIntakeSpeed(){
        return intakeMotor.get();
    }
}
