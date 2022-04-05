package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tunnel extends SubsystemBase {
    private CANSparkMax tunnelMotor = new CANSparkMax(Constants.TUNNEL_MOTOR_ID, MotorType.kBrushless);

    public void setSpeed(double speed) {
        tunnelMotor.set(speed);
    }
}
