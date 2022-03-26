package frc.robot.Commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Sensors;
import frc.robot.Subsystems.ShooterSystem;

public class AutoShoot extends CommandBase{
    ShooterSystem shooterSystem;
    Sensors sensors;
    Limelight limelight;
    public AutoShoot(ShooterSystem shooterSystem, Sensors sensors) {
        this.shooterSystem = shooterSystem;
        this.sensors = sensors;
        addRequirements(shooterSystem, sensors);
    }
    @Override
    public void execute() {
        if (sensors.isBallAtFlyWheel()){
        shooterSystem.setFlyWheelSpeed(Maths.flyWheelSpeedByDistance((limelight.distancefromTarget()), limelight.hasTarget() == true));
        }
        else {
            shooterSystem.setFlyWheelSpeed(0);
        }
    }
    @Override
    public boolean isFinished() {
        return !sensors.isBallAtFlyWheel();
    }
}