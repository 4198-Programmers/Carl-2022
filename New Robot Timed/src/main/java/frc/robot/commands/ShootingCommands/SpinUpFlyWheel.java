package frc.robot.commands.ShootingCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class SpinUpFlyWheel extends CommandBase{
    Shooter shooter;
    
    public SpinUpFlyWheel(Shooter shooterArg){
        shooter = shooterArg;
        addRequirements(shooter);
    }
    protected double wantedFlyWheelSpeed(){
        return Constants.EXPECTED_FLYWHEEL_SPEED;
    }
    @Override
    public void execute() {
        shooter.flywheelspeed(wantedFlyWheelSpeed());
    }
    @Override
    public boolean isFinished(){
        double speed = Constants.FLY_WHEEL_SPEED;
        final double tolerance = 0.01;
        double expectedFlyWheelSpeed = wantedFlyWheelSpeed();
        return(speed > expectedFlyWheelSpeed - tolerance && speed < expectedFlyWheelSpeed + tolerance);
    }
}
