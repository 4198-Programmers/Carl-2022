package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.Subsystems.DriveTrain;

public class Spin extends CommandBase {
    DriveTrain driveTrain;
    double degrees;
    boolean youdone;

    public Spin(DriveTrain driveTrain, double degrees) {
        this.driveTrain = driveTrain;
        this.degrees = degrees;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.resetPosition();
        youdone = false;
    }

    @Override
    public void execute() {
        double position = Math.abs(driveTrain.position());
        double rotations = Maths.spinDistanceByDegree(degrees);
        if (position < rotations)
            driveTrain.greenLight(0, -1);
        else if (position >= rotations) {
            driveTrain.greenLight(0, 0);
            youdone = true;
        }

    }

    @Override
    public boolean isFinished() {
        return (youdone == true);
    }
}