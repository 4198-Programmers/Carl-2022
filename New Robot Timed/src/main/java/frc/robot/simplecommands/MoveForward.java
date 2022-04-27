package frc.robot.simplecommands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class MoveForward extends CommandBase{
    DriveTrain driver;
    boolean isFinished;

    private CANSparkMax frontR = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax frontL = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax backR = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax backL = new CANSparkMax(Constants.BACK_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private RelativeEncoder frontREnc = frontR.getEncoder();
    private RelativeEncoder frontLEnc = frontL.getEncoder();
    private RelativeEncoder backREnc = backR.getEncoder();
    private RelativeEncoder backLEnc = backL.getEncoder();

    double frontLEncoder;
    double frontREncoder;
    double backLEncoder;
    double backREncoder;

    public MoveForward(DriveTrain vroomVroomSub) {
        driver = vroomVroomSub;
        addRequirements(vroomVroomSub);
    }

    @Override
    public void initialize() {
        frontLEncoder = frontLEnc.getPosition();
        frontREncoder = frontREnc.getPosition();
        backLEncoder = backLEnc.getPosition();
        backREncoder = backREnc.getPosition();
    }

    @Override
    public void execute() {
        driver.greenLight(0, 0.25);
        if(isFinished==true) {
            driver.greenLight(0, Constants.FREEZE);
        }
    }

    @Override
    public boolean isFinished() {
        double encCurrentPosition = Math.abs(frontLEncoder);
        encCurrentPosition += Math.abs(frontREncoder);
        encCurrentPosition += Math.abs(backLEncoder);
        encCurrentPosition += Math.abs(backREncoder);
        encCurrentPosition /= 4d;
        isFinished = (driver.findPosition() == encCurrentPosition);
        return isFinished;
    }
}
