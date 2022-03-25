package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.TunnelSub;

public class TunnelIn extends CommandBase{
    TunnelSub tunnelSub;
    public TunnelIn(TunnelSub tunnelSub){
        this.tunnelSub = tunnelSub;
        addRequirements(tunnelSub);
    }
    @Override
    public void execute() {
        tunnelSub.setSpeed(Constants.TUNNEL_SPEED);
    }
}
