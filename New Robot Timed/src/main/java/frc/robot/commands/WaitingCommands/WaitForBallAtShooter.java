package frc.robot.commands.WaitingCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sensors;

public class WaitForBallAtShooter extends CommandBase{
    Sensors sensors;
    public WaitForBallAtShooter(Sensors sensors){
        this.sensors = sensors;
    }
    @Override
    public boolean isFinished() {
        return sensors.isBallAtShooter();
    }
}
