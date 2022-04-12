package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mouth;

public class Regurgitation extends CommandBase {

    private Mouth mouth;

    public Regurgitation(Mouth mouth) {
        this.mouth = mouth;
        addRequirements(mouth);
    }

    @Override
    public void execute() {
        mouth.chompChomp(0.5);
    }

}
