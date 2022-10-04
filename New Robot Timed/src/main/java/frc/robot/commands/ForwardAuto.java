package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.Drivetrain;

public class ForwardAuto extends CommandBase {
    private final Drivetrain drivetrain;
    private boolean end;
    private double distance = 40;

    public ForwardAuto(Drivetrain drivetrain) {
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

        double locaton = drivetrain.encoderAverage();
        double rotations = Maths.DistanceTraveled(distance);
        if (Math.abs(locaton) < rotations) {
            drivetrain.Movement(0.5, 0);
        } else {
            drivetrain.Movement(0, 0);
            end = true;
        }
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return end;
    }
}
