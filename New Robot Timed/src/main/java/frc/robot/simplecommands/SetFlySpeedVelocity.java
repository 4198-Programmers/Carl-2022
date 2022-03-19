package frc.robot.simplecommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Limelight;

public class SetFlySpeedVelocity extends CommandBase {
    private FlyAndSensors flyAndSensors;
    Limelight vision;

    public SetFlySpeedVelocity(FlyAndSensors flyAndSensorsArg,Limelight visionArg) {
        flyAndSensors = flyAndSensorsArg;
        vision = visionArg;
        addRequirements(flyAndSensors);
    }

    
    protected double catchWantedFlySpeed() {
        double distanceFromTarget = vision.distanceToTarget();
        double targetVelocityForFlywheel = Maths.flyWheelVelocityByDistance(distanceFromTarget);
        double targetVelocityForFlywheelRatio = Maths.flywheelMotorVelocityConversion(targetVelocityForFlywheel);
        System.out.println(targetVelocityForFlywheel);
        System.out.println(targetVelocityForFlywheelRatio);
        return targetVelocityForFlywheelRatio;
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
