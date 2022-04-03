package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_PORT, MotorType.kBrushless);
    CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_PORT, MotorType.kBrushless);
    CANSparkMax backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_PORT, MotorType.kBrushless);
    CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_PORT, MotorType.kBrushless);

    RelativeEncoder frontRightEncoder = frontRightMotor.getEncoder();
    RelativeEncoder frontLeftEncoder = frontLeftMotor.getEncoder();
    RelativeEncoder backRightEncoder = backRightMotor.getEncoder();
    RelativeEncoder backLeftEncoder = backLeftMotor.getEncoder();

    MotorControllerGroup rightDrive = new MotorControllerGroup(frontRightMotor, backRightMotor);
    MotorControllerGroup leftDrive = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    DifferentialDrive allDrive = new DifferentialDrive(leftDrive, rightDrive);

    public void resetPosition() {
        frontRightEncoder.setPosition(0);
        frontLeftEncoder.setPosition(0);
        backRightEncoder.setPosition(0);
        backLeftEncoder.setPosition(0);
    }

    public double getPostion() {
        double frontRightPostion = frontRightEncoder.getPosition();
        double frontLeftPosition = frontLeftEncoder.getPosition();
        double backRightPosition = backRightEncoder.getPosition();
        double backLeftPosition = backLeftEncoder.getPosition();
        return ((frontRightPostion + frontLeftPosition + backRightPosition + backLeftPosition) / 4);
    }

    public void drive(double xSpeed, double zRotation) {
        allDrive.arcadeDrive(xSpeed, zRotation);
    }
}