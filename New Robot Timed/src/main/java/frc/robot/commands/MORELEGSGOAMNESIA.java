package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.BRRR;

public class MORELEGSGOAMNESIA extends CommandBase{
    private final BRRR ZOOMYGOAMNESIA;
    private boolean ENDIT;

    public MORELEGSGOAMNESIA(BRRR zoomy) {
        ZOOMYGOAMNESIA = zoomy;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(zoomy);
      }

    public void initialize() {
        
    }

    public void execute() {
        ZOOMYGOAMNESIA.AMNESIA();
        ENDIT = true;
    }

    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return ENDIT;
      }
}
