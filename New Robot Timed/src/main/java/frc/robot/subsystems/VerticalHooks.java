package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VerticalHooks extends SubsystemBase{
    CANSparkMax verticalOGHookMotor = new CANSparkMax(Constants.VERT_HOOKS_OG_MOTOR_DEVICE_ID, MotorType.kBrushless);
    CANSparkMax verticalFollowerHookMotor = new CANSparkMax(Constants.VERT_HOOKS_FOLLOWER_MOTOR_DEVICE_ID, MotorType.kBrushless);

    MotorControllerGroup verticalHooks = new MotorControllerGroup(verticalOGHookMotor, verticalFollowerHookMotor);

    RelativeEncoder vertiaclOGEncoder = verticalOGHookMotor.getEncoder();
    RelativeEncoder verticalFollowerEncoder = verticalFollowerHookMotor.getEncoder();

    public boolean isverticalhookspastupperlimit(){
        return ((vertiaclOGEncoder.getPosition() + verticalFollowerEncoder.getPosition())/2) > Constants.VERTICAL_HOOK_UPPER_LIMIT;
    }
    public boolean isverticalhookspastlowerlimit(){
        return((vertiaclOGEncoder.getPosition() + verticalFollowerEncoder.getPosition())/2) < Constants.VERTICAL_HOOK_LOWER_LIMIT;
    }
    public void setVerticalhookSpeed(double speed){
        double estimatedspeed = speed;
        if(speed>0 && isverticalhookspastupperlimit()){
            estimatedspeed = 0;
        }
        if(speed<0 && isverticalhookspastlowerlimit()){
            estimatedspeed = 0;
        }

        verticalHooks.set(estimatedspeed);
    }
    public void resetvertposition(){
        vertiaclOGEncoder.setPosition(0);
        verticalFollowerEncoder.setPosition(0);
    }
}
