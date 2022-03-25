package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.AngledHooks;

public class AngledHookJoystick extends CommandBase{
    AngledHooks angledHooks;
    Joystick angledJoystick;
    public AngledHookJoystick(AngledHooks angledHooks, Joystick middleJoystick){
        this.angledHooks = angledHooks;
        middleJoystick = angledJoystick;
        addRequirements(angledHooks);
    }
    @Override
    public void initialize() {
        angledHooks.resetPostition();
    }
    @Override
    public void execute() {
        angledHooks.MoveHooks(angledJoystick.getRawAxis(0));

    }
}
