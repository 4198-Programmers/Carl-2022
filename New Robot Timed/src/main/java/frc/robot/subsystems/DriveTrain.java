package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{

    private CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_ID MotorType.kbrushless);
    private CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_ID MotorType.kbrushless);
    Private CANSparkMax backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_ID MotorType.kbrushless);
    Private CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_ID MotorType.kbrushless);

    private RelativeEncoder frontRMEnc = frontRightMotor.getEncoder();
    private RelativeEncoder frontLMEnc = frontLeftMotor.getEncoder();
    private RelativeEncoder backRMEnc = backRightMotor.getEncoder();
    private RelativeEncoder backLMEnc = backLeftMotor.getEncoder();

    private MotorControllerGroup leftSide = new MotorControllerGroup(frontRightMotor, backRightMotor);
    private MotorControllerGroup rightSide = new MotorControllerGroup(frontLeftMotor, backLeftMotor);

    public DriveTrain(){

        frontRMEnc.setPositionConversionFactor(1 / Constants.WHEEL_CONVERSION_FACTOR);
        frontLMEnc.setPositionConversionFactor(1 / Constants.WHEEL_CONVERSION_FACTOR);
        backRMEnc.setPositionConversionFactor(1 / Constants.WHEEL_CONVERSION_FACTOR);
        backRMEnc.setPositionConversionFactor(1/ Constants.WHEEL_CONVERSION_FACTOR);

        frontLeftMotor.setOpenLoopRampRate(0.1);
        frontRightMotor.setOpenLoopRampRate(0.1);
        backLeftMotor.setOpenLoopRampRate(0.1);
        backRightMotor.setOpenLoopRampRate(0.1);

    }

    public void resetPosition(){

        frontRMEnc.setPosition(0d);
        frontLMEnc.setPosition(0d);
        backRMEnc.setPosition(0d);
        backLMEnc.setPosition(0d);

    }

    public double findPosition(){

        double encCurrentPosition = Math.abs(frontLMEnc.getPosition());
        encCurrentPosition += Math.abs(frontRMEnc.getPosition);
        encCurrentPosition += Math.abs(backLMEnc.getPosition);
        encCurrentPosition += Math.abs(backRMEnc.getPosition);

        return encCurrentPosition / 4d;

    }

    /**
    * @param xAxis
    * @param zRotate
     */

    public void zoomTime(double, zRotate, double xAxis){

        allDrive.arcadeDrive(Constants.DRIVE_SPEED_MULTIIPLIER * zRoatte, Constants.DRIVE_SPEED_MULTIIPLIER * xAxis);
        
    }
}