package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.DriveTrain;
import frc.robot.Shooter;

public class TaxiAndShoot extends CommandBase {
    /**still vroomVroom from robot, just used in this class(TAS)*/
    private DriveTrain vroomVroomTAS;
    private Shooter pewPewTAS;
    private OffTarmac runOffTarmac;
    private DoNotMove stopEverything;

    private AutoState currentState = AutoState.Idle;

    public TaxiAndShoot(DriveTrain driveTrainArg, Shooter shooterArg)
    {
        vroomVroomTAS = driveTrainArg;
        pewPewTAS = shooterArg;
        runOffTarmac = new OffTarmac(vroomVroomTAS);
        stopEverything = new DoNotMove(vroomVroomTAS, pewPewTAS);
    }

    enum AutoState {
        Idle,
        MoveSpinup,
        Aim,
        Shoot,
        Stop,

    }



    @Override
    public void initialize()
    {
        currentState = AutoState.Idle;
        runOffTarmac.initialize();
    }

    @Override
    public void execute()
    {
        switch(currentState)
        {
            case Idle:
            vroomVroomTAS.resetPosition();
            currentState = AutoState.MoveSpinup;
 
            break;

            case MoveSpinup:
            pewPewTAS.setFlySpeed(0.85);
            runOffTarmac.execute();
            if(runOffTarmac.isFinished()){
            currentState = AutoState.Aim;
            }
            break;

            case Aim:
            //limelight stuff
            break;

            case Shoot:
            break;

            case Stop:
            stopEverything.execute();
            break;

            default:
            currentState = AutoState.Stop;
            break;

        }
    }
    
}
