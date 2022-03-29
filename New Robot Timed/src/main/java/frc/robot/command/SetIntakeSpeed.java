package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class SetIntakeSpeed extends CommandBase{
    ShooterSystem shooterSystem;
    double speed;
    public SetIntakeSpeed(ShooterSystem shooterSystem, double speed){
        this.shooterSystem = shooterSystem;
        this.speed = speed;
    }
    @Override
    public void execute() {
        shooterSystem.setIntakeMotorSpeed(speed);
    }
}
