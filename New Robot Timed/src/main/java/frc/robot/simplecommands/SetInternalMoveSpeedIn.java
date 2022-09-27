package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

/**
 * {@link SetInternalMoveSpeedIn} Sets tunnel speed to move balls towards the
 * FlyWheel
 */
public class SetInternalMoveSpeedIn extends CommandBase {
    Tunnel tunnel;
    boolean youDone;

    /**
     * {@link SetInternalMoveSpeedIn} Sets tunnel speed to move balls towards the
     * FlyWheel
     */
    public SetInternalMoveSpeedIn(Tunnel tunnelArg) {
        tunnel = tunnelArg;
        addRequirements(tunnel);
    }

    @Override
    public void initialize() {
        youDone = false;
    }

    @Override
    public void execute() {
        tunnel.setMoverSpeed(Constants.INTERNAL_FEEDER_SPEED);
        youDone = true;
    }

    @Override
    public boolean isFinished() {
        return youDone;
    }
}
