package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

/**
 * {@link TimedInternalMoveOut} Pushes balls towards the intake for a set amount
 * of
 * MILLIseconds
 */
public class TimedInternalMoveOut extends CommandBase {
    Tunnel tunnel;
    boolean youDone;
    double autoTime;
    double timeToRun;

    /**
     * {@link TimedInternalMoveOut} Pushes balls towards the intake for a set amount
     * of
     * MILLIseconds
     */
    public TimedInternalMoveOut(Tunnel tunnelArg, double timeWant) {
        tunnel = tunnelArg;
        timeToRun = timeWant;
        addRequirements(tunnel);
    }

    @Override
    public void initialize() {
        autoTime = System.currentTimeMillis();
        youDone = false;
    }

    @Override
    public void execute() {
        if ((System.currentTimeMillis() - autoTime) <= timeToRun) {
            tunnel.setMoverSpeed(Constants.INTERNAL_FEEDER_REVERSE_SPEED);
        } else {
            tunnel.setMoverSpeed(Constants.FREEZE);
            youDone = true;
        }
    }

    @Override
    public boolean isFinished() {
        return youDone;
    }
}
