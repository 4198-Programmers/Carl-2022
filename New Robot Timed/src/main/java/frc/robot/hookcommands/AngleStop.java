package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;

public class AngleStop extends CommandBase{
    private AngleHooks intake;

    public AngleStop(AngleHooks shooterPathMovementArg) {
        intake = shooterPathMovementArg;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.moveAngledHooks(Constants.FREEZE);
    }
    
}
