package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.ShooterSystem;

public class WaitForFlyWheelSpeed extends CommandBase {
    ShooterSystem shooterSystem;
    Limelight limelight;
    Maths maths;

    public WaitForFlyWheelSpeed(ShooterSystem shooterSystem, Limelight limelight) {
        this.shooterSystem = shooterSystem;
        this.limelight = limelight;
    }

    @Override
    public boolean isFinished() {
        double speed = shooterSystem.getSpeed();
        double distance = limelight.distancefromTarget();
        return (speed == Maths.flyWheelSpeedByDistance(distance));
    }
}
