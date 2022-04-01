package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VerticalHooks extends SubsystemBase{
    CANSparkMax verticalHookOne = new CANSparkMax(Constants.RIGHT_VERTICAL_HOOK_PORT, MotorType.kBrushless);
    CANSparkMax verticalHookTwo = new CANSparkMax(Constants.LEFT_VERTICAL_HOOK_PORT, MotorType.kBrushless);
    RelativeEncoder verticalHookOneEncoder = verticalHookOne.getEncoder();
    RelativeEncoder verticalHookTwoEncoder = verticalHookTwo.getEncoder();
    MotorControllerGroup verticalHooks = new MotorControllerGroup(verticalHookOne, verticalHookTwo);

    public double getPosition(){
        double hookOnePosition =  verticalHookOneEncoder.getPosition();
        double hookTwoPosition = verticalHookTwoEncoder.getPosition();
        return((hookOnePosition + hookTwoPosition) / 2);
    }
    public void resetPosition(){
        verticalHookOneEncoder.setPosition(0);
        verticalHookTwoEncoder.setPosition(0);
    }
    private boolean canVerticalHooksMoveUp(){
        return( getPosition() < Constants.VERTICAL_HOOK_UPPER_LIMIT);
    }
    private boolean canVerticalHooksMoveDown(){
        return(getPosition() > Constants.VERTICAL_HOOK_LOWER_LIMIT);
    }

    public void moveHooks(double speed){
        double effectiveSpeed = speed;
        if(speed > 0){
            if(!canVerticalHooksMoveUp()){
                effectiveSpeed = 0;
            }
        }
        if(speed < 0){
            if(!canVerticalHooksMoveDown()){
                effectiveSpeed = 0;
            }
        }
        verticalHooks.set(effectiveSpeed);
    }
}
