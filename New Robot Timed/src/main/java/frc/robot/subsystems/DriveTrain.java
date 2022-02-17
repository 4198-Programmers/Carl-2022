package frc.robot.subsystems;



import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    private CANSparkMax frontR = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax frontL = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax backR = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax backL = new CANSparkMax(Constants.BACK_LEFT_MOTOR_PORT, MotorType.kBrushless);
    private RelativeEncoder frontREnc = frontR.getEncoder();
    private RelativeEncoder frontLEnc = frontL.getEncoder();
    private RelativeEncoder backREnc = backR.getEncoder();
    private RelativeEncoder backLEnc = backL.getEncoder();

    MotorControllerGroup leftDrive = new MotorControllerGroup(frontL, backL);
    MotorControllerGroup rightDrive = new MotorControllerGroup(frontR, backR);
    MotorControllerGroup motorControllerGroup = new MotorControllerGroup(frontR, frontL, backR, backL);
    private DifferentialDrive allDrive = new DifferentialDrive(leftDrive, rightDrive);


    public DriveTrain(){
    }
            
    public void resetPosition(){
            frontLEnc.setPosition(0d);
            frontREnc.setPosition(0d);
            backLEnc.setPosition(0d);
            backREnc.setPosition(0d);
    }
    public double getPosition(){
        double encCurrentPosition = (frontREnc.getPosition());
        encCurrentPosition =+ (frontLEnc.getPosition());
        encCurrentPosition =+ (backREnc.getPosition());
        encCurrentPosition =+ (backLEnc.getPosition());
        return encCurrentPosition/4d;
    }
    public void greenLight(double zRotate, double xAxis){
        allDrive.arcadeDrive(Constants.DRIVE_SPEED_MULTIPLIER * zRotate, Constants.DRIVE_SPEED_MULTIPLIER *xAxis);
    }
}
