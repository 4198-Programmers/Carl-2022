package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.TunnelSub;

public class MoveBalltoShooter extends CommandBase {
    TunnelSub tunnelSub;

    public MoveBalltoShooter(TunnelSub tunnelSub) {
        this.tunnelSub = tunnelSub;
        addRequirements(tunnelSub);
    }

    @Override
    public void execute() {
        tunnelSub.setSpeed(Constants.TUNNEL_SPEED);
    }
    @Override
    public void end(boolean interrupted) {
        tunnelSub.setSpeed(0);
    }
}
