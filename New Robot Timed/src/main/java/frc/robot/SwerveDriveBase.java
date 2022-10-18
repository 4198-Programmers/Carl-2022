package frc.robot;

import com.revrobotics.AnalogInput;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ModuleConstants;

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

    private final boolean absoluteEncoderReversed;
    private final double absoluteEncoderOffsetRadius;
    public SwerveDriveBase(int driveMotorId, int turningMotorId, boolean driveMotorReversed, boolean turnginMotorReversed, int absoluteEncoderId, double absoluteEncoderOffset, boolean absoluteEncoderReversed){
        absoluteEncoderOffsetRadius = absoluteEncoderOffsetRadius;
        this.absoluteEncoderReversed = absoluteEncoderReversed;
    }
        AnalogInput absoluteEncoder = new AnalogInput(ModuleConstants.absoluteEncoderId);

        CANSparkMax driveMotor = new CANSparkMax(Constants.DRIVE_MOTOR, MotorType.kBrushless);
        CANSparkMax turningMotor = new CANSparkMax(Constants.TURNING_MOTOR, MotorType.kBrushless);

        driveMotor.setInverted(driveMotorReversed);
        turningMotor.setInverted(turnginMotorReversed);

        RelativeEncoder driveEncoder = driveMotor.getEncoder();
        RelativeEncoder turningEncoder = turningMotor.getEncoder();

        driveEncoder.setPositionConversionFactor(ModuleConstants.kDriveEncoderRot2Meter);
        driveEncoder.setVelocityConversionFactor(ModuleConstants.kDriveEncoderRPM2MeterPerSec);
        turningEncoder.setPositionConversionFactor(ModuleConstants.kTurningEncoderRot2Rad);
        turningEncoder.setVelocityConversionFactor(ModuleConstants.kTurningEncoderRPM2RadPerSec);

        PIDController turningPidController = new PIDController(ModuleConstants.kPTurning, 0, 0);
        turningPidController.enableContinuousInput(-Math.PI, Math.PI);
    public double getDrivePosition(){
        return driveEncoder.getPosition();
    }
    public double getTurningPosition(){
        return turningEncoder.getPosition();
    }
    public double getDriveVelocity(){
        return driveEncoder.getVelocity();
    }
    public double getTurningVelocity(){
        return turningEncoder.getVelocity();
    }
    public double getAbsoluteEncoderRad(){
        double angle = absoluteEncoder.getVoltage() / RobotController.getVoltage5V();
        angle *= 2.0 * Math.PI;
        angle -= absoluteEncoderOffsetRadius;
        return angle * (absoluteEncoderOffsetRadius ? -1.0 : 1.0);
    }

    public void resetEncoders(){
        driveEncoder.setPosition(0);
        turningEncoder.setPosition(getAbsoluteEncoderRad());
    }
}
