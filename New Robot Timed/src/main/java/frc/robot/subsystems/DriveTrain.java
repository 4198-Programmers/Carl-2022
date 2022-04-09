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
    RelativeEncoder frontRightMotorEncoder = frontRightMotor.getEncoder();
    RelativeEncoder frontleftMotorEncoder = frontLeftMotor.getEncoder();
    RelativeEncoder backRightMotorEncoder = backRightMotor.getEncoder();
    RelativeEncoder backLeftMotorEncoder = backLeftMotor.getEncoder();
    DifferentialDrive allDrive = new DifferentialDrive(new MotorControllerGroup(frontRightMotor, backRightMotor),
            new MotorControllerGroup(frontLeftMotor, backLeftMotor));

    public double getPosition() {
        double frme = frontRightMotorEncoder.getPosition();
        double flme = frontleftMotorEncoder.getPosition();
        double brme = backRightMotorEncoder.getPosition();
        double blme = backLeftMotorEncoder.getPosition();
        return ((frme + flme + brme + blme) / 4);
    }

    public void setPosition(double position) {
        frontRightMotorEncoder.setPosition(position);
        frontleftMotorEncoder.setPosition(position);
        backRightMotorEncoder.setPosition(position);
        backLeftMotorEncoder.setPosition(position);
    }

    public void drive(double xSpeed, double zRotation) {
        allDrive.arcadeDrive(xSpeed, zRotation);
    }
}
