package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ShooterSystem;

public class AutoFlyWheelSpeed extends CommandBase{
    ShooterSystem shooterSystem;
    double speed;
    public AutoFlyWheelSpeed(ShooterSystem shooterSystem, double speed){
        this.shooterSystem = shooterSystem;
        this.speed = speed;
        addRequirements(shooterSystem);
    }
    @Override
    public void execute() {
        shooterSystem.setFlyWheelSpeed(speed);
    }

}