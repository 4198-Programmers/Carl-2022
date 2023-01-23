package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PincherPneumatic;

public class PincherPneumaticPinchIn extends CommandBase {

    private PincherPneumatic pincherPneumatic;

    public PincherPneumaticPinchIn(PincherPneumatic pincherPneumatic) {

        this.pincherPneumatic = pincherPneumatic;
        addRequirements(pincherPneumatic);

    }

    @Override
    public void execute() {
        pincherPneumatic.pincerSolenoidActivate(true);
    }

}