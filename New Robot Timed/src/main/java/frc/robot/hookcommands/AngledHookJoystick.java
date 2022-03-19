package frc.robot.hookcommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleHooks;

public class AngledHookJoystick extends CommandBase {
    private AngleHooks climberHC;
    private Joystick hookAxisStick;
    boolean done;
    double axis;

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
    public void initialize() {
        done = false;
    }

    @Override
    public void execute() {
        axis = hookAxisStick.getRawAxis(0);
        if(climberHC.anglePosition() >= -202 && (axis < 0)){
        climberHC.moveAngledHooks(axis);
    }
        else if(axis > 0){
            climberHC.moveAngledHooks(axis);
        }
        done = true;
        System.out.println("Position " + climberHC.anglePosition());
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}
