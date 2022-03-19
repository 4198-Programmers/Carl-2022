package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class BuildIsMean extends CommandBase {
    private DriveTrain vroom;

    public BuildIsMean(DriveTrain vroomArg) {
        vroom = vroomArg;
        addRequirements(vroomArg);
    }

    @Override
    public void execute() {
        vroom.greenLight(0.25, 0);

    }

}
