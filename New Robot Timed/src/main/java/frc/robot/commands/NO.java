package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.BRRR;

public class NO extends CommandBase{
    private final BRRR ZOOMYNO;
    private boolean ENDIT;
    private double whereIGo = 40;
    public NO(BRRR zoomy) {
        ZOOMYNO = zoomy;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(zoomy);
      }

    public void initialize() {
        ZOOMYNO.AMNESIA();
    }

    public void execute() {
    ZOOMYNO.GOGOGONO(0,0);
            ENDIT = true;
        }

    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return ENDIT;
      }
}
