package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;

public class StopFly extends CommandBase{

    private FlyAndSensors fly;

    public StopFly(FlyAndSensors shooterPathMovementArg) {
        fly = shooterPathMovementArg;
        addRequirements(fly);
    }

    @Override
    public void execute() {
        fly.setFlySpeed(Constants.FREEZE);
    }
    
}
