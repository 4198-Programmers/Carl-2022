package frc.robot.simplecommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Maths;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Limelight;

/**
 * {@link SetFlySpeed} Sets FlyWheel speed, taking into consideration whether or
 * not it is being used for auto (time is in Milliseconds)
 */
public class SetFlySpeed extends CommandBase {
    FlyAndSensors flyAndSensors;
    Limelight limelight;
    double speed;
    boolean auto;
    double spinUpTime;
    boolean autoFinished;
    double autoTime;
    Joystick joystick;

    /**
     * {@link SetFlySpeed} Sets FlyWheel speed, taking into consideration whether or
     * not it is being used for auto (time is in Milliseconds)
     */
    public SetFlySpeed(FlyAndSensors flyAndSensorsArg, Limelight limelightArg, boolean autoStatus, double waitTime,
            Joystick joystickArg) {
        flyAndSensors = flyAndSensorsArg;
        limelight = limelightArg;
        auto = autoStatus;
        spinUpTime = waitTime;
        joystick = joystickArg;
        addRequirements(flyAndSensors, limelight);
    }

    protected double catchWantedFlySpeed() {
        return (-(joystick.getRawAxis(3)+1)/2); //Joystick set for testing
        // return -0.62; // Basic set for auto
        // return Maths.dakotaVelocity(limelight.distanceToTarget()); //Math by Dakota
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
                speed = flyAndSensors.getFlySpeed();
                System.out.println("auto running");
            } else {
                autoFinished = true;
                System.out.println("auto finished");
            }
            // } else if (!limelight.hasTarget()) {
            // flyAndSensors.setFlySpeed(-0.36);
            // } else {
            // if (joystick.getRawButton(10)) {
            // flyAndSensors.setFlySpeed(-1 * catchWantedFlySpeed());
        } else {
            flyAndSensors.setFlySpeed(catchWantedFlySpeed());
            autoFinished = true;
            System.out.println("no auto");
            SmartDashboard.putNumber("Fly Speed", -flyAndSensors.getFlySpeed());
            speed = flyAndSensors.getFlySpeed();
        }
    }

    @Override
    public boolean isFinished() {
        final double tolerance = 0.01;
        double expectedFlywheelSpeed = catchWantedFlySpeed();
        return (speed > expectedFlywheelSpeed - tolerance && speed < expectedFlywheelSpeed + tolerance && autoFinished);

    }
}
