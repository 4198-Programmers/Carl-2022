package frc.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hooks extends SubsystemBase{
    private CANSparkMax verticalRightHook = new CANSparkMax(Constants.VERTICAL_RIGHT_HOOK_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax verticalLeftHook = new CANSparkMax(Constants.VERTICAL_LEFT_HOOK_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax angledHooks = new CANSparkMax(Constants.ANGLED_HOOK_MOTOR_PORT, MotorType.kBrushless);
    RelativeEncoder verticalRightHookEncoder = verticalRightHook.getEncoder();
    RelativeEncoder verticalLeftHookEncoder = verticalLeftHook.getEncoder();
    RelativeEncoder angledHookEncoder = angledHooks.getEncoder();

    public void verticalHookResetPositon(){
        verticalRightHookEncoder.setPosition(0);
        verticalLeftHookEncoder.setPosition(0);
    }
    public void angledHookResetPosition(){
        angledHookEncoder.setPosition(0);
    }
    public void verticalHooksMove(double speed){
        verticalLeftHook.set(speed);
        verticalRightHook.set(speed);
    }
    public void angledHooksMove(double speed){
        angledHooks.set(speed);
        
    }
    public void verticalHookLimit(double speed, Joystick verticalStick){
        if(verticalRightHookEncoder.getPosition() <= Constants.VERTICAL_HOOK_TOP_LIMIT  
            && verticalLeftHookEncoder.getPosition() <= Constants.VERTICAL_HOOK_TOP_LIMIT
            && verticalStick.getRawAxis(0) > 0){
            verticalLeftHook.set(speed);
            verticalRightHook.set(speed);
        }
        else if(verticalRightHookEncoder.getPosition() >= Constants.VERTICAL_HOOK_TOP_LIMIT 
        && verticalLeftHookEncoder.getPosition() >= Constants.VERTICAL_HOOK_TOP_LIMIT
        && verticalStick.getRawAxis(0) < 0){
            verticalLeftHook.set(0);
            verticalRightHook.set(0);
        }
    }
}
