package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

/**
 * {@link TimedInternalMoveIn} Pushes balls towards the flywheel for a set
 * amount of MILLIseconds
 */
public class TimedInternalMoveIn extends CommandBase {
    Tunnel tunnel;
    boolean done;
    double autoTime;
    double timeToRun;

    /**
     * {@link TimedInternalMoveIn} Pushes balls towards the flywheel for a set
     * amount of MILLIseconds
     */
    public TimedInternalMoveIn(Tunnel tunnelArg, double timeWant) {
        tunnel = tunnelArg;
        timeToRun = timeWant;
        addRequirements(tunnel);
    }

    @Override
    public void initialize() {
        autoTime = System.currentTimeMillis();
        done = false;
    }

    @Override
    public void execute() {
        if ((System.currentTimeMillis() - autoTime) <= timeToRun) {
            tunnel.setMoverSpeed(Constants.INTERNAL_FEEDER_SPEED);
        } else {
            tunnel.setMoverSpeed(Constants.FREEZE);
            done = true;
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}
