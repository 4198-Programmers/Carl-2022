package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SecondaryMotor extends SubsystemBase {

    private CANSparkMax secondaryMotor = new CANSparkMax(Constants.SECONDARY_MOTOR_ID, MotorType.kBrushless);

    public SecondaryMotor() {

        secondaryMotor.setOpenLoopRampRate(0.1);

    }

    public void secondaryMotorTest(double speed) {
        secondaryMotor.set(speed);
    }

}
