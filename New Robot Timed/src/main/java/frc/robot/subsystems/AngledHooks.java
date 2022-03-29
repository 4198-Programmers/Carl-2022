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
    public void setSpeed(double speed){
        angledHooks.set(speed);
    }
}
