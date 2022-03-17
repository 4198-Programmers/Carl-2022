package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterPathMovement;

public class SetIntakeSpeedOut extends CommandBase{
    private ShooterPathMovement pewPewSIS;

    public SetIntakeSpeedOut(ShooterPathMovement shooterPathMovementArg) {
        pewPewSIS = shooterPathMovementArg;
        addRequirements(pewPewSIS);
    }

    @Override
    public void execute() {
        pewPewSIS.setIntakeSpeed(Constants.INTAKE_REVERSE_SPEED);
    }
}
