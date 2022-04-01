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
        double rotationsToSpin = Maths.spinDistanceByDegree((degrees - 10));
        double position = driveTrain.findPosition();
        if(Math.abs(position) < rotationsToSpin){
            driveTrain.greenLight(-1, 0);
        }
        else if(Math.abs(position) >= rotationsToSpin){
            driveTrain.greenLight(0, 0);
            youDone = true;
        }
    }
    @Override
    public boolean isFinished() {
        return(youDone == true);
    }
}
