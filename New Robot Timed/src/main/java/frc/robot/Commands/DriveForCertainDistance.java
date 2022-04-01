package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.Subsystems.DriveTrain;

public class DriveForCertainDistance extends CommandBase {
    DriveTrain driveTrain;
    Maths maths;
    double distance;

    public DriveForCertainDistance(DriveTrain driveTrain, double distance) {
        this.driveTrain = driveTrain;
        this.distance = distance;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.resetPosition();
    }

    @Override
    public void execute() {
        if (Maths.rotationConversion(distance) < driveTrain.position()) {
            driveTrain.greenLight(1, 0);
        } else if (Maths.rotationConversion(distance) >= driveTrain.position()) {
            driveTrain.greenLight(0, 0);
        }
    }

    @Override
    public boolean isFinished() {
        return (Maths.rotationConversion(distance) >= driveTrain.position());
    }
}
