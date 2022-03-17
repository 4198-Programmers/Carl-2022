package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterPathMovement;

public class SetIntakeSpeedIn extends CommandBase {
    private ShooterPathMovement pewPewSIS;

    public SetIntakeSpeedIn(ShooterPathMovement shooterPathMovementArg) {
        pewPewSIS = shooterPathMovementArg;
        addRequirements(pewPewSIS);
    }

    @Override
    public void execute() {
        pewPewSIS.setIntakeSpeed(Constants.INTAKE_FORWARD_SPEED);
    }

}
