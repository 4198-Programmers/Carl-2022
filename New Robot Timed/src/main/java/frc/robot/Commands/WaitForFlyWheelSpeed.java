package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.Subsystems.ShooterSystem;

public class WaitForFlyWheelSpeed extends CommandBase {
    ShooterSystem shooterSystem;
    double speed;
    Maths maths;

    public WaitForFlyWheelSpeed(ShooterSystem shooterSystem, double speed) {
        this.shooterSystem = shooterSystem;
        this.speed = speed;
    }

    @Override
    public boolean isFinished() {
        return( speed == shooterSystem.getSpeed());
    }
}
