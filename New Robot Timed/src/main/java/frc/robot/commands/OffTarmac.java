package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class OffTarmac extends CommandBase{
    DriveTrain vroomVroomDT;
    Drive drive;
    boolean youDone;
    double distanceOff;
    public OffTarmac (DriveTrain vroomVroomArg){
        vroomVroomDT = vroomVroomArg;
        addRequirements(vroomVroomDT);
    }
    @Override
    public void initialize() {
        distanceOff = 40;
        youDone = false;
        vroomVroomDT.resetPosition();
    }
    @Override
    public void execute() {
        double rotations = Maths.rotationConversion(distanceOff);
        double position = vroomVroomDT.getPosition();
        if (Math.abs(position) < rotations){
            vroomVroomDT.greenLight(0, -1);
        }
        else{
            vroomVroomDT.greenLight(0, 0);
            youDone = true;
        }
    }
    @Override
    public boolean isFinished() {
        return youDone;
    }
}
