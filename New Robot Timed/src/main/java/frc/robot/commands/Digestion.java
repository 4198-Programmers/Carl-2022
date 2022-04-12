package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Organs;

public class Digestion extends CommandBase {

    private Organs organs;

    public Digestion(Organs organs) {
        this.organs = organs;
        addRequirements(organs);
    }

    @Override
    public void execute() {
        organs.bowelMovement(0.5);
    }
}
