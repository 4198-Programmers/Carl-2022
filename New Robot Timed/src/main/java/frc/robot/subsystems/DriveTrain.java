package frc.robot.subsystems;



import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    private CANSparkMax frontR = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_PORT_ID, MotorType.kBrushless);
    private CANSparkMax frontL = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_PORT_ID, MotorType.kBrushless);
    private CANSparkMax backR = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_PORT_ID, MotorType.kBrushless);
    private CANSparkMax backL = new CANSparkMax(Constants.BACK_LEFT_MOTOR_PORT_ID, MotorType.kBrushless);
    private RelativeEncoder frontREnc = frontR.getEncoder();
    private RelativeEncoder frontLEnc = frontL.getEncoder();
    private RelativeEncoder backREnc = backR.getEncoder();
    private RelativeEncoder backLEnc = backL.getEncoder();

    MotorControllerGroup leftDrive = new MotorControllerGroup(frontL, backL);
    MotorControllerGroup rightDrive = new MotorControllerGroup(frontR, backR);
    DifferentialDrive allDrive = new DifferentialDrive(leftDrive, rightDrive);


    public DriveTrain(){
        double conversionFactor = 1/Constants.WHEEL_CONVERSION_FACTOR;
        frontREnc.setPositionConversionFactor(conversionFactor);
        frontLEnc.setPositionConversionFactor(conversionFactor);
        backREnc.setPositionConversionFactor(conversionFactor);
        backLEnc.setPositionConversionFactor(conversionFactor);
    }
            
    public void resetPosition(){
            frontLEnc.setPosition(0d);
            frontREnc.setPosition(0d);
            backLEnc.setPosition(0d);
            backREnc.setPosition(0d);
    }
    public double getPosition(){
        double encCurrentPosition = (Math.abs(frontREnc.getPosition()));
        encCurrentPosition += Math.abs((frontLEnc.getPosition()));
        encCurrentPosition += Math.abs((backREnc.getPosition()));
        encCurrentPosition += Math.abs((backLEnc.getPosition()));
        return encCurrentPosition/4d;
    }
    public void greenLight(double xAxis, double zRotate){
        allDrive.arcadeDrive(Constants.DRIVE_SPEED_MULTIPLIER * xAxis, Constants.DRIVE_SPEED_MULTIPLIER *zRotate);
    }
}
