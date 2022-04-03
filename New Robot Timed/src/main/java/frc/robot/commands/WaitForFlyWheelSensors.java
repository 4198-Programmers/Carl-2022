package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sensors;

public class WaitForFlyWheelSensors extends CommandBase {
    Sensors sensors;

    public WaitForFlyWheelSensors(Sensors sensors) {
        this.sensors = sensors;
    }

    @Override
    public boolean isFinished() {
        return (sensors.isBallAtShooter());
    }
}