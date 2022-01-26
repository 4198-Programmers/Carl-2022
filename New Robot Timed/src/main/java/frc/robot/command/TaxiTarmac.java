package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TaxiTarmac extends CommandBase {
    private DriveTrain vroomVroomTT;
    private OffTarmac runOff;
    private AutoState currentState = AutoState.Idle;

    public TaxiTarmac(DriveTrain driveTrainArg) {
        vroomVroomTT = driveTrainArg;
        runOff = new OffTarmac(vroomVroomTT);
    }

    enum AutoState {
        Idle,
        Move,
        Stop
    }

    @Override
    public void initialize() {
        currentState = AutoState.Idle;
    }

    @Override
    public void execute() {
        switch (currentState) {
            case Idle:
                vroomVroomTT.resetPosition();
                currentState = AutoState.Move;
                break;

            case Move:
                runOff.execute();
                break;

            case Stop:

        }
    }
}
