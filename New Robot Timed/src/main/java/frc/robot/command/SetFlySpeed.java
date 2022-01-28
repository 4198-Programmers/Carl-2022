package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterPathMovement;

public class SetFlySpeed extends CommandBase{
    private ShooterPathMovement pewPew;

    public SetFlySpeed(ShooterPathMovement pewPewArg){
        pewPew = pewPewArg;
        addRequirements(pewPew);
    }

    @Override
    public void execute() {
        pewPew.setFlySpeed(Constants.FLYWHEEL_SPEED);
    }

    @Override
    public boolean isFinished() {
        double speed = pewPew.getFlySpeed();
        final double tolerance = 0.01;
        return (speed > Constants.FLYWHEEL_SPEED - tolerance && speed < Constants.FLYWHEEL_SPEED + tolerance);
        
    }
}
