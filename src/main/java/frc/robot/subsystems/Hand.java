package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hand extends SubsystemBase 
{
    CANSparkMax Hand = new CANSparkMax(Constants.HAND_ID, MotorType.kBrushless);
    private RelativeEncoder encoderHand = Hand.getEncoder();

    public Hand(){
    encoderHand.setPositionConversionFactor(Constants.CONVERSION);
    }

    public void resetposition(){
    encoderHand.setPosition(0d);
    }

    public double handPositon(){
        return ((RelativeEncoder) Hand).getPosition();
    }
}