package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;

public class SensorTummyStopAll extends CommandBase {
    FlyAndSensors flyAndSensors;
    Tunnel tunnel;
    Intake intake;
    boolean finished;

    public SensorTummyStopAll(FlyAndSensors sensorsArg, Tunnel tunnelArg, Intake intakeArg) {
        flyAndSensors = sensorsArg;
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
}
