package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VertHooks;

public class ReachVertHooksUp extends CommandBase {
    private VertHooks vertHooks;
    Joystick throttle;
    double distanceUp;

    public ReachVertHooksUp(VertHooks vertHooksSub, Joystick joystickArg) {
        vertHooks = vertHooksSub;
        throttle = joystickArg;
        addRequirements(vertHooks);
    }

    @Override
    public void execute() {
        if (vertHooks.vertHooksPos() >= -187) {
            vertHooks.moveVertHooks(-(1 - ((throttle.getRawAxis(3) + 1) / 2)));
        } else {
            vertHooks.moveVertHooks(Constants.FREEZE);
        }
        System.out.println("hooks vert " + vertHooks.vertHooksPos());
    }

    // @Override
    // public boolean isFinished() {
    // double height = vertHooks.getVerticalHookHeight();
    // return height >= distanceUp;
    // }

}
