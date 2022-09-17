package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    CANSparkMax backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    
    RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
    RelativeEncoder frontLeftEncoder = frontLeftMotor.getEncoder();
    RelativeEncoder backRightEncoder = backRightMotor.getEncoder();
    RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();

    MotorControllerGroup rightDrive = new MotorControllerGroup(frontRightMotor, backRightMotor);
    MotorControllerGroup leftDrive = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    DifferentialDrive allDrive = new DifferentialDrive(leftDrive, rightDrive);
    public void alldrive(double xspeed, double zrotation){
        allDrive.arcadeDrive(xspeed, zrotation);
    }
    public void autoDrive(double rightspeed, double leftspeed){
        rightDrive.set(rightspeed);
        leftDrive.set(leftspeed);
    }
    public double getRightposition(){
       double freP = frontRightEncoder.getPosition();
       double brep = backRightEncoder.getPosition();
       return (freP + brep)/2;
    }
    public double getLeftPosition(){
        double flep = frontLeftEncoder.getPosition();
        double blep = backLeftEncoder.getPosition();
        return (flep + blep)/2;
    }
    public void setDrivePosition(double position){
        frontRightEncoder.setPosition(position);
        frontLeftEncoder.setPosition(position);
        backRightEncoder.setPosition(position);
        backLeftEncoder.setPosition(position);
    }
}
