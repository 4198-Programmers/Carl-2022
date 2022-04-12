package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class NeoDrift extends CommandBase {

    boolean complete;
    double farGone;
    private DriveTrain neoYokio;

    public NeoDrift(DriveTrain NeoYokio) {

        this.neoYokio = NeoYokio;
        addRequirements(neoYokio);
    }

    @Override
    public void initialize() {

        complete = false;
    }

    @Override
    public void execute() {

        double rotations = Maths.rotationConversion(50);
        double position = neoYokio.whereAmI();

        if (rotations < position) {
            neoYokio.tokyo(-1, 0);
        } else {
            neoYokio.tokyo(0, 0);
            complete = true;
        }
    }

    @Override
    public boolean isFinished() {
        return complete;
    }
}
