package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class AutoCodeShape extends CommandBase {
DriveTrain driveTrain;
double speed = 1;
double distance;
double rotationDistance;
double angle;
double eclipsDistanceAngleConversion;  
double repeat; 
int repeatCount;
double distanceAngle; 
AutoCodeRotation rotation;
double rotationAngleDistance;

public AutoCodeShape (DriveTrain driveTrain, double distance, double angle, double repeat){
this.driveTrain = driveTrain;
this.distance = distance; 
this.rotationDistance = Maths.rotationConversion(distance);
this.angle = angle; 
this.distanceAngle = Maths.distanceDegreeConversion(angle, Constants.RADIUS_WHEELS); 
this.repeat = repeat;

addRequirements(driveTrain); 
}

@Override
public void initialize () {
    repeatCount = 0; 
}

@Override 
public void execute () {

    double position = driveTrain.findposition();
//drive straight for rotation distance
    if (position < this.rotationDistance){
        driveTrain.autoDrive (1,1);
    }
    //roate angle distance

    else if (position < this.rotationDistance + this.rotationAngleDistance){
        driveTrain.autoDrive (1,-1);
    }
    //repeat repeat times

    else{
        driveTrain.resetposition();
        this.repeatCount += 1;
    } 

}

@Override
public boolean isFinished() {
    return repeatCount != repeat; 
//what does the ! do???
}
}
