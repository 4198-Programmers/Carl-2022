package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tunnel extends SubsystemBase {
    CANSparkMax TunnelMotor = new CANSparkMax(Constants.TUNNEL_MOTOR_PORT, MotorType.kBrushless);

    public void setTunnelSpeed(double speed) {
        TunnelMotor.set(speed);
    }
}