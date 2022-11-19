package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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

    /**Front Left Motor Encoder */
    RelativeEncoder frontLMEnc = frontLMotor.getEncoder();
    RelativeEncoder frontRMEnc = frontRMotor.getEncoder();
    RelativeEncoder backRMEnc = backLMotor.getEncoder();
    RelativeEncoder backLMEnc = backLMotor.getEncoder();
    
    DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
    public void driveBoy(double zRotation, double xSpeed){

        drive.arcadeDrive(zRotation, xSpeed);

    }

    public double findPosition(){

        
    }
}