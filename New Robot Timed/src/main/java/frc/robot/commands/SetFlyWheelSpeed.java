package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyWheel;

public class SetFlyWheelSpeed extends CommandBase {
    public interface FlyWheelSpeedRetriever {
        double getFlyWheelSpeed();
    }

    FlyWheel flyWheel;
    FlyWheelSpeedRetriever flyWheelSpeedRetriever;

    public SetFlyWheelSpeed(FlyWheel flyWheel, FlyWheelSpeedRetriever flyWheelSpeedRetriever) {
        this.flyWheel = flyWheel;
        this.flyWheelSpeedRetriever = flyWheelSpeedRetriever;
        addRequirements(flyWheel);
    }

    @Override
    public void execute() {
        flyWheel.setSpeed(flyWheelSpeedRetriever.getFlyWheelSpeed());
    }

    @Override
    public void end(boolean interrupted) {
        flyWheel.setSpeed(0);
    }
}