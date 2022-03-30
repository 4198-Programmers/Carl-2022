package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;
import frc.robot.subsystems.DriveTrain;

public class AngledHookJoystick extends CommandBase {
    private AngleHooks climberHC;
    private Joystick hookAxisStick;
    DriveTrain vroomVroom;
    boolean done;
    double axis;

    /**
     * Allows driver to manually controll specifics
     * (angled hooks angle)
     */
    public AngledHookJoystick(AngleHooks angleHooksSub, Joystick controllingJoystick, DriveTrain vroomVroomSub) {
        climberHC = angleHooksSub;
        hookAxisStick = controllingJoystick;
        vroomVroom = vroomVroomSub;
        addRequirements(climberHC);
    }

    @Override
    public void execute() {
        axis = -hookAxisStick.getRawAxis(0);
        vroomVroom.greenLight(0, 0);

        if (climberHC.anglePosition() >= -97 && (axis < 0)) { // makes sure you do not over run
            climberHC.moveAngledHooks(axis);
        } else if (axis >= 0) {
            climberHC.moveAngledHooks(axis);
        } else {
            climberHC.moveAngledHooks(Constants.FREEZE);
        }
        done = true;
        System.out.println("angle position " + climberHC.anglePosition());
    }

}
