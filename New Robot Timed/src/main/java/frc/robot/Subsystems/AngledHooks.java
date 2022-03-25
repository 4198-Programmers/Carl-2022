package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngledHooks extends SubsystemBase{
    private CANSparkMax angledHooks = new CANSparkMax(Constants.ANGLED_HOOK_MOTOR_PORT, MotorType.kBrushless);
    private RelativeEncoder angledHookEncoder = angledHooks.getEncoder();
    public void resetPostition(){
        angledHookEncoder.setPosition(0);
    }
    public void moveHooks(double speed){
        angledHooks.set(speed);
    }
    public void stopHooks(){
        angledHooks.set(0);
    }
    public double getPosition(){
        return(angledHookEncoder.getPosition());
    }
    public void heightLimit(double speed, Joystick rightJoystick){
        if(angledHookEncoder.getPosition() <= Constants.ANGLED_HOOK_LIMIT && rightJoystick.getRawAxis(1) >= 0){
            angledHooks.set(speed);
        }
        else if(angledHookEncoder.getPosition() >= Constants.ANGLED_HOOK_LIMIT && rightJoystick.getRawAxis(1) < 0){
            angledHooks.set(0);
        }
    }
}
