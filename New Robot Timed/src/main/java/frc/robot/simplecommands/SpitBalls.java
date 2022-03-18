package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;

public class SpitBalls extends CommandBase {
    private Intake intake;
    private Tunnel tunnel;

    public SpitBalls(Intake intakeArg, Tunnel tunnelArg) {
        intake = intakeArg;
        tunnel = tunnelArg;
        addRequirements(intake, tunnel);
    }

    @Override
    public void execute() {
        tunnel.setMoverSpeed(Constants.INTERNAL_FEEDER_REVERSE_SPEED);
        intake.setIntakeSpeed(Constants.INTAKE_REVERSE_SPEED);
    }

}
