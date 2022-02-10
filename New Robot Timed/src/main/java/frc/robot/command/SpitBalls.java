package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterPathMovement;

public class SpitBalls extends CommandBase {
    private ShooterPathMovement pewPewSB;

    public SpitBalls(ShooterPathMovement shooterPathMovementArg) {
        pewPewSB = shooterPathMovementArg;
        addRequirements(pewPewSB);
    }

    @Override
    public void execute() {
        pewPewSB.setMoverSpeed(Constants.INTERNAL_FEEDER_REVERSE_SPEED);
        pewPewSB.setIntakeSpeed(Constants.INTAKE_REVERSE_SPEED);
    }

}
