package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.ShooterSystem;

public class MoveBallFromIntake extends CommandBase{
    ShooterSystem shooterSystem;
    Sensors sensors;
    double speed;
    public MoveBallFromIntake(ShooterSystem shooterSystem, Sensors sensors, double speed){
        this.shooterSystem = shooterSystem;
        this.sensors = sensors;
        this.speed = speed;
    }
    @Override
    public void execute() {
        if(sensors.isBallInFeed()){
            shooterSystem.setTunnelMotorSpeed(speed);
        }
        else{
            shooterSystem.setTunnelMotorSpeed(0);
        }
    }
    @Override
    public boolean isFinished() {
        return(!sensors.isBallInFeed());
    }
}
