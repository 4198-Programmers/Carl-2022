package frc.robot.Commands.Tunnel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ShootingThing;


public class TunnelOut extends CommandBase {

    ShootingThing shootingthing;
    double speed;

    public TunnelOut(double speed, ShootingThing shootingthing){

        this.shootingthing = shootingthing;
        this.speed = speed;

    }
    
    
}
