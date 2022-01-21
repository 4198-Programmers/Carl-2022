package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.DriveTrain;
import frc.robot.Shooter;

/** stops any and all motors */
public class DoNotMove extends CommandBase {          
    /**still vroomVroom from robot, just used in this class(DNM)*/      
    private DriveTrain vroomVroomDNM;
    private Shooter pewPewDNM;
    
    public DoNotMove(DriveTrain driveTrainArg, Shooter shooterArg){
        vroomVroomDNM = driveTrainArg;
        pewPewDNM = shooterArg;
    }

    @Override
    public void execute() {
        vroomVroomDNM.greenLight(Constants.FREEZE, Constants.FREEZE);
        pewPewDNM.setFlySpeed(Constants.FREEZE);
    }

    
}
