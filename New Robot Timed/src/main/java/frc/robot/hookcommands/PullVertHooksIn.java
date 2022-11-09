package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.VertHooks;

public class PullVertHooksIn extends CommandBase {
    VertHooks vertHooks;
    Joystick throttle;
    // private double distanceDown;

    public PullVertHooksIn(VertHooks vertHooksSub, Joystick joystickArg) {
        vertHooks = vertHooksSub;
        throttle = joystickArg;
        addRequirements(vertHooks);

    }

    @Override
    public void execute() {
        vertHooks.moveVertHooks((1 - ((throttle.getRawAxis(3) + 1) / 2)));
        System.out.println("vert hooks " + vertHooks.vertHooksPosition());
    }

    // @Override
    // public boolean isFinished() {
    // double height = vertHooks.getVerticalHookHeight();
    // return height >= distanceDown;
    // }
}
