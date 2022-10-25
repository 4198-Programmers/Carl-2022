package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
//import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.VertHooks;

public class VertHookJoystick extends CommandBase{
    private VertHooks climberHC;
    private Joystick hookAxisStick;
    boolean done;
    double axis;

    /**
     * Allows driver to manually controll specifics
     * (angled hooks angle)
     */
    public VertHookJoystick(VertHooks angleHooksSub, Joystick controllingJoystick) {
        climberHC = angleHooksSub;
        hookAxisStick = controllingJoystick;
        addRequirements(climberHC);
    }

    @Override
    public void execute() {
        axis = hookAxisStick.getRawAxis(1);

        if (climberHC.vertHooksPosition() >= -187 && (axis < 0)) { // makes sure you do not over run
            climberHC.moveVertHooks(axis);
        } else if (axis >= 0) {
            climberHC.moveVertHooks(axis);
        } else {
            climberHC.moveVertHooks(Constants.FREEZE);
        }
        done = true;
        System.out.println("angle position " + climberHC.vertHooksPosition());
    }

    
}
