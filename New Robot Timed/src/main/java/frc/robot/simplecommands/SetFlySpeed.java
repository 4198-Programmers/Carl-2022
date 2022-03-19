package frc.robot.simplecommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Limelight;

public class SetFlySpeed extends CommandBase {
    private FlyAndSensors flyAndSensors;
    private Joystick throttle;
    Limelight vision;
    double speed;
    boolean auto;
    double spinUpTime;
    boolean autoFinished;
    double autoTime;

    public SetFlySpeed(FlyAndSensors flyAndSensorsArg, Joystick joystickArg, Limelight visionArg, boolean autoStatus,
            double waitTime) {
        flyAndSensors = flyAndSensorsArg;
        throttle = joystickArg;
        vision = visionArg;
        auto = autoStatus;
        spinUpTime = waitTime;
        addRequirements(flyAndSensors);
    }

    protected double catchWantedFlySpeed() {
        // return -((throttle.getRawAxis(3) + 1) / 2);
        return Maths.flyWheelSpeedByDistance(vision.distanceToTarget());
    }

    @Override
    public void initialize() {
        autoTime = System.currentTimeMillis();
        autoFinished = false;
    }

    @Override
    public void execute() {
        if (auto) {
            if ((System.currentTimeMillis() - autoTime) <= spinUpTime) {
                flyAndSensors.setFlySpeed(catchWantedFlySpeed());
                autoFinished = false;
                System.out.println("auto running");
            } else {
                autoFinished = true;
                System.out.println("auto finished");
            }
        } else {
            flyAndSensors.setFlySpeed(catchWantedFlySpeed());
            autoFinished = true;
            System.out.println("no auto");
        }
        SmartDashboard.putNumber("Fly Speed", -flyAndSensors.getFlySpeed());
        speed = flyAndSensors.getFlySpeed();
    }

    @Override
    public boolean isFinished() {
        final double tolerance = 0.01;
        double expectedFlywheelSpeed = catchWantedFlySpeed();
        return (speed > expectedFlywheelSpeed - tolerance && speed < expectedFlywheelSpeed + tolerance && autoFinished);

    }
}
