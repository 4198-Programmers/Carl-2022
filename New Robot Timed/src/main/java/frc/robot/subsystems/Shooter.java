package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

    private CANSparkMax shootShootMotor = new CANSparkMax(Constants.SHOOTER_MOTOR_ID, MotorType.kBrushless);

    public void shooterShoots(double speed) {
        shootShootMotor.set(speed);
    }

    public double whereShoot() {
        return shootShootMotor.get();
    }
}
