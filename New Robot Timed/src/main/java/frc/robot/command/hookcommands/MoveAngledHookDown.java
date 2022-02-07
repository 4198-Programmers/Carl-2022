package frc.robot.command.hookcommands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.Hooks;

public class MoveAngledHookDown extends CommandBase{
    private MoveCloserToZeroDegrees moveCloserToZeroDegrees;
    private CANSparkMax angledHooks = new CANSparkMax(Constants.ANGLE_HOOKS_MOTOR_DEVICE_ID, MotorType.kBrushless);
    private RelativeEncoder angledHooksEnc = angledHooks.getEncoder();
    Hooks climber = new Hooks();
    Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);
    JoystickButton angledHookDownBTN = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
    
    public MoveAngledHookDown(){
        addRequirements(climber);
    }
    public double findAngledMotorPosition(){
        double encCurrentPosition = angledHooksEnc.getPosition();
        return encCurrentPosition;
    }
    @Override
    public void execute() {
        angledHookDownBTN.whenHeld(moveCloserToZeroDegrees);
    }
}