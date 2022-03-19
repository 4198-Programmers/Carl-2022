package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class SetIntakeSpeedIn extends CommandBase {
    private Intake intake;
    boolean done;
    double autoTime;

    public SetIntakeSpeedIn(Intake intakeSub) {
        intake = intakeSub;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        done = false;
        autoTime = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        intake.setIntakeSpeed(Constants.INTAKE_FORWARD_SPEED);
        done = true;
    }

    @Override
    public boolean isFinished() {
        return (done && (System.currentTimeMillis() - autoTime) >= 250);
    }

}
