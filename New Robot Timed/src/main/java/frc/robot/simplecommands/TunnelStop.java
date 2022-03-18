package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

public class TunnelStop extends CommandBase{

    private Tunnel tunnel;

    public TunnelStop(Tunnel shooterPathMovementArg) {
        tunnel = shooterPathMovementArg;
        addRequirements(tunnel);
    }

    @Override
    public void execute() {
        tunnel.setMoverSpeed(Constants.FREEZE);
    }
    
}
