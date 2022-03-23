package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSystem extends SubsystemBase{
    CANSparkMax flyWheel = new CANSparkMax(Constants.FLYWHEEL_MOTOR_ID, MotorType.kBrushless);
    public void shoot(double speed){
        flyWheel.set(speed);
    }
}