// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

// public class SwerveDrive extends SubsystemBase{
//     CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_PORT, MotorType.kBrushless);
//     CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_PORT, MotorType.kBrushless);
//     CANSparkMax backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_PORT, MotorType.kBrushless);
//     CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_PORT, MotorType.kBrushless);

//     public void swerveDrive(double TurnAngle, double PivotAngle, double Sensitivity){
//     double dZ = Math.tan(TurnAngle)*Sensitivity;
//     double dX = dZ* Math.cos(PivotAngle);
//     double dY = dZ*Math.sin(PivotAngle);

// }
//     public void drive(double forwardSpeed, double sideSpeed, double radianRotation){
        


//     }
// }
