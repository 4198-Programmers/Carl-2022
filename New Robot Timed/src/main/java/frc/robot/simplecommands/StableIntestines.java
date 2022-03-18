package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyAndSensors;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;

public class StableIntestines extends CommandBase {
    private FlyAndSensors pewPewSI;
    private Tunnel tunnel;
    private Intake intake;

    public StableIntestines(FlyAndSensors pewPewArg, Tunnel tunnelArg, Intake intakeArg) {
        pewPewSI = pewPewArg;
        tunnel = tunnelArg;
        intake = intakeArg;
        addRequirements(pewPewArg, tunnel, intake);
    }

    @Override
    public void execute() {
        pewPewSI.setFlySpeed(Constants.FREEZE);
        intake.setIntakeSpeed(Constants.FREEZE);
        tunnel.setMoverSpeed(Constants.FREEZE);
    }
}
