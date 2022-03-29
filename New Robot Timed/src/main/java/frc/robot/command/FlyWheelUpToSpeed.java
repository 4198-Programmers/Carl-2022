package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShooterSystem;

public class FlyWheelUpToSpeed extends CommandBase{
    ShooterSystem shooterSystem;
    Limelight limelight;
    public FlyWheelUpToSpeed(ShooterSystem shooterSystem, Limelight limelight){
        this.shooterSystem = shooterSystem;
        this.limelight = limelight;
    }
    @Override
    public boolean isFinished() {
        return(shooterSystem.setFlyWheelSpeed(Maths.flyWheelSpeedByDistance(limelight.distancefromTarget())) == Maths.flyWheelSpeedByDistance(limelight.distancefromTarget()));
    }
}
