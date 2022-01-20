package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  
  CANSparkMax frontR = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax frontL = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax backR = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_DEVICE_ID, MotorType.kBrushless);
  CANSparkMax backL = new CANSparkMax(Constants.BACK_LEFT_MOTOR_DEVICE_ID, MotorType.kBrushless);

  MotorControllerGroup leftSideDrive = new MotorControllerGroup(frontR, backR);
  MotorControllerGroup rightSideDrive = new MotorControllerGroup(frontL, backL);

  DifferentialDrive allDrive = new DifferentialDrive(leftSideDrive, rightSideDrive);


  public DriveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
