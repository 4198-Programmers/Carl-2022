package frc.robot.command;

import frc.robot.Maths;

import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShooterPathMovement;

public class SetFlySpeedVelocity extends SetFlySpeed {
    private ShooterPathMovement pewPew;
    private Limelight visionSFSV;

    public SetFlySpeedVelocity(ShooterPathMovement pewPewArg, Limelight visionSFSV) {
        super(pewPewArg);
        pewPew = pewPewArg;
        addRequirements(pewPew, visionSFSV);
        
    }



    @Override
    protected double catchWantedFlySpeed() {
        double distanceFromTarget = visionSFSV.distanceToTarget();
        double targetVelocityForFlywheel = Maths.flyWheelVelocityByDistance(distanceFromTarget);
        double targetVelocityForFlywheelRatio = Maths.flywheelMotorVelocityConversion(targetVelocityForFlywheel);
        System.out.println(targetVelocityForFlywheel);
        System.out.println(targetVelocityForFlywheelRatio);
        return targetVelocityForFlywheelRatio;
    }

}
