package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    private CANSparkMax flywheel = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax internalMotor = new CANSparkMax(Constants.INTERNAL_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax feeder = new CANSparkMax(Constants.FEEDER_MOTOR_ID, MotorType.kBrushless);
    private RelativeEncoder flywheelEncoder = flywheel.getEncoder();
    private RelativeEncoder internalMotorEncoder = internalMotor.getEncoder();
    private RelativeEncoder feederEncoder = feeder.getEncoder();

    public void flywheelspeed(double speed){
        flywheel.set(speed);
    }
    public void internalMotorSpeed(double speed){
        internalMotor.set(speed);
    }
    public void feederSpeed(double speed){
        feeder.set(speed);
    }
    public void resetShooter(){
        flywheelEncoder.setPosition(0);
        internalMotorEncoder.setPosition(0);
        feederEncoder.setPosition(0);
    }
}
