package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDriveBase extends SubsystemBase{
    Translation2d frontLeftLocation = new Translation2d(Constants.FRONT_LEFT_X_LOCATION, Constants.FRONT_LEFT_Y_LOCATION);
    Translation2d frontRightLocation = new Translation2d(Constants.FRONT_RIGHT_X_LOCATION, Constants.FRONT_RIGHT_Y_LOCATION);
    Translation2d backLeftLocation = new Translation2d(Constants.BACK_LEFT_X_LOCATION, Constants.BACK_LEFT_Y_LOCATION);
    Translation2d backRightLocation = new Translation2d(Constants.BACK_RIGHT_X_LOCATION, Constants.BACK_RIGHT_Y_LOCATION);
    //Turning Motors
    CANSparkMax FrontLeftTurningMotor = new CANSparkMax(Constants.FRONT_LEFT_TURNING_MOTOR_ID, MotorType.kBrushless);
        RelativeEncoder frontleftTurningEncoder = FrontLeftTurningMotor.getEncoder();
    CANSparkMax FrontRightTurningMotor = new CANSparkMax(Constants.FRONT_RIGHT_TURNING_MOTOR_ID, MotorType.kBrushless);
        RelativeEncoder frontRightTurningEncoder = FrontRightTurningMotor.getEncoder();
    CANSparkMax BackLeftTurningMotor = new CANSparkMax(Constants.BACK_LEFT_TURNING_MOTOR_ID, MotorType.kBrushless);
        RelativeEncoder backLeftTurningEncoder = BackLeftTurningMotor.getEncoder();
    CANSparkMax BackRightTurningMotor = new CANSparkMax(Constants.BACK_RIGHT_TURNING_MOTOR_ID, MotorType.kBrushless);
        RelativeEncoder backRightTurningEncoder = BackRightTurningMotor.getEncoder();
    //Moving Motors
    CANSparkMax FrontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless);
        RelativeEncoder frontLeftEncoder = FrontLeftMotor.getEncoder();
    CANSparkMax FrontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless);
        RelativeEncoder frontRightEncoder = FrontRightMotor.getEncoder();
    CANSparkMax BackLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless);
        RelativeEncoder backLeftEncoder = BackLeftMotor.getEncoder();
    CANSparkMax BackRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless);
        RelativeEncoder backRightEncoder = BackRightMotor.getEncoder();

}
