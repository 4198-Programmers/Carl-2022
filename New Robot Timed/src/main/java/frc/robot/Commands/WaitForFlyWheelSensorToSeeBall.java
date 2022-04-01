package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Sensors;

public class WaitForFlyWheelSensorToSeeBall extends CommandBase {
    Sensors sensors;

    public WaitForFlyWheelSensorToSeeBall() {
    }

    @Override
    public boolean isFinished() {
        return sensors.hasBallBeenShot();
    }

    @Override
    public void end(boolean interrupted) {
        sensors.forget();
    }
}