package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {
    private CANSparkMax frontL = new CANSparkMax(Constants.FRONT_LEFT_INSERTION_THINGY, MotorType.kBrushless);
    private CANSparkMax frontR = new CANSparkMax(Constants.FRONT_RIGHT_INSERTION_THINGY, MotorType.kBrushless);
    private CANSparkMax backL = new CANSparkMax(Constants.BACK_LEFT_INSERTION_THINGY, MotorType.kBrushless);
    private CANSparkMax backR = new CANSparkMax(Constants.BACK_RIGHT_INSERTION_THINGY, MotorType.kBrushless);

    private RelativeEncoder frontLEncoder = frontL.getEncoder();
    private RelativeEncoder frontREncoder = frontR.getEncoder();
    private RelativeEncoder backLEncoder = backL.getEncoder();
    private RelativeEncoder backREncoder = backR.getEncoder();

    private MotorControllerGroup rightSide = new MotorControllerGroup(frontR, backR);
    private MotorControllerGroup leftSide = new MotorControllerGroup(frontL, backL);

    private DifferentialDrive allDrive = new DifferentialDrive(leftSide, rightSide);

    public void Reset() {
        frontLEncoder.setPositionConversionFactor(Constants.WHEEL_CONVERSION_FACTOR);
        frontREncoder.setPositionConversionFactor(Constants.WHEEL_CONVERSION_FACTOR);
        backLEncoder.setPositionConversionFactor(Constants.WHEEL_CONVERSION_FACTOR);
        backREncoder.setPositionConversionFactor(Constants.WHEEL_CONVERSION_FACTOR);
        frontLEncoder.setPosition(0);
        backLEncoder.setPosition(0);
        frontREncoder.setPosition(0);
        backREncoder.setPosition(0);
    }

    public double encoderAverage() {
        double encoderTotal = Math.abs(frontLEncoder.getPosition());
        encoderTotal += Math.abs(frontREncoder.getPosition());
        encoderTotal += Math.abs(backLEncoder.getPosition());
        encoderTotal += Math.abs(backREncoder.getPosition());
        return (encoderTotal / 4d);
    }

    public void Movement(double xSpeed, double zRotation) {
        allDrive.arcadeDrive(xSpeed * Constants.WHEEL_SPEED, zRotation * Constants.WHEEL_SPEED);
    }
}
