package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.AngledHooks;

public class DanceAngledHooks extends CommandBase {
    AngledHooks angledHooks;
    double distance;

    public DanceAngledHooks(AngledHooks angledHooks, double distance) {
        this.angledHooks = angledHooks;
        this.distance = distance;
        addRequirements(angledHooks);
    }

    @Override
    public void initialize() {
        angledHooks.resetPostition();
    }

    @Override
    public void execute() {
        if (angledHooks.getPosition() <= distance) {
            angledHooks.moveHooks(0.15);
        }

        else if (angledHooks.getPosition() >= distance) {
            angledHooks.stopHooks();
        }
    }

    @Override
    public boolean isFinished() {
        return (angledHooks.getPosition() >= distance);
    }

}
