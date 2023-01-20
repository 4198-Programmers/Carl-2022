package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PrimaryMotor extends SubsystemBase {
    private CANSparkMax primaryMotor = new CANSparkMax(Constants.PRIMARY_MOTOR_ID, MotorType.kBrushless);

    public PrimaryMotor() {

        primaryMotor.setOpenLoopRampRate(0.1);

    }

    public void primaryMotorTest(double speed) {
        primaryMotor.set(speed);
    }
}