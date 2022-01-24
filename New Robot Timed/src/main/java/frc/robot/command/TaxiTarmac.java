package frc.robot.command;

import java.net.CacheResponse;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.DriveTrain;

public class TaxiTarmac extends CommandBase {
    private DriveTrain vroomVroomTT;
    private OffTarmac runOff;
    private AutoState currentState = AutoState.Idle;
    
    /**Pulls in the current DriveTrain instance to use in the specific class **/
    public TaxiTarmac(DriveTrain driveTrainArg)
    {
        vroomVroomTT = driveTrainArg;
        runOff = new OffTarmac(vroomVroomTT);
    }

    enum AutoState{
        Idle,
        Move,
        Stop
    }

    @Override
    public void initialize()
    {
        currentState = AutoState.Idle;
    }

    @Override
    public void execute()
    {
        switch(currentState)
        {
            case Idle:
            vroomVroomTT.resetPosition();
            currentState = AutoState.Move;
            break;

            case Move:
            runOff.execute();
            break;

            case Stop:
            break;

            default:
            break;

        }
    }
}
