package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngledHooks extends SubsystemBase{
    CANSparkMax angledHooks = new CANSparkMax(Constants.ANGLED_HOOKS_PORT, MotorType.kBrushless);
    RelativeEncoder angledHookEncoder = angledHooks.getEncoder();

    public void resetPosition(){
        angledHookEncoder.setPosition(0);
    }
    public double getPosition(){
        return(angledHookEncoder.getPosition());
    }
    public boolean canAngledHooksMoveUp(){
        return(getPosition() <= Constants.ANGLED_HOOK_UPPER_LIMIT);
    }
    public boolean canAngledHooksMoveDown(){
        return(getPosition() >= Constants.ANGLED_HOOK_LOWER_LIMIT);
    }
    public void moveHooks(double speed){
        double effectiveSpeed = speed;
        if(speed > 0){
            if(!canAngledHooksMoveUp()){
                effectiveSpeed = 0;
            }
        }
        if(speed < 0){
            if(!canAngledHooksMoveDown()){
                effectiveSpeed = 0;
            }
        }
        angledHooks.set(effectiveSpeed);
    }
}
