package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    private CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_PORT, MotorType.kBrushless);
    private RelativeEncoder frontRightMotorEncoder = frontRightMotor.getEncoder();
    private RelativeEncoder frontLeftMotorEncoder = frontLeftMotor.getEncoder();
    private RelativeEncoder backRightMotorEncoder = backRightMotor.getEncoder();
    private RelativeEncoder bakcLeftMotorEncoder = backLeftMotor.getEncoder();
    private MotorControllerGroup rightMotorControllerGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);
    private MotorControllerGroup leftMotorControllerGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    DifferentialDrive allDrive = new DifferentialDrive(rightMotorControllerGroup, leftMotorControllerGroup);
    public void resetPositon(){
        frontRightMotorEncoder.setPosition(0);
        frontLeftMotorEncoder.setPosition(0);
        backRightMotorEncoder.setPosition(0);
        bakcLeftMotorEncoder.setPosition(0);
    }
    public double getPostion(){
        double frontRightPosition = frontRightMotorEncoder.getPosition();
        double frontLeftPosition = frontLeftMotorEncoder.getPosition();
        double backRightPosition = backRightMotorEncoder.getPosition();
        double backLeftPosition = bakcLeftMotorEncoder.getPosition();
        return((frontRightPosition + frontLeftPosition + backRightPosition + backLeftPosition) / 4);
    }
    public void drive(double xAxis, double zRotation){
        allDrive.arcadeDrive(xAxis * Constants.SPEED_MULTIPLIER, zRotation * Constants.SPEED_MULTIPLIER);
    }
}
