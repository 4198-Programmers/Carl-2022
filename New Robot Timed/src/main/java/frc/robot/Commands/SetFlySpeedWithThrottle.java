package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ShooterSystem;

public class SetFlySpeedWithThrottle extends CommandBase{
    public interface FlyWheelSpeedRetriever{
        double getFlyWheelSpeed();
    }
    ShooterSystem shooterSystem;
    FlyWheelSpeedRetriever flyWheelSpeedRetriever;
    public SetFlySpeedWithThrottle(ShooterSystem shooterSystem, FlyWheelSpeedRetriever flyWheelSpeedRetriever){
        this.shooterSystem = shooterSystem;
        this.flyWheelSpeedRetriever = flyWheelSpeedRetriever;
        addRequirements(shooterSystem);
    }

    @Override
    public void execute() {
        shooterSystem.setFlyWheelSpeed(flyWheelSpeedRetriever.getFlyWheelSpeed());
        if(flyWheelSpeedRetriever.getFlyWheelSpeed() == 0){
            shooterSystem.setFlyWheelSpeed(0.62);
        }
    }
}
