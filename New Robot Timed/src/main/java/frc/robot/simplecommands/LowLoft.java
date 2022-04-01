package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyAndSensors;

public class LowLoft extends CommandBase {
    private FlyAndSensors flyAndSensors;
    double speed;

    public LowLoft(FlyAndSensors flyAndSensorsSub) {
        flyAndSensors = flyAndSensorsSub;
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
