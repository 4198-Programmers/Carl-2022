package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoStop extends CommandBase {
    private final Drivetrain drivetrain;
    private boolean end;

    public AutoStop(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.Reset();
    }

    @Override
    public void execute() {
        drivetrain.Movement(0, 0);
        end = true;
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return end;
    }
}
