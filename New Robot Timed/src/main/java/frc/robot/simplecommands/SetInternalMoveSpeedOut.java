package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

/**
 * {@link SetInternalMoveSpeedOut} Sets the tunnel to move balls towards the
 * Intake
 */
public class SetInternalMoveSpeedOut extends CommandBase {
    Tunnel tunnel;

    /**
     * {@link SetInternalMoveSpeedOut} Sets the tunnel to move balls towards the
     * Intake
     */
    public SetInternalMoveSpeedOut(Tunnel tunnelArg) {
        tunnel = tunnelArg;
        addRequirements(tunnel);
    }

    @Override
    public void execute() {
        tunnel.setMoverSpeed(-Constants.INTERNAL_FEEDER_SPEED);
    }
}
