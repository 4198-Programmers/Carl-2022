package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class AnglesHooks extends SubsystemBase {

    private CANSparkMax angleHooks = new CANSparkMax(Constants.ANGLE_HOOK_MOTOR_ID, MotorType.kBrushless);
    RelativeEncoder angleHooksEnc = angleHooks.getEncoder();

    public double getPosition(){

        return(angleHooksEnc.getPosition());

    }   
    
    public void resetPosition(){

        angleHooksEnc.setPosition(0);

    }

    public void angleHooksMove(double speed){

        double expectedspeed = speed;
        if(getPosition() >= Constants.OUTER_LIMIT && speed > 0){

            expectedspeed = 0;

        }

        if(getPosition() <= Constants.LOWER_LIMIT && speed < 0){

            expectedspeed = 0;
        }
        angleHooks.set(expectedspeed);

        
    }

}
