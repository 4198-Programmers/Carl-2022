package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ShooterSystem;

public class StopFlyWheel extends CommandBase{
    ShooterSystem shooterSystem;
    boolean youdone;
    public StopFlyWheel(ShooterSystem shooterSystem){
        this.shooterSystem = shooterSystem;
        addRequirements(shooterSystem);
    }
    @Override
    public void initialize() {
        youdone = false;
    }
    @Override
    public void execute() {
        shooterSystem.setFlyWheelSpeed(0);
        youdone = true;
    }
    @Override
    public boolean isFinished( ) {
        return youdone;
        }
}
