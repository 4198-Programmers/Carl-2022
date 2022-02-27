package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVLibError;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase{
    private CANSparkMax frMotor = new CANSparkMax(Constants.FR_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax flMotor = new CANSparkMax(Constants.FL_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax brMotor = new CANSparkMax(Constants.BR_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax blMotor = new CANSparkMax(Constants.BL_MOTOR_ID, MotorType.kBrushless);
    private RelativeEncoder frMotorEnc = frMotor.getEncoder();
    private RelativeEncoder flMotorEnc = flMotor.getEncoder();
    private RelativeEncoder brMotorEnc = brMotor.getEncoder();
    private RelativeEncoder blMotorEnc = brMotor.getEncoder();

    public boolean autoResetSuccess;

    MotorControllerGroup rightSide = new MotorControllerGroup(frMotor, brMotor);
    MotorControllerGroup leftSide = new MotorControllerGroup(flMotor, blMotor);

    DifferentialDrive dejaVu = new DifferentialDrive(leftSide, rightSide);


    public DriveTrain() {
        frMotorEnc.setPositionConversionFactor(1/Constants.WHEEL_CONVERSION_FACTOR);
        flMotorEnc.setPositionConversionFactor(1/Constants.WHEEL_CONVERSION_FACTOR);
        brMotorEnc.setPositionConversionFactor(1/Constants.WHEEL_CONVERSION_FACTOR);
        blMotorEnc.setPositionConversionFactor(1/Constants.WHEEL_CONVERSION_FACTOR);
    }
    
    public void resetPosition() {
        frMotorEnc.setPosition(0d);
        flMotorEnc.setPosition(0d);
        brMotorEnc.setPosition(0d);
        blMotorEnc.setPosition(0d);
        System.out.println(whereAmI());

        REVLibError factorError;
        do {
            System.out.println("Hey bitch");
            factorError = flMotorEnc.setPositionConversionFactor(Constants.WHEEL_CONVERSION_FACTOR);
            if (REVLibError.kOk == factorError) {
                factorError = frMotorEnc.setPositionConversionFactor(Constants.WHEEL_CONVERSION_FACTOR);
                if (REVLibError.kOk == factorError) {
                    factorError = blMotorEnc.setPositionConversionFactor(Constants.WHEEL_CONVERSION_FACTOR);
                    if (REVLibError.kOk == factorError) {
                        factorError = brMotorEnc.setPositionConversionFactor(Constants.WHEEL_CONVERSION_FACTOR);
                    }
                }
            }
            System.out.println("I can't because: " + factorError);
        } while (REVLibError.kOk != factorError);


    }

    public double whereAmI() {
        return (Math.abs(frMotorEnc.getPosition())
        + Math.abs(flMotorEnc.getPosition()) 
        + Math.abs(brMotorEnc.getPosition()) 
        + Math.abs(blMotorEnc.getPosition()) 
        / 4);
    }

    public void tokyo(double xAxis, double zAxis) {

        dejaVu.arcadeDrive(xAxis * Constants.SPEED_CONVERSION_FACTOR, zAxis * Constants.SPEED_CONVERSION_FACTOR * -1);
    }

}
