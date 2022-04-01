package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class Spin extends CommandBase{
    DriveTrain driveTrain;
    double degrees;
    boolean youDone;
    public Spin(DriveTrain driveTrain, double degrees){
        this.driveTrain = driveTrain;
        this.degrees = degrees;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        driveTrain.resetPosition();
        youDone = false;
    }
    @Override
    public void execute() {
        if(driveTrain.findPosition() < Maths.spinDistanceByDegree(degrees)){
            driveTrain.greenLight(0, -1);
        }
        else if(driveTrain.findPosition() >= Maths.spinDistanceByDegree(degrees)){
            driveTrain.greenLight(0, 0);
            youDone = true;
        }
    }
    @Override
    public boolean isFinished() {
        return(youDone == true);
    }
}
