package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Hooks {
    private CANSparkMax verticalHooks = new CANSparkMax(Constants.VERT_HOOKS_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax angledHooks = new CANSparkMax(Constants.ANGLE_HOOKS_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private RelativeEncoder verticalHooksEnc = verticalHooks.getEncoder();
    private RelativeEncoder angledHooksEnc = angledHooks.getEncoder();

    /**
     * Positive values will pull robot up, negative values will lower robot down
     * @param speed
     */
    public void moveVertHooks(double speed)
    {
        verticalHooks.set(speed);
    }

    /**
     * Positive values will pull robot up, negative values will lower robot down
     * @param speed
     */
    public void moveAngledHooks(double speed)
    {
        angledHooks.set(speed);
    }

    public double findAngledMotorPosition(){
        double encCurrentPosition = angledHooksEnc.getPosition();
        return encCurrentPosition;
    }
}
