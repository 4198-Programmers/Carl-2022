package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
<<<<<<< Updated upstream
import frc.robot.DriveTrain;
import frc.robot.Shooter;
=======
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShooterPathMovement;
>>>>>>> Stashed changes

/** stops any and all motors */
public class DoNotMove extends CommandBase {
    /** still vroomVroom from robot, just used in this class(DNM) */
    private DriveTrain vroomVroomDNM;
<<<<<<< Updated upstream
    private Shooter pewPewDNM;
    
    public DoNotMove(DriveTrain driveTrainArg, Shooter shooterArg){
=======
    private ShooterPathMovement pewPewDNM;

    /**
     * Pulls in the current DriveTrain and Shooter instances to use in the specific
     * class
     */
    public DoNotMove(DriveTrain driveTrainArg, ShooterPathMovement shooterArg) {
>>>>>>> Stashed changes
        vroomVroomDNM = driveTrainArg;
        pewPewDNM = shooterArg;
    }

    @Override
    public void execute() {
        vroomVroomDNM.greenLight(Constants.FREEZE, Constants.FREEZE);
        pewPewDNM.setFlySpeed(Constants.FREEZE);
    }

}
