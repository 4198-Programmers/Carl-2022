package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSystem extends SubsystemBase {
    private CANSparkMax flyWheel = new CANSparkMax(Constants.FLYWHEEL_MOTOR_PORT, MotorType.kBrushless);

    public void setFlyWheelSpeed(double speed) {
        flyWheel.set(speed);
    }

    public void stop() {
        flyWheel.set(0);
    }

    public double getSpeed() {
        return flyWheel.get();
    }
}
