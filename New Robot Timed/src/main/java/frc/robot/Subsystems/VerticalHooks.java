package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VerticalHooks extends SubsystemBase{
    private CANSparkMax verticalRightHook = new CANSparkMax(Constants.VERTICAL_RIGHT_HOOK_MOTOR_PORT, MotorType.kBrushless);
    private CANSparkMax verticalLeftHook = new CANSparkMax(Constants.VERTICAL_LEFT_HOOK_MOTOR_PORT, MotorType.kBrushless);
    private RelativeEncoder verticalRightHookEncoder = verticalRightHook.getEncoder();
    private RelativeEncoder verticalLeftHookEncoder = verticalLeftHook.getEncoder();
    private MotorControllerGroup verticalHooks = new MotorControllerGroup(verticalRightHook, verticalLeftHook);
    public void resetPosition(){
        verticalRightHookEncoder.setPosition(0);
        verticalLeftHookEncoder.setPosition(0);
    }
    public void stop(){
        verticalHooks.set(0);
    }
    public double getPosition(){
        double a = verticalRightHookEncoder.getPosition();
        double b = verticalLeftHookEncoder.getPosition();
        return( (a+b) / 2);
    }
    private boolean canHooksMoveUp(){
        return(getPosition() <= Constants.VERTICAL_HOOK_TOP_LIMIT);
    }
    private boolean canHooksMoveDown(){
        return(getPosition() >= Constants.VERTICAL_HOOK_LOWER_LIMIT);
    }
    public void moveHooks(double speed){
        double effectiveSpeed = speed;
        if(speed > 0) {
            // have it go up until it starts rewind itself
            if(!canHooksMoveUp()){
                effectiveSpeed = 0;
            }
        }
        else if(speed < 0){
            if(!canHooksMoveDown())
                effectiveSpeed = 0;
        }

        verticalHooks.set(effectiveSpeed);
    }
}
