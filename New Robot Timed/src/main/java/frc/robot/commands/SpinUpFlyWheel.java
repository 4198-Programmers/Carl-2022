package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class SpinUpFlyWheel extends CommandBase{
    Shooter shooter;
    
    public SpinUpFlyWheel(Shooter shooterArg){
        shooter = shooterArg;
        addRequirements(shooter);
    }
    protected double expectedFlyWheelSpeed(){
        return Constants.EXPECTED_FLYWHEEL_SPEED;
    }
    @Override
    public void execute() {
        shooter.flywheelspeed(expectedFlyWheelSpeed());
    }
    @Override
    public boolean isFinished(){
    }
}
