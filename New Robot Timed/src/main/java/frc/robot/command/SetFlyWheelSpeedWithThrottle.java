package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class SetFlyWheelSpeedWithThrottle extends CommandBase{
    public interface FlyWheelSpeedRetriever{
        double getFlyWheelSpeed();
    }
    ShooterSystem shooterSystem;
    FlyWheelSpeedRetriever speed;
    public SetFlyWheelSpeedWithThrottle(ShooterSystem shooterSystem, FlyWheelSpeedRetriever speed){
        this.shooterSystem = shooterSystem;
        this.speed = speed;
    }
    @Override
    public void execute() {
        shooterSystem.setFlyWheelSpeed(speed.getFlyWheelSpeed());
    }
}
