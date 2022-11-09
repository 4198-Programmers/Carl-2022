package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class Drivetrain extends SubsystemBase {
    private CANSparkMax frontLMotor = new CANSparkMax(Constants.FRONT_L_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax frontRMotor = new CANSparkMax(Constants.FRONT_R_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax backLMotor = new CANSparkMax(Constants.BACK_L_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax backRMotor = new CANSparkMax(Constants.BACK_R_MOTOR_ID, MotorType.kBrushless);

    MotorControllerGroup leftMotors = new MotorControllerGroup(frontLMotor, backLMotor);
    MotorControllerGroup rightMotors = new MotorControllerGroup(frontRMotor, backRMotor);

    
    
}