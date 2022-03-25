package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.AngledHooks;

public class AngledHooksMove extends CommandBase{
    AngledHooks angledHooks;
    Joystick angledJoystick;
    public AngledHooksMove(AngledHooks angledHooks, Joystick rightJoystick){
        this.angledHooks = angledHooks;
        addRequirements(angledHooks);
    }
    @Override
    public void initialize() {
        angledHooks.resetPostition();
    }
    @Override
    public void execute() {
        angledHooks.HeightLimit(angledJoystick.getRawAxis(1), angledJoystick);
    }
}
