package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TaxiAndShoot extends CommandBase {
    /**still vroomVroom from robot, just used in this class(TAS)*/
    private DriveTrain vroomVroomTAS;
    private Shooter pewPewTAS;
    AutoState currentState = AutoState.Idle;
    boolean taxiFinished;

    TaxiAndShoot(DriveTrain driveTrainArg, Shooter shooterArg)
    {
        vroomVroomTAS = driveTrainArg;
        pewPewTAS = shooterArg;
    }

    enum AutoState {
        Idle,
        MoveSpinup,
        Aim,
        Shoot,
        Stop,

    }

    private double rotationConversion(double distanceInInches)
    {
        double circumference = (Math.PI*(Constants.WHEEL_DIAMTER));
        double rotations = distanceInInches/circumference;
        return rotations;
    }

    @Override
    public void initialize()
    {
            //vroomVroomTAS.frontREnc.setPosition = 0;
            taxiFinished = false;
            currentState = AutoState.Idle;

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
            double escapeTarmacInInches = 20;
            double rotations = rotationConversion(escapeTarmacInInches);
            double position = vroomVroomTAS.findPosition();
            pewPewTAS.setFlySpeed(0.85);
            
            if(position < rotations)
            {
                vroomVroomTAS.greenLight(-1, 0);
            }
            else
            {
                vroomVroomTAS.greenLight(0, 0);
                currentState = AutoState.Aim;

            }
            break;

            case Aim:
            //limelight stuff
            break;

            case Shoot:
            pewPewTAS.launchBall();
            break;

            case Stop:
            vroomVroomTAS.greenLight(0, 0);
            break;

            default:
            currentState = AutoState.Stop;
            break;

        }
    }
    
}
