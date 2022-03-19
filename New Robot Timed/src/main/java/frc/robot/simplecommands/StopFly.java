package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;

public class StopFly extends CommandBase {
    boolean done;
    private FlyAndSensors fly;

    public StopFly(FlyAndSensors flyAndSensorsArg) {
        fly = flyAndSensorsArg;
        addRequirements(fly);
    }

    @Override
    public void initialize() {
        done = false;
    }

    @Override
    public void execute() {
        fly.setFlySpeed(Constants.FREEZE);
        done = true;
    }

    @Override
    public boolean isFinished() {
        return done;
    }

}
