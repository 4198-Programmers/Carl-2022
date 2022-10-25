package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.VertHooks;

public class PullVertHooksIn extends CommandBase {
    VertHooks grab;
    Joystick throttle;
    // private double distanceDown;

    public PullVertHooksIn(VertHooks vertHooksSub, Joystick joystickArg) {
        grab = vertHooksSub;
        throttle = joystickArg;
        addRequirements(grab);

    }

    @Override
    public void execute() {
        grab.moveVertHooks((1 - ((throttle.getRawAxis(3) + 1) / 2)));
        System.out.println("vert hooks " + grab.vertHooksPosition());
    }

    // @Override
    // public boolean isFinished() {
    // double height = grab.getVerticalHookHeight();
    // return height >= distanceDown;
    // }
}
