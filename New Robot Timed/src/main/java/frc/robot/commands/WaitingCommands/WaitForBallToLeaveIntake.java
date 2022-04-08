package frc.robot.commands.WaitingCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sensors;

public class WaitForBallToLeaveIntake extends CommandBase {
    Sensors sensors;

    public WaitForBallToLeaveIntake(Sensors sensors) {
        this.sensors = sensors;
    }

    @Override
    public boolean isFinished() {
        return !sensors.isBallAtIntake();
    }
}
