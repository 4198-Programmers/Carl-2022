package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ShooterSystem;

public class ShootStop extends CommandBase{
    ShooterSystem shooterSystem;
    public ShootStop(ShooterSystem shooterSystem){
        this.shooterSystem = shooterSystem;
        addRequirements(shooterSystem);
    }
    @Override
    public void execute() {
        shooterSystem.stop();
        }
    }
