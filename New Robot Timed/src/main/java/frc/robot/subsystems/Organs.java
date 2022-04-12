package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Organs extends SubsystemBase {

    private CANSparkMax bowels = new CANSparkMax(Constants.BOWELS_MOTOR_ID, MotorType.kBrushless);

    public void bowelMovement(double speed) {
        bowels.set(speed);
    }

}
