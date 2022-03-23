package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Subsystems.Hooks;

public class VerticalHooksMove extends CommandBase{
    Hooks hooks;
    Joystick upStick;
    public VerticalHooksMove(Hooks hooks, Joystick rightJoystick){
        this.hooks = hooks;
        rightJoystick = upStick;
        addRequirements(hooks);
    }
    @Override
    public void initialize() {
        hooks.verticalHookResetPositon();
    }
    @Override
    public void execute() {
        hooks.angledHooksMove(upStick.getRawAxis(0));
        hooks.verticalHookLimit(upStick.getRawAxis(0), upStick);
    }
    
}
