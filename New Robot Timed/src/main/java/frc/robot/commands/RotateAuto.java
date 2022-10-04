package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.Drivetrain;

public class RotateAuto extends CommandBase {
    private final Drivetrain drivetrain;
    private boolean end;
    private double whereIGo = 40;

    public RotateAuto(Drivetrain drivetrain) {
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
        double rotations = Maths.DistanceTraveled(whereIGo);
        if (Math.abs(locaton) < rotations) {
            drivetrain.Movement(0, 1);
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
