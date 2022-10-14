package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;
import frc.robot.subsystems.DriveTrain;

public class AngledHookJoystick extends CommandBase {
    private AngleHooks angleHooks;
    private Joystick hookAxisStick;
    DriveTrain driveTrain;
    boolean done;
    double axis;

    /**
     * Allows driver to manually controll specifics
     * (angled hooks angle)
     */
    public AngledHookJoystick(AngleHooks angleHooksSub, Joystick controllingJoystick, DriveTrain driveTrainSub) {
        angleHooks = angleHooksSub;
        hookAxisStick = controllingJoystick;
        driveTrain = driveTrainSub;
        addRequirements(angleHooks);
    }

    @Override
    public void execute() {
        axis = -hookAxisStick.getRawAxis(0);
        driveTrain.greenLight(0, 0);

        if (angleHooks.anglePosition() >= -97 && (axis < 0)) { // makes sure you do not over run
            angleHooks.moveAngledHooks(axis);
        } else if (axis >= 0) {
            angleHooks.moveAngledHooks(axis);
        } else {
            angleHooks.moveAngledHooks(Constants.FREEZE);
        }
        done = true;
        System.out.println("angle position " + angleHooks.anglePosition());
    }

}
