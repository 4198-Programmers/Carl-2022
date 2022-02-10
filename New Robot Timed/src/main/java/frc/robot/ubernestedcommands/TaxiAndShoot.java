package frc.robot.ubernestedcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.simplecommands.DoNotMove;
import frc.robot.simplecommands.OffTarmac;
import frc.robot.simplecommands.PickLimelightMode;
import frc.robot.simplecommands.SetFlySpeed;
import frc.robot.simplecommands.SetInternalMoveSpeed;
import frc.robot.simplecommands.Targeting;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShooterPathMovement;

public class TaxiAndShoot extends CommandBase {
    /** still vroomVroom from robot, just used in this class(TAS) **/
    private DriveTrain vroomVroomTAS;
    private ShooterPathMovement pewPewTAS;
    private OffTarmac runOffTarmac;
    private DoNotMove stopEverything;
    private Limelight visionTAS;
    private PickLimelightMode limelightMode;
    private Targeting targeting;
    private SetFlySpeed setFlySpeed;
    private SetInternalMoveSpeed setInternalMoveSpeed;

    private AutoState currentState = AutoState.Idle;

    /**
     * Pulls in the current DriveTrain and Shooter instances to use in the specific
     * class
     **/
    public TaxiAndShoot(DriveTrain driveTrainArg, ShooterPathMovement shooterArg, Limelight limelightArg) {
        vroomVroomTAS = driveTrainArg;
        pewPewTAS = shooterArg;
        visionTAS = limelightArg;

        runOffTarmac = new OffTarmac(vroomVroomTAS);
        stopEverything = new DoNotMove(vroomVroomTAS, pewPewTAS);
        limelightMode = new PickLimelightMode(visionTAS, Constants.LIMELIGHT_FULL_ON_PIPELINE_MODE);
        targeting = new Targeting(vroomVroomTAS, visionTAS);
        setFlySpeed = new SetFlySpeed(pewPewTAS);
        setInternalMoveSpeed = new SetInternalMoveSpeed(pewPewTAS);

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
        runOffTarmac.initialize();
        currentState = AutoState.Idle;
    }

    @Override
    public void execute() {
        switch (currentState) {
            case Idle:
                vroomVroomTAS.resetPosition();
                currentState = AutoState.MoveSpinup;

                break;

            case MoveSpinup:
                setFlySpeed.execute(); // TODO should be using calculation
                runOffTarmac.execute();
                if (runOffTarmac.isFinished()) {
                    currentState = AutoState.Aim;
                }
                break;

            case Aim:
                limelightMode.execute();
                if (limelightMode.isFinished()) {
                    targeting.execute();
                    if (targeting.isFinished()) {
                        currentState = AutoState.Shoot;
                    }
                }
                break;

            case Shoot:
                setInternalMoveSpeed.execute();
                //sensor for if ball leaves TODO sensor?????
                currentState = AutoState.Stop;
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