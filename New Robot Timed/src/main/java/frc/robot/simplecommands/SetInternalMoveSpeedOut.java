package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

public class SetInternalMoveSpeedOut extends CommandBase {
    private Tunnel tunnel;

    public SetInternalMoveSpeedOut(Tunnel tunnelSub) {
        tunnel = tunnelSub;
        addRequirements(tunnel);
    }

    @Override
    public void execute() {
        tunnel.setMoverSpeed(-Constants.INTERNAL_FEEDER_SPEED);
    }

}
