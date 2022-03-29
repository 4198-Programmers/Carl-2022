package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class SetFlyWheelSpeedWithThrottle extends CommandBase{
    ShooterSystem shooterSystem;
    public SetFlyWheelSpeedWithThrottle(ShooterSystem shooterSystem){
        this.shooterSystem = shooterSystem;
    }
    @Override
    public void execute() {
    }
}
