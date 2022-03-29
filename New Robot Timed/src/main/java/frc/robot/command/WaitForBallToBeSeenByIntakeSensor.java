package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.ShooterSystem;

public class WaitForBallToBeSeenByIntakeSensor extends CommandBase{
    Sensors sensors;
    ShooterSystem shooterSystem;
    public WaitForBallToBeSeenByIntakeSensor(ShooterSystem shooterSystem, Sensors sensors){
        this.sensors = sensors;
        this.shooterSystem = shooterSystem;
    }
    @Override
    public boolean isFinished() {
        return(sensors.isBallInFeed());
    }
    @Override
    public void end(boolean interrupted) {
        shooterSystem.setIntakeMotorSpeed(0);
    }
}
