package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.VerticalHooks;

public class VerticalHooksMove extends CommandBase{
    VerticalHooks verticalHooks;
    Joystick upStick;
    public VerticalHooksMove(VerticalHooks verticalHooks, Joystick rightJoystick){
        this.verticalHooks = verticalHooks;
        rightJoystick = upStick;
        addRequirements(verticalHooks);
    }
    @Override
    public void initialize() {
        verticalHooks.resetPosition();
    }
    @Override
    public void execute() {
        verticalHooks.heightLimit(upStick.getRawAxis(0), upStick);
    }
    
}
