package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Maths;
import frc.robot.Subsystems.DriveTrain;

public class OffTarmac extends CommandBase{
    DriveTrain driveTrain;
    Maths maths;
    double distance;
    public OffTarmac(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        driveTrain.resetPosition();
        distance = Constants.WANTED_AUTO_DISTANCE;
    }
    @Override
    public void execute() {
        if(Maths.rotationConversion(distance) < driveTrain.position()){
            driveTrain.greenLight(0, 1);
        }
        else if(Maths.rotationConversion(distance) >= driveTrain.position()){
            driveTrain.greenLight(0, 0);
        }
    }
    @Override
    public boolean isFinished() {
        return(Maths.rotationConversion(distance) >= driveTrain.position());
    }
}
