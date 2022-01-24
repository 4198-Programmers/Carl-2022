package frc.robot.command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Hooks;

public class HumanControl extends CommandBase{
    private Hooks climberHC;
    private Joystick hookAxisStick;

    /**Allows driver to manually controll specifics 
     * (angled hooks angle)
    */
    public HumanControl(Hooks hooksArg, Joystick controllingJoystick)
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
