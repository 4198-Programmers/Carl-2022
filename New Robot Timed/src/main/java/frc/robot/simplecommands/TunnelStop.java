package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

/** {@link TunnelStop} Specifically sets Tunnel to 0 */
public class TunnelStop extends CommandBase {
    boolean youDone;
    Tunnel tunnel;

    /** {@link TunnelStop} Specifically sets Tunnel to 0 */
    public TunnelStop(Tunnel tunnelArg) {
        tunnel = tunnelArg;
        addRequirements(tunnel);
    }

    @Override
    public void initialize() {
        youDone = false;
    }

    @Override
    public void execute() {
        tunnel.setMoverSpeed(Constants.FREEZE);
        youDone = true;
    }

    @Override
    public boolean isFinished() {
        return youDone;
    }
}
