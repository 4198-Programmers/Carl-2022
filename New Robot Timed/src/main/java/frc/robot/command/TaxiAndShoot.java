package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShooterPathMovement;

public class TaxiAndShoot extends CommandBase {
    /** still vroomVroom from robot, just used in this class(TAS) **/
    private DriveTrain vroomVroomTAS;
    private ShooterPathMovement pewPewTAS;
    private OffTarmac runOffTarmac;
    private DoNotMove stopEverything;

    private AutoState currentState = AutoState.Idle;

    /**
     * Pulls in the current DriveTrain and Shooter instances to use in the specific
     * class
     **/
    public TaxiAndShoot(DriveTrain driveTrainArg, ShooterPathMovement shooterArg) {
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
    public void initialize() {
        currentState = AutoState.Idle;
        runOffTarmac.initialize();
    }

    @Override
    public void execute() {
        switch (currentState) {
            case Idle:
                vroomVroomTAS.resetPosition();
                currentState = AutoState.MoveSpinup;

                break;

            case MoveSpinup:
                pewPewTAS.setFlySpeed(0.85);
                runOffTarmac.execute();
                if (runOffTarmac.isFinished()) {
                    currentState = AutoState.Aim;
                }
                break;

            case Aim:
                // limelight stuff
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
