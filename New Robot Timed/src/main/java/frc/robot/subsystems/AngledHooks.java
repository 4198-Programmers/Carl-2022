package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngledHooks extends SubsystemBase{
    CANSparkMax angledHook = new CANSparkMax(Constants.ANGLED_HOOKS_PORT, MotorType.kBrushless);
    RelativeEncoder angledHookEncoder = angledHook.getEncoder();

    public double hookPosition(){
        return angledHookEncoder.getPosition();
    }
    private boolean canAngledHooksMoveUp(){
        return(hookPosition() < Constants.ANGLED_HOOK_UPPER_LIMIT);
    }
    private boolean canAngledHooksMoveDown(){
        return(hookPosition() > Constants.ANGLED_HOOK_LOWER_LIMIT);
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
        angledHook.set(effectiveSpeed);
    }
}
