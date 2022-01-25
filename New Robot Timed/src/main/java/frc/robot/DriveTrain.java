package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveTrain {
    private CANSparkMax frontR = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax frontL = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax backR = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax backL = new CANSparkMax(Constants.BACK_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private RelativeEncoder frontREnc = frontR.getEncoder();
    private RelativeEncoder frontLEnc = frontL.getEncoder();
    private RelativeEncoder backREnc = backR.getEncoder();
    private RelativeEncoder backLEnc = backL.getEncoder();

    private MotorControllerGroup leftSideDrive = new MotorControllerGroup(frontR, backR);
    private MotorControllerGroup rightSideDrive = new MotorControllerGroup(frontL, backL);
  
    private DifferentialDrive allDrive = new DifferentialDrive(leftSideDrive, rightSideDrive);

    private double conversionFactor = 12.75;

    DriveTrain(){
        frontLEnc.setPositionConversionFactor(conversionFactor);
        frontREnc.setPositionConversionFactor(conversionFactor);
        backLEnc.setPositionConversionFactor(conversionFactor);
        backREnc.setPositionConversionFactor(conversionFactor);
    }

    /**Sets encoder positions to 0 */
    public void resetPosition(){
        frontLEnc.setPosition(0);
        frontREnc.setPosition(0);
        backLEnc.setPosition(0);
        backREnc.setPosition(0);
    }

    public double findPosition(){
        double encCurrentPosition = frontLEnc.getPosition();
        encCurrentPosition += frontREnc.getPosition();
        encCurrentPosition += backREnc.getPosition();
        encCurrentPosition += backLEnc.getPosition();
        return encCurrentPosition/4d ;
    }


    /**
     * Assigns two speeds to the xAxis of the Robot and the Rotation of the Robot. Negative values of xAxis
     * will move backwards, negative values of the zRotation will rotate counter-clockwise.
     * Joysticks allow these to be control by controller axes
     * @param xAxis
     * @param zRotate
     */
    public void greenLight(double xAxis, double zRotate){
        
        allDrive.arcadeDrive(xAxis, zRotate);
    }

  
}