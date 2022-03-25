package frc.robot.simplecommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Limelight;

public class SetFlySpeed extends CommandBase {
    private FlyAndSensors flyAndSensors;
    Limelight vision;
    double speed;
    boolean auto;
    double spinUpTime;
    boolean autoFinished;
    double autoTime;
    Joystick joystick;

    public SetFlySpeed(FlyAndSensors flyAndSensorsArg, Limelight visionArg, boolean autoStatus, double waitTime,
            Joystick joystickArg) {
        flyAndSensors = flyAndSensorsArg;
        vision = visionArg;
        auto = autoStatus;
        spinUpTime = waitTime;
        joystick = joystickArg;
        addRequirements(flyAndSensors, vision);
    }

    protected double catchWantedFlySpeed() {
        // return joystick.getRawAxis(3);
        return Maths.flyWheelSpeedByDistance(vision.distanceToTarget(), vision.hasTarget());
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
        } else if (!vision.hasTarget()) {
            flyAndSensors.setFlySpeed(-0.36);
        } else {
            // if (joystick.getRawButton(10)) {
            // flyAndSensors.setFlySpeed(-1 * catchWantedFlySpeed());
            // } else {
            flyAndSensors.setFlySpeed(catchWantedFlySpeed());
            // }
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
