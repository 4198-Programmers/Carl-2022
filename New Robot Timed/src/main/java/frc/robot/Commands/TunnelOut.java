package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.TunnelSub;

public class TunnelOut extends CommandBase{
    TunnelSub tunnelSub;
    public TunnelOut(TunnelSub tunnelSub){
        this.tunnelSub = tunnelSub;
        addRequirements(tunnelSub);
    }
    @Override
    public void execute() {
        tunnelSub.tunnelSpeed(-(Constants.TUNNEL_SPEED));
    }
}