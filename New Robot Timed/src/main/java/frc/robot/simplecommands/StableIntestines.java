package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;

public class StableIntestines extends CommandBase {
    private FlyAndSensors flyAndSensors;
    private Tunnel tunnel;
    private Intake intake;

    public StableIntestines(FlyAndSensors flyAndSensorsArg, Tunnel tunnelArg, Intake intakeArg) {
        flyAndSensors = flyAndSensorsArg;
        tunnel = tunnelArg;
        intake = intakeArg;
        addRequirements(flyAndSensorsArg, tunnel, intake);
    }

    @Override
    public void execute() {
        flyAndSensors.setFlySpeed(Constants.FREEZE);
        intake.setIntakeSpeed(Constants.FREEZE);
        tunnel.setMoverSpeed(Constants.FREEZE);
    }
}
