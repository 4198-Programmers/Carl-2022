package frc.robot.simpleCommands.ShooterSystem;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

public class ReverseTunnel extends CommandBase{
    Tunnel tunnel;
    public ReverseTunnel(Tunnel tunnel){
        this.tunnel = tunnel;
        addRequirements(tunnel);
    }
    @Override
    public void execute() {
        tunnel.setTunnelSpeed(Constants.INTERNAL_FEEDER_REVERSE_SPEED);
    }
    @Override
    public void end(boolean interrupted) {
        tunnel.setTunnelSpeed(Constants.FREEZE);
    }
}