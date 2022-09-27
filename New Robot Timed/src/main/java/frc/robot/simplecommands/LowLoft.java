package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyAndSensors;

/** {@link LowLoft} Sets FlyWheel speed to toss balls into lower goal */
public class LowLoft extends CommandBase {
    FlyAndSensors flyAndSensors;
    double speed;

    /** {@link LowLoft} Sets FlyWheel speed to toss balls into lower goal */
    public LowLoft(FlyAndSensors flyAndSensorsArg) {
        flyAndSensors = flyAndSensorsArg;
        addRequirements(flyAndSensors);
    }

    @Override
    public void execute() {
        flyAndSensors.setFlySpeed(-0.46);
        System.out.println("no auto");
    }

    @Override
    public boolean isFinished() {
        final double tolerance = 0.01;
        double expectedFlywheelSpeed = -0.46;
        return (speed > expectedFlywheelSpeed - tolerance && speed < expectedFlywheelSpeed + tolerance);

    }
}
