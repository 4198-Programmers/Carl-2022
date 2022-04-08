package frc.robot.commands.ShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem.FlyWheel;

public class AutoFlyWheelSpeed extends CommandBase {
    FlyWheel flyWheel;
    double speed;

    public AutoFlyWheelSpeed(FlyWheel flyWheel, double speed) {
        this.flyWheel = flyWheel;
        this.speed = speed;
        addRequirements(flyWheel);
    }

    @Override
    public void execute() {
        flyWheel.setSpeed(speed);
    }
}
