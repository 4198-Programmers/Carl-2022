package frc.robot.subsystems.Hooks;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VerticalHooks extends SubsystemBase{
    CANSparkMax verticalHooklead = new CANSparkMax(Constants.RIGHT_VERTICAL_HOOK_PORT, MotorType.kBrushless);
    CANSparkMax verticalHookFollower = new CANSparkMax(Constants.LEFT_VERTICAL_HOOK_PORT, MotorType.kBrushless);
    RelativeEncoder verticalHookLeadEncoder = verticalHooklead.getEncoder();
    RelativeEncoder verticalHookFollowerEncoder = verticalHookFollower.getEncoder();
    MotorControllerGroup verticalHooks = new MotorControllerGroup(verticalHooklead, verticalHookFollower);
    public double getVerticalHookPostion(){
        double vhle = verticalHookLeadEncoder.getPosition();
        double vhfe = verticalHookFollowerEncoder.getPosition();
        return((Math.abs(vhle) + Math.abs(vhfe)) / 2);
    }
    public void setPosition(double position){
        verticalHookLeadEncoder.setPosition(position);
        verticalHookFollowerEncoder.setPosition(position);
    }
    private boolean canVerticalHooksMoveUp(){
        return getVerticalHookPostion() < Constants.VERTICAL_HOOK_UPPER_LIMIT;
    }
    private boolean canVerticalHooksMoveDown(){
        return getVerticalHookPostion() > Constants.VERTICAL_HOOK_LOWER_LIMIT;
    }
    //doin ur mom lol - Oren
    public void setSpeed(double speed){
        double effectiveSpeed = speed;
        if(speed > 0){
            if(!canVerticalHooksMoveUp()){
                verticalHooks.set(0);
            }
        }
        if(speed < 0){
            if(!canVerticalHooksMoveDown()){
                verticalHooks.set(0);
            }
        }
        verticalHooks.set(effectiveSpeed);
    }

}
