package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class VertHooks extends SubsystemBase {
    private CANSparkMax verticalHooksLead = new CANSparkMax(Constants.VERT_HOOKS_OG_MOTOR_DEVICE_ID,
            MotorType.kBrushless);
    private CANSparkMax verticalHooksFollower = new CANSparkMax(Constants.VERT_HOOKS_FOLLOWER_MOTOR_DEVICE_ID,
            MotorType.kBrushless);
    MotorControllerGroup verticalHooks = new MotorControllerGroup(verticalHooksFollower, verticalHooksLead);

    RelativeEncoder vertHookLeadEncoder = verticalHooksLead.getEncoder();
    RelativeEncoder vertHookFollowerEnc = verticalHooksFollower.getEncoder();

    /**
     * Positive values will pull robot up, negative values will lower robot down
     * 
     * @param speed
     */
    public void moveVertHooks(double speed) {
        verticalHooksFollower.set(speed);
        verticalHooksLead.set(speed);
    }

    // public double getVerticalHookHeight() { //actual hook height not motor
    // encoder
    // return Maths.motorConversion((Math.abs(vertHookLeadEncoder.getPosition()) +
    // Math.abs(vertHookFollowerEnc.getPosition()))/2);
    // }

    public void resetHookPosition() {
    }
}
