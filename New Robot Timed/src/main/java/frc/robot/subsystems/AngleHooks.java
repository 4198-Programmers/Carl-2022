package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngleHooks extends SubsystemBase {
    private CANSparkMax angledHooks = new CANSparkMax(Constants.ANGLE_HOOKS_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private RelativeEncoder angledEncoder = angledHooks.getEncoder();
    
    
    public double anglePosition(){
        return angledEncoder.getPosition();
    }

    public void resetAngleHooks(){
        angledEncoder.setPosition(0);
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
    

}
