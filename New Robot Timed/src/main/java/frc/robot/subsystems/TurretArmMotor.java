package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TurretArmMotor extends SubsystemBase {

    private CANSparkMax turretArmMotor = new CANSparkMax(Constants.TURRET_ARM_MOTOR_ID, MotorType.kBrushless);

    public TurretArmMotor() {

        turretArmMotor.setOpenLoopRampRate(0.1);

    }

    public void turretArmMotorActivate(double speed) {
        turretArmMotor.set(speed);
    }
}