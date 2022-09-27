package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;

/** {@link StopFly} Sets just the FlyWheel speed to 0 */
public class StopFly extends CommandBase {
    boolean youDone;
    FlyAndSensors flyWheel;

    /** {@link StopFly} Sets just the FlyWheel speed to 0 */
    public StopFly(FlyAndSensors flyAndSensorsArg) {
        flyWheel = flyAndSensorsArg;
        addRequirements(flyWheel);
    }

    @Override
    public void initialize() {
        youDone = false;
    }

    @Override
    public void execute() {
        flyWheel.setFlySpeed(Constants.FREEZE);
        youDone = true;
    }

    @Override
    public boolean isFinished() {
        return youDone;
    }
}
