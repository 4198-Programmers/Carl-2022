package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

public class SetInternalMoveSpeedIn extends CommandBase {
    private Tunnel tunnel;
    boolean done;

    public SetInternalMoveSpeedIn(Tunnel tunnelSub) {
        tunnel = tunnelSub;
        addRequirements(tunnel);
    }

    @Override
    public void initialize() {
        done = false;
    }

    @Override
    public void execute() {
        tunnel.setMoverSpeed(Constants.INTERNAL_FEEDER_SPEED);
        done = true;
    }

    @Override
    public boolean isFinished() {
        return done;
    }

}
