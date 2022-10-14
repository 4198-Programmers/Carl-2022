package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;

/**
 * {@link IntakeFeeder} Uses sensors to intake two balls to the Tunnel
 */
public class IntakeFeeder extends CommandBase {
    Intake intake;
    Tunnel tunnel;
    FlyAndSensors sensor;
    boolean done;

    /**
     * {@link IntakeFeeder} Uses sensors to intake two balls to the Tunnel 
     */
    public IntakeFeeder(Intake intakeArg, Tunnel tunnelArg, FlyAndSensors flyAndSensorsArg) {
        intake = intakeArg;
        tunnel = tunnelArg;
        sensor = flyAndSensorsArg;
        addRequirements(intake, tunnel);
    }

    @Override
    public void execute() {
        intake.setIntakeSpeed(Constants.INTAKE_FORWARD_SPEED);
        if (sensor.ballIn() && !sensor.ballOut()) {
            System.out.println("if");
            tunnel.setMoverSpeed(Constants.INTERNAL_FEEDER_SPEED);
        } else {
            System.out.println("else");
            tunnel.setMoverSpeed(Constants.FREEZE);
        }
    }
}
