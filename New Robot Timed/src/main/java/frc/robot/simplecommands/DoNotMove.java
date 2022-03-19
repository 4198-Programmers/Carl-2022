package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FlyAndSensors;

/** stops any and all motors */
public class DoNotMove extends CommandBase {
    /** still vroomVroom from robot, just used in this class(DNM) */
    private DriveTrain vroomVroom;
    private FlyAndSensors flyAndSensors;

    /**
     * Pulls in the current DriveTrain and Shooter instances to use in the specific
     * class
     */
    public DoNotMove(DriveTrain driveTrainArg, FlyAndSensors flyAndSensorsArg) {
        vroomVroom = driveTrainArg;
        flyAndSensors = flyAndSensorsArg;
        addRequirements(vroomVroom, flyAndSensors);
    }

    @Override
    public void execute() {
        vroomVroom.greenLight(Constants.FREEZE, Constants.FREEZE);
        flyAndSensors.setFlySpeed(Constants.FREEZE);
    }

}
