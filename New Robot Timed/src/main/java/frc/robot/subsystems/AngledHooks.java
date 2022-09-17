package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngledHooks extends SubsystemBase{
    CANSparkMax angledHookMotor = new CANSparkMax(Constants.ANGLE_HOOKS_MOTOR_DEVICE_ID, MotorType.kBrushless);
    RelativeEncoder angledHookEncoder = angledHookMotor.getEncoder();
    public double getangledhookdistance(){
        return angledHookEncoder.getPosition();
    }

    public boolean isangledpastupperlimit(){
        return getangledhookdistance() < Constants.ANGLED_HOOK_UPPER_LIMIT;
    }
    public boolean isangledpastlowerlimit(){
        return getangledhookdistance() > Constants.ANGLED_HOOK_LOWER_LIMIT;
    }
    public double getAngledHookPosition(){
        return angledHookEncoder.getPosition();
    }
    public void setAngledHookSpeed(double speed){
        double estimatedspeed = speed;
        if(speed < 0 && isangledpastupperlimit()){
            estimatedspeed = 0;
        }
        if(speed > 0 && isangledpastlowerlimit()){
            estimatedspeed = 0;
        }
        angledHookMotor.set(estimatedspeed);

    }
    public void forgetangledposition(){
        angledHookEncoder.setPosition(0);
    }
}

