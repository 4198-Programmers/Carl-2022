// package frc.robot.commands.ShootingCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Maths;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class SpinUpFlyWheel extends CommandBase{
    Shooter shooter;
    Limelight limelight;
    Maths maths;

    
    public SpinUpFlyWheel(Shooter shooterArg){
        shooter = shooterArg;
        addRequirements(shooter);
    }
    @Override
    public void execute() {
        shooter.flywheelspeed(Maths.wantedFlyWheelSpeed(Limelight.distanceToTarget()));
    }
    @Override
    public boolean isFinished(){
        double speed = Constants.FLY_WHEEL_SPEED;
        final double tolerance = 0.01;
        double expectedFlyWheelSpeed = Maths.wantedFlyWheelSpeed(Limelight.distanceToTarget());
        return(speed > expectedFlyWheelSpeed - tolerance && speed < expectedFlyWheelSpeed + tolerance);
    }
}
