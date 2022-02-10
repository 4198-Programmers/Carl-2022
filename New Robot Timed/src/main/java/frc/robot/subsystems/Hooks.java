package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Maths;


public class Hooks extends SubsystemBase {
    private CANSparkMax verticalHooks = new CANSparkMax(Constants.VERT_HOOKS_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private CANSparkMax angledHooks = new CANSparkMax(Constants.ANGLE_HOOKS_MOTOR_DEVICE_ID, MotorType.kBrushless);
    
    RelativeEncoder vertHookEncoder = verticalHooks.getEncoder();
    RelativeEncoder angledHookEncoder = angledHooks.getEncoder();

    /**
     * Positive values will pull robot up, negative values will lower robot down
     * 
     * @param speed
     */
    public void moveVertHooks(double speed) {
        verticalHooks.set(speed);
    }

    /**
     * Positive values will move hook more vertical, negative will move hook more
     * horizontal
     * 
     * @param speed
     */
    public void moveAngledHooks(double speed) {
        angledHooks.set(speed);
    }

    public void resetAllHooksPosition() {
        angledHookEncoder.setPosition(0d);
        vertHookEncoder.setPosition(0d);
    }
    
    public void resetAngleHooksPosition(){
        angledHookEncoder.setPosition(0d);
    }
    
    public void resetVertHooksPosition(){
        vertHookEncoder.setPosition(0d);
    }


    public double getVerticalHookHeight() {
        return Maths.motorConversion(vertHookEncoder.getPosition());
    }

    public double getAngledHookDegree() {
        return Maths.motorConversion(angledHookEncoder.getPosition());
    }

}
