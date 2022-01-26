package frc.robot.command.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hooks;

public class AngledHookJoystick extends CommandBase{
    private Hooks climberHC;
    private Joystick hookAxisStick;

    /**Allows driver to manually controll specifics 
     * (angled hooks angle)
    */
    public AngledHookJoystick(Hooks hooksArg, Joystick controllingJoystick)
    {
        climberHC = hooksArg;
        hookAxisStick = controllingJoystick;
    }

    @Override
    public void execute()
    {
        climberHC.moveAngledHooks(hookAxisStick.getRawAxis(0));
    }
}
