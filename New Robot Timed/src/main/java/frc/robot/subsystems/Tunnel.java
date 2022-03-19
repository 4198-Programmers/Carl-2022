package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tunnel extends SubsystemBase {

    private CANSparkMax internalMoverMotor = new CANSparkMax(Constants.BALL_MOVER_MOTOR_DEVICE_ID,
            MotorType.kBrushless);

    public void setMoverSpeed(double speed) {
        internalMoverMotor.set(speed);
    }

}
