package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Mouth extends SubsystemBase {

    private CANSparkMax mouth = new CANSparkMax(Constants.MOUTH_MOTOR_ID, MotorType.kBrushless);

    public void chompChomp(double speed) {
        mouth.set(speed);
    }

}
