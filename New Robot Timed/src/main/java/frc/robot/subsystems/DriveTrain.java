package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    private CANSparkMax frontR = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax frontL = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax backR = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax backL = new CANSparkMax(Constants.BACK_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private RelativeEncoder frontREnc = frontR.getEncoder();
    private RelativeEncoder frontLEnc = frontL.getEncoder();
    private RelativeEncoder backREnc = backR.getEncoder();
    private RelativeEncoder backLEnc = backL.getEncoder();

    private MotorControllerGroup rightSideDrive = new MotorControllerGroup(frontR, backR);
    private MotorControllerGroup leftSideDrive = new MotorControllerGroup(frontL, backL);

    private DifferentialDrive allDrive = new DifferentialDrive(leftSideDrive, rightSideDrive);

    public DriveTrain() {
        frontLEnc.setPositionConversionFactor(1 / Constants.WHEEL_CONVERSION_FACTOR);
        frontREnc.setPositionConversionFactor(1 / Constants.WHEEL_CONVERSION_FACTOR);
        backLEnc.setPositionConversionFactor(1 / Constants.WHEEL_CONVERSION_FACTOR);
        backREnc.setPositionConversionFactor(1 / Constants.WHEEL_CONVERSION_FACTOR);

        frontL.setOpenLoopRampRate(0.1);
        frontR.setOpenLoopRampRate(0.1);
        backL.setOpenLoopRampRate(0.1);
        backR.setOpenLoopRampRate(0.1);
    }

    /** Sets encoder positions to 0 */
    public void resetPosition() {
        frontLEnc.setPosition(0d);
        frontREnc.setPosition(0d);
        backLEnc.setPosition(0d);
        backREnc.setPosition(0d);
    }

    public double findPosition() {
        double encCurrentPosition = Math.abs(frontLEnc.getPosition());
        encCurrentPosition += Math.abs(frontREnc.getPosition());
        encCurrentPosition += Math.abs(backREnc.getPosition());
        encCurrentPosition += Math.abs(backLEnc.getPosition());
        return encCurrentPosition / 4d;
    }


    /**
     * Assigns two speeds to the xAxis of the Robot and the Rotation of the Robot.
     * Negative values of xAxis
     * will move backwards, negative values of the zRotation will rotate
     * counter-clockwise.
     * Joysticks allow these to be control by controller axes
     * 
     * @param xAxis
     * @param zRotate
     */
    public void greenLight(double zRotate, double xAxis) {
        allDrive.arcadeDrive(Constants.DRIVE_SPEED_MULTIPLIER * zRotate, Constants.DRIVE_SPEED_MULTIPLIER * xAxis);
    }

}