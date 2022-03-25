package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

public class TunnelStop extends CommandBase {
    boolean done;
    private Tunnel tunnel;

    public TunnelStop(Tunnel tunnelSub) {
        tunnel = tunnelSub;
        addRequirements(tunnel);
    }

    @Override
    public void initialize() {
        done = false;
    }

    @Override
    public void execute() {
        tunnel.setMoverSpeed(Constants.FREEZE);
        done = true;
    }

    @Override
    public boolean isFinished() {
        return done;
    }

}
