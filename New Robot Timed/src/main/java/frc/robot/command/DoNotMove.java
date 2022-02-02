package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShooterPathMovement;

/** stops any and all motors */
public class DoNotMove extends CommandBase {          
    /**still vroomVroom from robot, just used in this class(DNM)*/      
    private DriveTrain vroomVroomDNM;
    private ShooterPathMovement pewPewDNM;
    
    /**Pulls in the current DriveTrain and Shooter instances to use in the specific class */
    public DoNotMove(DriveTrain driveTrainArg, ShooterPathMovement shooterArg){
        vroomVroomDNM = driveTrainArg;
        pewPewDNM = shooterArg;
        addRequirements(vroomVroomDNM, pewPewDNM);
    }

    @Override
    public void execute() {
        vroomVroomDNM.greenLight(Constants.FREEZE, Constants.FREEZE);
        pewPewDNM.setFlySpeed(Constants.FREEZE);
    }

    
}
