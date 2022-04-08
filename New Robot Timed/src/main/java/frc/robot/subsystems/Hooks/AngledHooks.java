package frc.robot.subsystems.Hooks;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngledHooks extends SubsystemBase {
    CANSparkMax angledHookMotor = new CANSparkMax(Constants.ANGLED_HOOKS_PORT, MotorType.kBrushless);
    RelativeEncoder angledHookEncoder = angledHookMotor.getEncoder();

    public void setPosition(double position) {
        angledHookEncoder.setPosition(position);
    }

    public double getPosition() {
        return angledHookEncoder.getPosition();
    }

    protected boolean canAngledHooksMoveUp() {
        return angledHookEncoder.getPosition() > Constants.ANGLED_HOOK_UPPER_LIMIT;
    }

    protected boolean canAngledHooksMoveDown() {
        return angledHookEncoder.getPosition() < Constants.ANGLED_HOOK_LOWER_LIMIT;
    }

    public void setSpeed(double speed) {
        double effectiveSpeed = speed;
        if (speed > 0) {
            if (!canAngledHooksMoveUp()) {
                effectiveSpeed = 0;
            }
        }
        if (speed < 0) {
            if (!canAngledHooksMoveDown()) {
                effectiveSpeed = 0;
            }
        }
        angledHookMotor.set(effectiveSpeed);
    }
}