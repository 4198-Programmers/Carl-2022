package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase 
{
    CANSparkMax Arm = new CANSparkMax(Constants.ARM_ID, MotorType.kBrushless);
    private RelativeEncoder encoderArm = Arm.getEncoder();

    public Arm(){
    encoderArm.setPositionConversionFactor(Constants.CONVERSION);
    }

    public void resetposition(){
    encoderArm.setPosition(0d);
    }

    public double bottomPositon(){
        return ((RelativeEncoder) Arm).getPosition();
    }
}