package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FlyAndSensors;

/** {@link DoNotMove} stops motors to the DriveTrain and the FlyWheel */
public class DoNotMove extends CommandBase {
    DriveTrain driveTrain;
    FlyAndSensors flyAndSensors;

/** {@link DoNotMove} stops motors to the DriveTrain and the FlyWheel */
    public DoNotMove(DriveTrain driveTrainArg, FlyAndSensors flyAndSensorsArg) {
        driveTrain = driveTrainArg;
        flyAndSensors = flyAndSensorsArg;
        addRequirements(driveTrain, flyAndSensors);
    }

    @Override
    public void execute() {
        driveTrain.greenLight(Constants.FREEZE, Constants.FREEZE);
        flyAndSensors.setFlySpeed(Constants.FREEZE);
    }

}
