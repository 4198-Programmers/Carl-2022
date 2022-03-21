package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DeathSpin extends CommandBase {

    private DriveTrain deathParade;
    boolean spinCondition;

    public DeathSpin(DriveTrain deathParade) {
        this.deathParade = deathParade;
        addRequirements(deathParade);
    }

    @Override
    public void initialize() {
        spinCondition = true;
        deathParade.resetPosition();
    }

    @Override
    public void execute() {
        deathParade.tokyo(1, 0);
    }

}
