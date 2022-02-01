package frc.robot.command;

import frc.robot.Constants;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShooterPathMovement;

public class SetFlySpeedUsingCalculation extends SetFlySpeed{
    private Limelight visionSFSUC;
    private ShooterPathMovement pewPewSFSUC;


    public SetFlySpeedUsingCalculation(Limelight limelightArg, ShooterPathMovement shooterPathMovementArg)
    {
        super(shooterPathMovementArg);
        visionSFSUC = limelightArg;
    }

    @Override
    protected double catchWantedFlySpeed() {

        // double velocityCalculated = visionSFSUC.distanceToTarget();//TODO this is very very wrong please add equation 

        // return velocityCalculated;
        return Constants.FLYWHEEL_SPEED;
    }

    
}
