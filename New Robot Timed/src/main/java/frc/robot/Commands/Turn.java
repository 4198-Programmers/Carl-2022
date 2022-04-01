package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveTrain;

public class Turn extends CommandBase{
    DriveTrain driveTrain;
    double distance;
    public Turn(DriveTrain driveTrain, double distance){
        this.driveTrain =  driveTrain;
        this.distance = distance;
        addRequirements(driveTrain);
    }
    @Override
    public void initialize() {
        driveTrain.resetPosition();
    }
    @Override
    public void execute() {
        if(driveTrain.position() <= distance){
            driveTrain.greenLight(0, 0.5);
        }
    }
    @Override
    public boolean isFinished() {
        return(driveTrain.position() >= distance);
    }
    @Override
    public void end(boolean interrupted) {
        driveTrain.greenLight(0, 0);
    }
}
