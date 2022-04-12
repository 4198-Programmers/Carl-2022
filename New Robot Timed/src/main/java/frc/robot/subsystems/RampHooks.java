package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RampHooks extends SubsystemBase {

    private CANSparkMax rampHooks = new CANSparkMax(Constants.RAMP_HOOKS_MOTOR_ID, MotorType.kBrushless);

    RelativeEncoder rampHooksEncoder = rampHooks.getEncoder();

    public void rampHooksGoFast(double speed) {
        rampHooks.set(speed);
    }

    public double rampHooksBeAt() {
        return rampHooksEncoder.getPosition();
    }

    public void resetTheRampHooks() {
        rampHooksEncoder.setPosition(0);
    }
}
