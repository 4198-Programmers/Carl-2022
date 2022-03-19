package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Tunnel;

public class TimedInternalMoveOut extends CommandBase {
    private Tunnel tunnel;
    boolean done;
    double autoTime;
    double timeToRun;

    /** Enter time in milliseconds */
    public TimedInternalMoveOut(Tunnel tunnelSub, double timeWant) {
        tunnel = tunnelSub;
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
            tunnel.setMoverSpeed(Constants.INTERNAL_FEEDER_REVERSE_SPEED);
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
