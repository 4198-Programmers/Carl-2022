package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class AutoCodeSemiCircle extends CommandBase {

DriveTrain driveTrain; 
double leftSpeed; 
double rightSpeed; 
double distance; 
double radius; 
boolean turnLeft; 
double distanceRotations; 
double autoCodeSpeedRatioCircle;


public AutoCodeSemiCircle (DriveTrain driveTrain, double radius, boolean turnLeft){
this.driveTrain = driveTrain; 
this.radius = radius; 
this.turnLeft = turnLeft; 

addRequirements(driveTrain);
}

@Override 
public void initialize (){ 
    this.driveTrain.resetposition(); 
}

@Override 
public void execute (){

    if (this.turnLeft)
    {
        this.distance = Maths.semiCircleCircumference(radius);
    
        leftSpeed = 1 * autoCodeSpeedRatioCircle;
        rightSpeed = 1; 
    }
    else {
        this.distance = Maths.circumference(radius + Constants.WIDTH_OF_JAKE);
    
        rightSpeed = 1 * autoCodeSpeedRatioCircle;
        leftSpeed = 1; 
        
    }
    this.distanceRotations = Maths.rotationConversion (this.distance);
    
}

@Override 
public boolean isFinished(){ 
    return driveTrain.findposition () >= this.distanceRotations; 
}
}