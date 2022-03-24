package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeederSub extends SubsystemBase{
    CANSparkMax feederMotor = new CANSparkMax(Constants.FEEDER_MOTOR_PORT, MotorType.kBrushless);
    public void takeIn(double speed){
        feederMotor.set(speed);
    }
}
