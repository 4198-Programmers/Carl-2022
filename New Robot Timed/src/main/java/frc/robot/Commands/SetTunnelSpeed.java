package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.TunnelSub;

public class SetTunnelSpeed extends CommandBase {
    TunnelSub tunnelSub;
    double speed;
    public SetTunnelSpeed(TunnelSub tunnelSub, double speed) {
        this.tunnelSub = tunnelSub;
        this.speed = speed;
        addRequirements(tunnelSub);
    }

    @Override
    public void execute() {
        tunnelSub.setSpeed(speed);
    }
}