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

    public SetFlySpeed(FlyAndSensors flyAndSensorsArg, Joystick joystickArg, Limelight visionArg) {
        flyAndSensors = flyAndSensorsArg;
        throttle = joystickArg;
        vision = visionArg;
        addRequirements(flyAndSensors);
    }

    protected double catchWantedFlySpeed() {
        //return -((throttle.getRawAxis(3) + 1) / 2);
        return Maths.flyWheelSpeedByDistance(vision.distanceToTarget());
    }

    @Override
    public void execute() {
        flyAndSensors.setFlySpeed(catchWantedFlySpeed());
        SmartDashboard.putNumber("Fly Speed", flyAndSensors.getFlySpeed());
    }

    @Override
    public boolean isFinished() {
        double speed = flyAndSensors.getFlySpeed();
        final double tolerance = 0.01;
        double expectedFlywheelSpeed = catchWantedFlySpeed();
        System.out.println(flyAndSensors.getFlySpeed());
        return (speed > expectedFlywheelSpeed - tolerance && speed < expectedFlywheelSpeed + tolerance);

    }
}
