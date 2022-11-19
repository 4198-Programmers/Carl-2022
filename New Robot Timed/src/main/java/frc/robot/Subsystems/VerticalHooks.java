package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class VerticalHooks extends SubsystemBase{
    
    private CANSparkMax verticalHook = new CANSparkMax(Constants.VERTICAL_HOOK_ID, MotorType.kBrushless);
    private CANSparkMax followerHook = new CANSparkMax(Constants.FOLLOWER_HOOK_ID, MotorType.kBrushless);

}
