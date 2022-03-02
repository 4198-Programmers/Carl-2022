package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShooterPathMovement;

public class SetInternalMoveSpeed extends CommandBase {
    private ShooterPathMovement pewPewSIMS;
    private DriveTrain vroomVroomSIMS;
    private boolean isFinished = false;

    public SetInternalMoveSpeed(ShooterPathMovement shooterPathMovementArg) {
        pewPewSIMS = shooterPathMovementArg;
        addRequirements(pewPewSIMS);
    }

    @Override
    public void execute() {
        pewPewSIMS.setMoverSpeed(Constants.INTERNAL_FEEDER_SPEED);
    }
}
