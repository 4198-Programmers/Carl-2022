package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem;

public class StopFlyWheel extends CommandBase{
    ShooterSystem shooterSystem;
    public StopFlyWheel(ShooterSystem shooterSystem){
        this.shooterSystem = shooterSystem;
    }  
    @Override
    public void execute() {
        shooterSystem.setFlyWheelSpeed(0);
    } 
}
