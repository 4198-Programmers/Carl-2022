package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.ShooterSystem;

public class SetFlySpeed extends CommandBase{
    ShooterSystem shooterSystem;
    Limelight limelight;
    public SetFlySpeed(ShooterSystem shooterSystem) {
        this.shooterSystem = shooterSystem;
        addRequirements(shooterSystem);
    }
    @Override
    public void execute() {
        shooterSystem.setFlyWheelSpeed(Maths.flyWheelSpeedByDistance((limelight.distancefromTarget())));
}

}

