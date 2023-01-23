package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PincherMotor;

public class PinchOut extends CommandBase {

    private PincherMotor pincherMotor;

    public PinchOut(PincherMotor pincherMotor) {

        this.pincherMotor = pincherMotor;
        addRequirements(pincherMotor);

    }

    @Override
    public void execute() {
        pincherMotor.pincherMotorActivate(-0.5);
    }

}