package frc.robot.commands.WaitingCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem.FlyWheel;

public class WaitForFlyWheel extends CommandBase{
    FlyWheel flyWheel;
    double speed;
    public WaitForFlyWheel(FlyWheel flyWheel, double speed){
        this.flyWheel = flyWheel;
        this.speed = speed;
    }
    @Override
    public boolean isFinished() {
        return flyWheel.getSpeed() >= speed;
    }
}
