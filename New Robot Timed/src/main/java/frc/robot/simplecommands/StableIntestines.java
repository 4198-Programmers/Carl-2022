package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterPathMovement;

public class StableIntestines extends CommandBase {
    private ShooterPathMovement pewPewSI;

    public StableIntestines(ShooterPathMovement pewPewArg) {
        pewPewSI = pewPewArg;
        addRequirements(pewPewArg);
    }

    @Override
    public void execute() {
        pewPewSI.setFlySpeed(Constants.FREEZE);
        pewPewSI.setIntakeSpeed(Constants.FREEZE);
        pewPewSI.setMoverSpeed(Constants.FREEZE);
    }
}
