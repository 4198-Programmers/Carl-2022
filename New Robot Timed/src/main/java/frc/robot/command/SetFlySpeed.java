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

    private double getWantedFlySpeed() {
        double checkWantedFlySpeed = catchWantedFlySpeed();
        if (checkWantedFlySpeed <= Constants.MAX_FLYWHEEL_SPEED) {
            return checkWantedFlySpeed;
        } else {
            return Constants.MAX_FLYWHEEL_SPEED;
        }
    }

    @Override
    public void execute() {
        double flySpeed = getWantedFlySpeed();
        pewPew.setFlySpeed(flySpeed);
    }

    @Override
    public boolean isFinished() {
        double speed = pewPew.getFlySpeed();
        final double tolerance = 0.01;
        double expectedFlywheelSpeed = getWantedFlySpeed();
        return (speed > expectedFlywheelSpeed - tolerance && speed < expectedFlywheelSpeed + tolerance);
    }
}
