package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

/**
 * {@link ResetWheels} Sets the wheels current position to 0 on the encoders to
 * use other commands
 */
public class ResetWheels extends CommandBase {
    DriveTrain driveTrain;

    /**
     * {@link ResetWheels} Sets the wheels current position to 0 on the encoders to
     * use other commands
     */
    public ResetWheels(DriveTrain driveTrainArg) {
        driveTrain = driveTrainArg;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.resetPosition();
    }

    @Override
    public void execute() {
        driveTrain.resetPosition();
    }

    @Override
    public boolean isFinished() {
        return (driveTrain.findPosition() <= 0.025);
    }
}
