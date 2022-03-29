package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveTrain;

public class TurnForTenSeconds extends CommandBase{
    DriveTrain driveTrain;
    double speed;
    double turnSpeed;
    long milliseconds;
    RotationDirection rotationDirection;
    long startingTime;
    public enum RotationDirection{
        turnLeft(-1),
        turnRight(1);
        private double direction;

        private RotationDirection(double direction) {
            this.direction = direction;
        }

        protected double getSpinDirection() {
            return direction;
        }
    }

    public TurnForTenSeconds(DriveTrain driveTrain, double speed, double turnSpeed, long milliseconds ){
        this.driveTrain = driveTrain;
        this.speed = speed;
        this.milliseconds = milliseconds;
        this.turnSpeed = turnSpeed;
    }
    @Override
    public void initialize() {
        startingTime = System.currentTimeMillis();
        rotationDirection = RotationDirection.turnLeft;
    }

@Override
public void execute() {
    switch(rotationDirection){
        case turnLeft:
            if(System.currentTimeMillis() >= (milliseconds / 2) + startingTime){
                rotationDirection = RotationDirection.turnRight;
            }
            driveTrain.greenLight(speed, -Math.abs(turnSpeed));
            break;
        case turnRight:
            driveTrain.greenLight(speed, Math.abs(turnSpeed));
            break;
    }
}
@Override
public boolean isFinished() {
    return(System.currentTimeMillis() >= milliseconds + startingTime);
}
@Override
public void end(boolean interrupted) {
    driveTrain.greenLight(0, 0);
}
}
