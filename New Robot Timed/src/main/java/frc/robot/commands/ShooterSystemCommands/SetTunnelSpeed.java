package frc.robot.commands.ShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem.Tunnel;

public class SetTunnelSpeed extends CommandBase {
    Tunnel tunnel;
    double speed;

    public SetTunnelSpeed(Tunnel tunnel, double speed) {
        this.tunnel = tunnel;
        this.speed = speed;
        addRequirements(tunnel);
    }

    @Override
    public void execute() {
        tunnel.setSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        tunnel.setSpeed(0);
    }
}
