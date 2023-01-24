package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Bottom extends SubsystemBase 
{
    CANSparkMax Bottom = new CANSparkMax(Constants.BOTTOM_ID, MotorType.kBrushless);
    private RelativeEncoder encoderBottom = Bottom.getEncoder();

    public Bottom(){
    encoderBottom.setPositionConversionFactor(Constants.CONVERSION);
    }

    public void resetposition(){
    encoderBottom.setPosition(0d);
    }

    public double bottomPositon(){
        return ((RelativeEncoder) Bottom).getPosition();
    }
}
