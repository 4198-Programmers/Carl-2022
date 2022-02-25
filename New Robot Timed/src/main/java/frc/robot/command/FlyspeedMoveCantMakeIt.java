package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class FlyspeedMoveCantMakeIt extends CommandBase{
    private DriveTrain vroomVroomFMCMI;
    private SetFlySpeedVelocity setFlySpeedVelocityFMCMI;
    private boolean isFinished;
    
    public FlyspeedMoveCantMakeIt(DriveTrain vroomVroomArg) {
        vroomVroomFMCMI = vroomVroomArg;
        addRequirements(vroomVroomFMCMI);
    }

    protected double MoveForewardDecisionFind(){
        return setFlySpeedVelocityFMCMI.catchWantedFlySpeed();
    }

    @Override
    public void execute(){
        if(MoveForewardDecisionFind() > Constants.MAX_FLYWHEEL_VELOCITY_RATIO) {
            vroomVroomFMCMI.greenLight(0, 1);
            isFinished = true;
        }
    }

    public boolean isFinished() {
        return isFinished;
    }
}
