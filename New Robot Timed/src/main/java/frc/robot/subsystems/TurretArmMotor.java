package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretArmMotor extends SubsystemBase {

    private TalonSRX turretArmMotor = new TalonSRX(Constants.TURRET_ARM_MOTOR_ID);

    public void turretArmMotorActivate(double speed) {
        turretArmMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }
}