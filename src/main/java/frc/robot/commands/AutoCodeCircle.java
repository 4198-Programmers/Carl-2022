package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class AutoCodeCircle extends CommandBase{ 

    DriveTrain driveTrain; 
    double rightSpeed;
    double leftSpeed; 
    double distance; 
    double radius; 
    boolean turnLeft;
    double distanceRotations;  
    double circumference;
    double circumferenceCircleRatio;
    double rotationConversion;
    

public AutoCodeCircle (DriveTrain driveTrain, double radius, boolean turnLeft){
this.driveTrain = driveTrain;
this.radius = radius; 
this.turnLeft = turnLeft; 

circumferenceCircleRatio = Maths.circumferenceCircleRatio(radius);

distanceRotations = Maths.rotationConversion(this.distance);

addRequirements(driveTrain);}

@Override
public void initialize (){ 

    this.driveTrain.resetposition(); 

}

@Override 
public void execute(Object Maths, Object Maths) { 
     
    this.driveTrain.autoDrive(rightSpeed, leftSpeed);

    if (this.turnLeft)
{
    this.distance = Maths.circumferenceCircleRatio(radius);

    leftSpeed = 1 * circumferenceCircleRatio;
    rightSpeed = 1; 
}
else {
    this.distance = Maths.circumferenceCircleRatio(radius + Constants.WIDTH_OF_JAKE);

    rightSpeed = 1 * circumferenceCircleRatio;
    leftSpeed = 1; 
}
}

@Override
public boolean isFinished() {

    return DriveTrain.findPositionLeft() >= this.distanceRotations; 
}
}