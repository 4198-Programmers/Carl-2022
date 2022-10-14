package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
//import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.VertHooks;

public class VertHookJoystick extends CommandBase{
    private VertHooks vertHooks;
    private Joystick hookAxisStick;
    boolean done;
    double axis;

    /**
     * Allows driver to manually controll specifics
     * (angled hooks angle)
     */
    public VertHookJoystick(VertHooks angleHooksSub, Joystick controllingJoystick) {
        vertHooks = angleHooksSub;
        hookAxisStick = controllingJoystick;
        addRequirements(vertHooks);
    }

    @Override
    public void execute() {
        axis = hookAxisStick.getRawAxis(1);
        System.out.println(vertHooks.vertHooksPos());

        if (vertHooks.vertHooksPos() >= -187 && (axis < 0)) { // makes sure you do not over run
            vertHooks.moveVertHooks(axis);
        } else if (vertHooks.vertHooksPos() < 0 && axis >= 0) {
            vertHooks.moveVertHooks(axis);
        } else {
            vertHooks.moveVertHooks(Constants.FREEZE);
        }
        done = true;
        System.out.println("angle position " + vertHooks.vertHooksPos());
    }

    
}
