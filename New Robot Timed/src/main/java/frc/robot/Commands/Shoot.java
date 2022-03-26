package frc.robot.Commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Sensors;
import frc.robot.Subsystems.ShooterSystem;

public class Shoot extends CommandBase{
    ShooterSystem shooterSystem;
    Sensors sensors;
    Limelight limelight;
    public Shoot(ShooterSystem shooterSystem, Sensors sensors) {
        this.shooterSystem = shooterSystem;
        this.sensors = sensors;
        addRequirements(shooterSystem, sensors);
    }
    @Override
    public void execute() {
        if(sensors.getBallOut() == false){
        shooterSystem.setFlyWheelSpeed(Maths.flyWheelSpeedByDistance((limelight.distancefromTarget()), limelight.hasTarget() == true));
        }
        else if(sensors.getBallOut() == true){
            shooterSystem.setFlyWheelSpeed(0);
        }
}

}