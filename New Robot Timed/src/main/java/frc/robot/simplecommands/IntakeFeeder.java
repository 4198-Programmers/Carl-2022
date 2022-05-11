package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;

public class IntakeFeeder extends CommandBase {
    Intake intake;
    Tunnel tunnel;
    FlyAndSensors sensor;
    boolean done;

    public IntakeFeeder(Intake intakeSub, Tunnel tunnelSub, FlyAndSensors flyAndSensorsSub) {
        intake = intakeSub;
        tunnel = tunnelSub;
        sensor = flyAndSensorsSub;
        addRequirements(intake, tunnel);
    }

    @Override
    public void initialize() {
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
