package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveTrain;

public class DoNotDrive extends CommandBase {
    DriveTrain driveTrain;

    public DoNotDrive(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        driveTrain.resetPosition();
        driveTrain.greenLight(0, 0);
    }

    @Override
    public boolean isFinished() {
        return (driveTrain.position() == 0);
    }
}
