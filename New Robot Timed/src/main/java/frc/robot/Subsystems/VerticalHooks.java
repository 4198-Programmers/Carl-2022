package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class VerticalHooks extends SubsystemBase{
    
    private CANSparkMax verticalHook = new CANSparkMax(Constants.VERTICAL_HOOK_ID, MotorType.kBrushless);
    private CANSparkMax followerHook = new CANSparkMax(Constants.FOLLOWER_HOOK_ID, MotorType.kBrushless);
    MotorControllerGroup hookMotors = new MotorControllerGroup(verticalHook, followerHook);

    RelativeEncoder verticalHookEnc = verticalHook.getEncoder();
    RelativeEncoder followerHookEnc = followerHook.getEncoder();


    public double getPosition(){

        return(verticalHookEnc.getPosition() + followerHookEnc.getPosition())/ 2;

    }

    public void resetPosition(){

        verticalHookEnc.setPosition(0);
        followerHookEnc.setPosition(0);

    }

    public void verticalHookMove(double speed){

        double expectedspeed = speed;

        if(getPosition() <= Constants.UPPER_VERT_LIMIT && speed < 0){

            expectedspeed = 0;

        }

        if(getPosition() >= Constants.LOWER_VERT_LIMIT && speed > 0){

            expectedspeed = 0;

        }
        hookMotors.set(expectedspeed);
        
    }

}
