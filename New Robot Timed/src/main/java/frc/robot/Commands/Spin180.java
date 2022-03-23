package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.Subsystems.DriveTrain;

public class Spin180 extends CommandBase{
    DriveTrain driveTrain;
    double distance;
    boolean youdone;
    public Spin180(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        driveTrain.resetPosition();
        distance = 40;
        youdone = false;
    }
    @Override
    public void execute() {
        if(distance < Maths.spinDistanceByDegree(distance))
        driveTrain.greenLight(-1, 0);
        else if(distance >= Maths.spinDistanceByDegree(distance)){
            driveTrain.greenLight(0, 0);
            youdone = true;
        }

    }
    @Override
    public boolean isFinished() {
        return (youdone == true);
    }
}
