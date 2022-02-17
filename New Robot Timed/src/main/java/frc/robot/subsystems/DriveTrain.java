package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
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

    MotorControllerGroup rightSide = new MotorControllerGroup(frMotor, brMotor);
    MotorControllerGroup leftSide = new MotorControllerGroup(flMotor, blMotor);

    DifferentialDrive dejaVu = new DifferentialDrive(leftSide, rightSide);

    private double convert;

    public DriveTrain() {
        frMotorEnc.setPositionConversionFactor(convert);
        flMotorEnc.setPositionConversionFactor(convert);
        brMotorEnc.setPositionConversionFactor(convert);
        blMotorEnc.setPositionConversionFactor(convert);
    }
    
    public void resetPosition() {

        frMotorEnc.setPositionConversionFactor(0);
        flMotorEnc.setPositionConversionFactor(0);
        brMotorEnc.setPositionConversionFactor(0);
        blMotorEnc.setPositionConversionFactor(0);

    }

    public double whereAmI() {

        return (frMotorEnc.getPosition() + flMotorEnc.getPosition() + brMotorEnc.getPosition() + blMotorEnc.getPosition()) / 4;

    }

    public void tokyo(double xAxis, double zAxis) {

        dejaVu.arcadeDrive(xAxis, zAxis);
    }

}
