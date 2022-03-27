package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngledHooks extends SubsystemBase {
    private CANSparkMax angledHooks = new CANSparkMax(Constants.ANGLED_HOOK_MOTOR_PORT, MotorType.kBrushless);
    private RelativeEncoder angledHookEncoder = angledHooks.getEncoder();

    public void resetPostition() {
        angledHookEncoder.setPosition(0);
    }

    public void stopHooks() {
        angledHooks.set(0);
    }

    public double getPosition() {
        return (angledHookEncoder.getPosition());
    }

    private boolean canAngledHooksMoveUp() {
        return (getPosition() <= Constants.ANGLED_HOOK_UPPER_LIMIT);
    }

    private boolean canAngledHooksMoveDown() {
        return (getPosition() >= Constants.ANGLED_HOOK_LOWER_LIMIT);
    }

    public void moveHooks(double speed) {
        double effectiveSpeed = speed;
        if (speed > 0) {
            if (!canAngledHooksMoveUp()) {
                effectiveSpeed = 0;
            }
        } else if (speed < 0) {
            if (!canAngledHooksMoveDown()) {
                effectiveSpeed = 0;
            }
        }
        angledHooks.set(effectiveSpeed);

    }
}
