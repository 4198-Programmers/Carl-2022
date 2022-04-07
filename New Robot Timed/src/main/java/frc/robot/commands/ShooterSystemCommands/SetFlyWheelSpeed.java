package frc.robot.commands.ShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSystem.FlyWheel;

public class SetFlyWheelSpeed extends CommandBase{
    FlyWheel flyWheel;
    public interface SpeedRetriever{
        double getSpeed();
    }
    SpeedRetriever speedRetriever;
    double speed;
    public SetFlyWheelSpeed(FlyWheel flyWheel, SpeedRetriever speedRetriever, double speed){
        this.flyWheel = flyWheel;
        this.speedRetriever = speedRetriever;
        this.speed = speed;
        addRequirements(flyWheel);
    }

    @Override
    public void execute() {
        if(speedRetriever.getSpeed() != -1){
            flyWheel.setSpeed(speedRetriever.getSpeed());
        }
        else{
            flyWheel.setSpeed(speed);
        }
    }
    @Override
    public void end(boolean interrupted) {
        flyWheel.setSpeed(0);
    }
}
