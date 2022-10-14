package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;

/** {@link StableInternals} Sets FlyWheel, Tunnel, and Intake speeds to 0 */
public class StableInternals extends CommandBase {
    private FlyAndSensors flyAndSensors;
    private Tunnel tunnel;
    private Intake intake;

    /** {@link StableInternals} Sets FlyWheel, Tunnel, and Intake speeds to 0 */
    public StableInternals(FlyAndSensors flyAndSensorsArg, Tunnel tunnelArg, Intake intakeArg) {
        flyAndSensors = flyAndSensorsArg;
        tunnel = tunnelArg;
        intake = intakeArg;
        addRequirements(flyAndSensors, tunnel, intake);
    }

    @Override
    public void execute() {
        flyAndSensors.setFlySpeed(Constants.FREEZE);
        intake.setIntakeSpeed(Constants.FREEZE);
        tunnel.setMoverSpeed(Constants.FREEZE);
    }
}
