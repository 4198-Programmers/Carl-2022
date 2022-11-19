package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.TunnelThing;

public class TunnelSpeed extends CommandBase {

    TunnelThing tunnelthing;
    double speed;
    double multiplier;

    public TunnelSpeed(double speed, double multiplier, TunnelThing tunnelthing){

        this.speed = speed;
        this.multiplier = multiplier;
        this.tunnelthing = tunnelthing;

        addRequirements(tunnelthing);

    }

    @Override
    public void execute() {
        tunnelthing.tunnelSpeed(multiplier * speed);
    }
    
}
