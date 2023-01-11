package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class AutoCodeRotation extends CommandBase{

double degree; 
double rightSpeed; 
double leftSpeed; 
DriveTrain driveTrain; 
boolean turnLeft; 
double eclipsCircumference = 0; 
double distance; 
double eclipsDistancedegreeConversion; 
double rotation;
//need mesuments 

    public AutoCodeRotation(DriveTrain driveTrain, double degree, boolean turnLeft){
    this.degree = degree; 
    this.driveTrain = driveTrain; 
    this.turnLeft = turnLeft; 

    
    distance = Maths.distanceDegreeConversion(degree, Constants.RADIUS_WHEELS); 

    rotation = Maths.rotationConversion(distance);

    addRequirements(driveTrain); }

    
@Override
public void initialize(){ 

    driveTrain.resetposition(); 

}

@Override
public void execute(){ 
    
    driveTrain.autoDrive (leftSpeed, rightSpeed); 

    if (turnLeft == true)
    {
        leftSpeed = -1; 
        rightSpeed = 1; 
    }

    else if(turnLeft == false)
    {
        leftSpeed = 1; 
        rightSpeed = -1; 
    }    
    else
    {
        leftSpeed = 0;
        rightSpeed = 0;
    }
}

@Override
public boolean isFinished(){

    return driveTrain.findposition() >= rotation;

}
} 

