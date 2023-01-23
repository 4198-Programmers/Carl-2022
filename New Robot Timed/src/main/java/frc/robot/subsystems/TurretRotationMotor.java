package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretRotationMotor extends SubsystemBase {

    private CANSparkMax turretRotationMotor = new CANSparkMax(Constants.TURRET_ROTATION_MOTOR_ID, MotorType.kBrushless);

    public TurretRotationMotor() {

        turretRotationMotor.setOpenLoopRampRate(0.1);

    }

    public void turretRotationMotorActivate(double speed) {
        turretRotationMotor.set(speed);
    }
}