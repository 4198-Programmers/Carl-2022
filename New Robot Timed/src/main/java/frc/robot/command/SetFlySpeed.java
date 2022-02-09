package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterPathMovement;

public class SetFlySpeed extends CommandBase {
    private ShooterPathMovement pewPew;

    public SetFlySpeed(ShooterPathMovement pewPewArg) {
        pewPew = pewPewArg;
        addRequirements(pewPew);
    }

    protected double catchWantedFlySpeed() {
        return Constants.FLYWHEEL_SPEED;
    }

    @Override
    public void execute() {
        pewPew.setFlySpeed(catchWantedFlySpeed());
    }

    @Override
    public boolean isFinished() {
        double speed = pewPew.getFlySpeed();
        final double tolerance = 0.01;
        double expectedFlywheelSpeed = catchWantedFlySpeed();
        return (speed > expectedFlywheelSpeed - tolerance && speed < expectedFlywheelSpeed + tolerance);

    }
}
