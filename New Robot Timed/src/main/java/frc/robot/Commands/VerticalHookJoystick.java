package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.VerticalHooks;

public class VerticalHookJoystick extends CommandBase{
    VerticalHooks verticalHooks;
    Joystick verticalJoystick;
    public VerticalHookJoystick(VerticalHooks verticalHooks, Joystick rightJoystick){
        this.verticalHooks = verticalHooks;
        rightJoystick = verticalJoystick;
        addRequirements(verticalHooks);
    }
    @Override
    public void initialize() {
        verticalHooks.resetPosition();
    }
    @Override
    public void execute() {
        verticalHooks.move(verticalJoystick.getRawAxis(0));
    }
}
