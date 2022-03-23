package frc.robot.Subsystems;

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
    
    RelativeEncoder frontRightMotorEncoder = frontRightMotor.getEncoder();
    RelativeEncoder frontLeftMotorEncoder = frontLeftMotor.getEncoder();
    RelativeEncoder backRightMotorEncoder = backRightMotor.getEncoder();
    RelativeEncoder backLeftMotorEncoder = backLeftMotor.getEncoder();


    public void resetPosition(){
        frontRightMotorEncoder.setPosition(0);
        frontLeftMotorEncoder.setPosition(0);
        backRightMotorEncoder.setPosition(0);
        backLeftMotorEncoder.setPosition(0);
    }

    public double position(){
       return (frontRightMotorEncoder.getPosition() 
            + frontLeftMotorEncoder.getPosition() 
            + backRightMotorEncoder.getPosition() 
            + backLeftMotorEncoder.getPosition()) / 4d;
    }
    MotorControllerGroup rightDrive = new MotorControllerGroup(frontRightMotor, backRightMotor);
    MotorControllerGroup leftDrive = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    DifferentialDrive allDrive = new DifferentialDrive(leftDrive, rightDrive);
    public void greenLight(double xAxis, double zRotation){
        allDrive.arcadeDrive(Constants.SPEED_MULTIPLIER *xAxis, Constants.SPEED_MULTIPLIER * zRotation);
    }
}
