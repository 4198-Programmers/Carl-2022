package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.BRRR;

public class MORELEGSGOBRRR extends CommandBase {
    private final BRRR ZOOMYGOBRRR;
    private boolean ENDIT;
    private double whereIGo = 40;
    public MORELEGSGOBRRR(BRRR zoomy) {
        ZOOMYGOBRRR = zoomy;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(zoomy);
      }

    public void initialize() {
        ZOOMYGOBRRR.AMNESIA();
    }

    public void execute() {
        
        double locaton = ZOOMYGOBRRR.LOCAIONCRISIS();
        double rotations = Maths.BadWheelMath(whereIGo);
        if(Math.abs(locaton) < rotations) {
            ZOOMYGOBRRR.GOGOGOBRRR(1, 0);
        }
        else {
            ZOOMYGOBRRR.GOGOGOBRRR(0, 0);
            ENDIT = true;
        }
    }

    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return ENDIT;
      }
}
