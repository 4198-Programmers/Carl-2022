package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShooterSystem;

public class WaitForFlyWheel extends CommandBase{
    ShooterSystem shooterSystem;
    Limelight limelight;
    public WaitForFlyWheel(ShooterSystem shooterSystem, Limelight limelight){
        this.shooterSystem = shooterSystem;
        this.limelight = limelight;
    }
    @Override
    public boolean isFinished() {
        double speed = shooterSystem.getSpeed();
        double wantedSpeed = Maths.flyWheelSpeedByDistance(limelight.distancefromTarget());
        return(speed == wantedSpeed);
    }
}