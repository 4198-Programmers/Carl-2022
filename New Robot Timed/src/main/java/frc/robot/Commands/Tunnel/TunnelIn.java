package frc.robot.Commands.Tunnel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ShootingThing;

public class TunnelIn extends CommandBase {

    ShootingThing shootingthing;
    double speed;

    public TunnelIn(double speed, ShootingThing shootingthing){

        this.speed = speed;
        this.shootingthing = shootingthing;

    }
    
    @Override
    public void execute() {
        
        shootingthing.tunnelSpeed(speed);

    }
}
