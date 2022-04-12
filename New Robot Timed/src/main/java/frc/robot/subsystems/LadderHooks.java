package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LadderHooks extends SubsystemBase {

    private CANSparkMax rightLadderHook = new CANSparkMax(Constants.RIGHT_LADDER_HOOK_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax leftLadderHook = new CANSparkMax(Constants.LEFT_LADDER_HOOK_MOTOR_ID, MotorType.kBrushless);

    MotorControllerGroup ladderHooks = new MotorControllerGroup(rightLadderHook, leftLadderHook);

    RelativeEncoder rightLadderHookEncoder = rightLadderHook.getEncoder();
    RelativeEncoder leftLadderHookEncoder = leftLadderHook.getEncoder();

    public void ladderHooksGoFast(double speed) {
        rightLadderHook.set(speed);
        leftLadderHook.set(speed);
    }

    public double ladderHooksBeAt() {
        return ((rightLadderHookEncoder.getPosition() + leftLadderHookEncoder.getPosition()) / 2);
    }

    public void resetTheLadderHooks() {
        rightLadderHookEncoder.setPosition(0);
        leftLadderHookEncoder.setPosition(0);
    }

}
