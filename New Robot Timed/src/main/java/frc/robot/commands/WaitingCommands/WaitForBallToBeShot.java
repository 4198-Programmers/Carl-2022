package frc.robot.commands.WaitingCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sensors;

public class WaitForBallToBeShot extends CommandBase {
    Sensors sensors;

    public WaitForBallToBeShot(Sensors sensors) {
        this.sensors = sensors;
    }

    @Override
    public boolean isFinished() {
        return sensors.hasBallBeenSeenAtShooter();
    }

    @Override
    public void end(boolean interrupted) {
        sensors.forgetShooterBall();
    }
}
