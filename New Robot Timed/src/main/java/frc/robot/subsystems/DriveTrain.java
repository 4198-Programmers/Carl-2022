package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  CANSparkMax frontRDrive = new CANSparkMax(Constants.FRONT_RIGHT_DRIVE_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax frontLDrive = new CANSparkMax(Constants.FRONT_LEFT_DRIVE_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax backRDrive = new CANSparkMax(Constants.BACK_RIGHT_DRIVE_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax backLDrive = new CANSparkMax(Constants.BACK_LEFT_DRIVE_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax frontRSpin = new CANSparkMax(Constants.FRONT_RIGHT_SPIN_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax frontLSpin = new CANSparkMax(Constants.FRONT_LEFT_SPIN_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax backRSpin = new CANSparkMax(Constants.BACK_RIGHT_SPIN_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax backLSpin = new CANSparkMax(Constants.BACK_LEFT_SPIN_MOTOR_DEVICE_ID, MotorType.kBrushless);

  Translation2d frontRMotorPos = new Translation2d(0.315, 0.315);
  Translation2d frontLMotorPos = new Translation2d(-0.315,0.315);
  Translation2d backRMotorPos = new Translation2d(0.315, -0.315);
  Translation2d backLMotorPos = new Translation2d(-0.315, -0.315);  

  SwerveDriveKinematics drivingSwerve = new SwerveDriveKinematics(frontRMotorPos, frontLMotorPos, backRMotorPos, backLMotorPos);

  ChassisSpeeds speeds;
  SwerveModuleState[] moduleStates = drivingSwerve.toSwerveModuleStates(speeds);

  SwerveModuleState frontRModule = moduleStates[0];
  SwerveModuleState frontLModule = moduleStates[1];
  SwerveModuleState backRModule = moduleStates[2];
  SwerveModuleState backLModule = moduleStates[3];

  public void greenLight(double xSpeed, double ySpeed, double rotationInRadiansSpeed){
    speeds = new ChassisSpeeds(xSpeed, ySpeed, rotationInRadiansSpeed);
  }
}
