package frc.robot.command.hookcommands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class MoveVerticalHookDown extends CommandBase{
    Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);
    JoystickButton verticalHookDownBTN = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
    private CANSparkMax vertHooks = new CANSparkMax(Constants.ANGLE_HOOKS_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private RelativeEncoder vertHooksEnc = vertHooks.getEncoder();
    Hooks climber = new Hooks();
    private PullVertHooksIn pullVertHooksIn;
    
    public MoveVerticalHookDown(){
        addRequirements(climber);
    }
    public double findVertMotorPosition(){
        double encCurrentPosition = vertHooksEnc.getPosition();
        return encCurrentPosition;
    }
    @Override
    public void execute() {
        verticalHookDownBTN.whenHeld(pullVertHooksIn);
    }
}