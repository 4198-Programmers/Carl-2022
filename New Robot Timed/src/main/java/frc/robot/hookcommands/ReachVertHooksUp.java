package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VertHooks;

public class ReachVertHooksUp extends CommandBase {
    private VertHooks grabbers;
    Joystick throttle;
    double distanceUp;

    public ReachVertHooksUp(VertHooks vertHooksSub, Joystick joystickArg) {
        grabbers = vertHooksSub;
        throttle = joystickArg;
        addRequirements(grabbers);
    }

    @Override
    public void execute() {
        if (grabbers.vertHooksPosition() >= -187) {
            grabbers.moveVertHooks(-(1 - ((throttle.getRawAxis(3) + 1) / 2)));
        } else {
            grabbers.moveVertHooks(Constants.FREEZE);
        }
        System.out.println("hooks vert " + grabbers.vertHooksPosition());
    }

    // @Override
    // public boolean isFinished() {
    // double height = grabbers.getVerticalHookHeight();
    // return height >= distanceUp;
    // }

}