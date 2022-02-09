package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterPathMovement;

public class SetIntakeSpeed extends CommandBase {
    private ShooterPathMovement pewPewSIS;

    public SetIntakeSpeed(ShooterPathMovement shooterPathMovementArg) {
        pewPewSIS = shooterPathMovementArg;
        addRequirements(pewPewSIS);
    }

    @Override
    public void execute() {
        pewPewSIS.setIntakeSpeed(Constants.INTAKE_SPEED);
    }

}
