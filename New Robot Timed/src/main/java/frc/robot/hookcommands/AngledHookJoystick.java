package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleHooks;

public class AngledHookJoystick extends CommandBase {
    private AngleHooks climberHC;
    private Joystick hookAxisStick;

    /**
     * Allows driver to manually controll specifics
     * (angled hooks angle)
     */
    public AngledHookJoystick(AngleHooks hooksArg, Joystick controllingJoystick) {
        climberHC = hooksArg;
        hookAxisStick = controllingJoystick;
        addRequirements(climberHC);
    }

    @Override
    public void execute() {
        climberHC.moveAngledHooks(hookAxisStick.getRawAxis(0));
    }
}
