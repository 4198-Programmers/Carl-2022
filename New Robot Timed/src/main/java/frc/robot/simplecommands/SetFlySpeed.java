package frc.robot.simplecommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyAndSensors;

public class SetFlySpeed extends CommandBase {
    private FlyAndSensors pewPew;
    private Joystick throttle;

    public SetFlySpeed(FlyAndSensors pewPewArg, Joystick joystickArg) {
        pewPew = pewPewArg;
        throttle = joystickArg;
        addRequirements(pewPew);
    }

    protected double catchWantedFlySpeed() {
        return -((throttle.getRawAxis(3)+1)/2);
    }

    @Override
    public void execute() {
        pewPew.setFlySpeed(catchWantedFlySpeed());
    }



    @Override
    public boolean isFinished() {
        double speed = pewPew.getFlySpeed();
        final double tolerance = 0.01;
        double expectedFlywheelSpeed = catchWantedFlySpeed();
        System.out.println(pewPew.getFlySpeed());
        return (speed > expectedFlywheelSpeed - tolerance && speed < expectedFlywheelSpeed + tolerance);

    }
}
