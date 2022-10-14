package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;

/**
 * {@link SensorStopInternals} Uses sensors to determine when there are no balls
 * in the robot and them stops the FlyWheel, Tunnel, and Intake.
 */
public class SensorStopInternals extends CommandBase {
    FlyAndSensors flyAndSensors;
    Tunnel tunnel;
    Intake intake;
    boolean finished;

    /**
     * {@link SensorStopInternals} Uses sensors to determine when there are no balls
     * in the robot and them stops the FlyWheel, Tunnel, and Intake.
     */
    public SensorStopInternals(FlyAndSensors flyAndSensorsArg, Tunnel tunnelArg, Intake intakeArg) {
        flyAndSensors = flyAndSensorsArg;
        tunnel = tunnelArg;
        intake = intakeArg;
        addRequirements(flyAndSensors, tunnel, intake);
    }

    @Override
    public void initialize() {
        finished = false;
    }

    @Override
    public void execute() {
        if (!flyAndSensors.ballIn() && !flyAndSensors.ballOut()) {
            tunnel.setMoverSpeed(Constants.FREEZE);
            intake.setIntakeSpeed(Constants.FREEZE);
            flyAndSensors.setFlySpeed(Constants.FREEZE);
            finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}