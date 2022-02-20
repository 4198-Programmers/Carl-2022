package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class DeathSpin extends CommandBase{
    DriveTrain vroomVroom;
    double distanceTurning;
    boolean youDone;
    public DeathSpin(DriveTrain vroomVroom){
        this.vroomVroom = vroomVroom;
        addRequirements(vroomVroom);
    }
    @Override
    public void initialize() {
        distanceTurning = 40;
        youDone = false;
        vroomVroom.resetPosition();
    }
    @Override
    public void execute() {
        double rotations = Maths.rotationConversion(distanceTurning);
        double position = vroomVroom.getPosition();
        if(Math.abs(position) < rotations)
        vroomVroom.greenLight(-1, 1);
        else if(youDone == true){
            vroomVroom.greenLight(0, 0);
        }
    }
    @Override
    public boolean isFinished() {
        return youDone = true;
    }
}
