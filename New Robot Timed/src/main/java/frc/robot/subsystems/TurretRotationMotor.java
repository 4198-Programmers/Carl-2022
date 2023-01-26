package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretRotationMotor extends SubsystemBase {

    private TalonSRX turretRotationMotor = new TalonSRX(Constants.TURRET_ROTATION_MOTOR_ID);

   

    public void turretRotationMotorActivate(double speed) {
        turretRotationMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }
}