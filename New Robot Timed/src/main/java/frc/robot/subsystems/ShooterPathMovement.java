package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterPathMovement extends SubsystemBase {
    private CANSparkMax flyWheelMotor = new CANSparkMax(Constants.FLY_WHEEL_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax internalMoverMotor = new CANSparkMax(Constants.BALL_MOVER_MOTOR_DEVICE_ID,
            MotorType.kBrushless);
    private CANSparkMax intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_DEVICE_ID, MotorType.kBrushless);

    /** top of shooter wheel speeds (go pew pew fast) */
    public void setFlySpeed(double speed) {
        flyWheelMotor.set(speed);
    }

    public double getFlySpeed() {
        return flyWheelMotor.get();
    }

    public void setMoverSpeed(double speed) {
        internalMoverMotor.set(speed);
    }

    public void setIntakeSpeed(double speed) {
        intakeMotor.set(speed);
    }

}
