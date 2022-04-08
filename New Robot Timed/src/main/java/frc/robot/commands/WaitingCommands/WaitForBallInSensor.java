package frc.robot.commands.WaitingCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sensors;

public class WaitForBallInSensor extends CommandBase {
    Sensors sensors;

    public WaitForBallInSensor(Sensors sensors) {
        this.sensors = sensors;
    }

    @Override
    public boolean isFinished() {
        return sensors.isBallAtIntake();
    }
}
