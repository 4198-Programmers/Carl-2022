package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShooterSystem;

public class SetFlyWheelSpeed extends CommandBase{
    ShooterSystem shooterSystem;
    Limelight limelight;
    public SetFlyWheelSpeed(ShooterSystem shooterSystem, Limelight limelight){
        this.shooterSystem = shooterSystem;
        this.limelight = limelight;
    }
    @Override
    public void execute() {
        shooterSystem.setFlyWheelSpeed(Maths.flyWheelSpeedByDistance(limelight.distancefromTarget()));
    }
}
