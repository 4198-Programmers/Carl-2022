package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

<<<<<<< Updated upstream:New Robot Timed/src/main/java/frc/robot/Shooter.java
public class Shooter {
    private CANSparkMax flyWheelMotor = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax internalMoverMotor = new CANSparkMax(Constants.BALL_MOVER_MOTOR_DEVICE_ID, MotorType.kBrushless);
=======
import frc.robot.Constants;

public class ShooterPathMovement {
    private CANSparkMax flyWheelMotor = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax internalMoverMotor = new CANSparkMax(Constants.BALL_MOVER_MOTOR_DEVICE_ID,
            MotorType.kBrushless);
    private CANSparkMax intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_DEVICE_ID, MotorType.kBrushless);
>>>>>>> Stashed changes:New Robot Timed/src/main/java/frc/robot/subsystems/ShooterPathMovement.java

    /** top of shooter wheel speeds (go pew pew fast) */
    public void setFlySpeed(double speed) {
        flyWheelMotor.set(speed);
    }

<<<<<<< Updated upstream:New Robot Timed/src/main/java/frc/robot/Shooter.java
=======
    public void setMoverSpeed(double speed) {
        internalMoverMotor.set(speed);
    }

    public void setIntakeSpeed(double speed) {
        intakeMotor.set(speed);
    }

>>>>>>> Stashed changes:New Robot Timed/src/main/java/frc/robot/subsystems/ShooterPathMovement.java
}
