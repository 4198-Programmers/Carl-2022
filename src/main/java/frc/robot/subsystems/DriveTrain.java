package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase
 {
private CANSparkMax frontRight = new CANSparkMax(Constants.FRONT_RIGHT_DEVICE_ID, MotorType.kBrushless);
private static CANSparkMax frontLeft = new CANSparkMax(Constants.FRONT_LEFT_DEVICE_ID, MotorType.kBrushless);
private CANSparkMax backRight = new CANSparkMax(Constants.BACK_RIGHT_DEVICE_ID, MotorType.kBrushless);
private static CANSparkMax backLeft = new CANSparkMax(Constants.BACK_LEFT_DEVICE_ID, MotorType.kBrushless);

private RelativeEncoder encoderFrontRight = frontRight.getEncoder();
private static RelativeEncoder encoderFrontLeft = frontLeft.getEncoder();
private RelativeEncoder encoderBackRight = backRight.getEncoder();
private static RelativeEncoder encoderBackLeft = backLeft.getEncoder();

private MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);
private MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);

private DifferentialDrive alldrive = new DifferentialDrive(left, right);


public DriveTrain(){
    encoderFrontRight.setPositionConversionFactor(Constants.CONVERSION_FACTOR);
    encoderFrontLeft.setPositionConversionFactor(Constants.CONVERSION_FACTOR);
    encoderBackRight.setPositionConversionFactor(Constants.CONVERSION_FACTOR);
    encoderBackRight.setPositionConversionFactor(Constants.CONVERSION_FACTOR);

    frontRight.setOpenLoopRampRate(Constants.LOOP_RAMP_RATE);
    frontLeft.setOpenLoopRampRate(Constants.LOOP_RAMP_RATE);
    backRight.setOpenLoopRampRate(Constants.LOOP_RAMP_RATE);
    backLeft.setOpenLoopRampRate(Constants.LOOP_RAMP_RATE);
}


public void resetposition(){
    encoderFrontRight.setPosition(0d);
    encoderFrontLeft.setPosition(0d);
    encoderBackRight.setPosition(0d);
    encoderBackLeft.setPosition(0d);
}


public double findposition(){
    double encCurrentPosition = Math.abs(encoderFrontRight.getPosition());
    encCurrentPosition += Math.abs(encoderFrontLeft.getPosition());
    encCurrentPosition += Math.abs(encoderBackRight.getPosition());
    encCurrentPosition += Math.abs(encoderBackLeft.getPosition());
    return encCurrentPosition /4d;
}


public static double findPositionLeft(){
    double encCurrentPosition = Math.abs(encoderFrontLeft.getPosition());
    encCurrentPosition += Math.abs(encoderBackLeft.getPosition());
    return encCurrentPosition /2d;
}


public void drive(double zRotate, double xAxis){
    alldrive.arcadeDrive(Constants.DRIVE_SPEED * zRotate, Constants.DRIVE_SPEED * xAxis);
}


public void autoDrive(double rightSpeed, double leftSpeed){
    right.set(rightSpeed);
    left.set(leftSpeed);
}
}
