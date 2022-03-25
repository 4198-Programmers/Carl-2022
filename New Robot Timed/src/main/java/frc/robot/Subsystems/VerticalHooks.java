package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VerticalHooks extends SubsystemBase{
    private CANSparkMax verticalRightHook = new CANSparkMax(Constants.VERTICAL_RIGHT_HOOK_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax verticalLeftHook = new CANSparkMax(Constants.VERTICAL_LEFT_HOOK_MOTOR_PORT, MotorType.kBrushless);
    RelativeEncoder verticalRightHookEncoder = verticalRightHook.getEncoder();
    RelativeEncoder verticalLeftHookEncoder = verticalLeftHook.getEncoder();
    public void resetPosition(){
        verticalRightHookEncoder.setPosition(0);
        verticalLeftHookEncoder.setPosition(0);
    }
    public void move(double speed){
        verticalLeftHook.set(speed);
        verticalRightHook.set(speed);
    }
    public double getPostion(){
        double a = verticalRightHookEncoder.getPosition();
        double b = verticalLeftHookEncoder.getPosition();
        return( (a+b) / 2);
    }
    public void heightLimit(double speed, Joystick verticalStick){
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
