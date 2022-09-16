package frc.robot.simpleCommands.ShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

public class ReverseTunnelSpeed extends CommandBase{
    Tunnel tunnel;
    public ReverseTunnelSpeed(Tunnel tunnel){
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
