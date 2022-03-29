package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VerticalHooks extends SubsystemBase{
    CANSparkMax rightVerticalHookMotor = new CANSparkMax(Constants.RIGHT_VERTICAL_HOOK_PORT, MotorType.kBrushless);
    CANSparkMax leftVerticalHookMotor = new CANSparkMax(Constants.LEFT_VERTICAL_HOOK_PORT, MotorType.kBrushless);
    RelativeEncoder rightVerticalEncoder = rightVerticalHookMotor.getEncoder();
    RelativeEncoder leftVerticalEncoder = leftVerticalHookMotor.getEncoder();

    public void resetHookPostion(){
        rightVerticalEncoder.setPosition(0);
        leftVerticalEncoder.setPosition(0);
    }
    public double getHookPostion(){
        double rightPostion = rightVerticalEncoder.getPosition();
        double leftPostion = leftVerticalEncoder.getPosition();
        return((rightPostion + leftPostion) / 2);
    }
    public void setHookSpeed(double speed){
        rightVerticalHookMotor.set(speed);
        leftVerticalHookMotor.set(speed);
    }
}
