package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BRRR;

public class MORELEGSGONOMORE extends CommandBase {
    private final BRRR ZOOMYGONOMORE;
    private boolean ENDIT;

    public MORELEGSGONOMORE(BRRR zoomy) {
        ZOOMYGONOMORE = zoomy;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(zoomy);
    }

    @Override
    public void initialize() {
        ZOOMYGONOMORE.AMNESIA();
    }

    @Override
    public void execute() {
        ZOOMYGONOMORE.GOGOGOBRRR(0, 0);
        ENDIT = true;
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return ENDIT;
    }
}
