package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.BRRR;

public class MORELEGSGOBZZZ extends CommandBase{
    private final BRRR ZOOMYGOBZZZ;
    private boolean ENDIT;
    private double whereIGo = 40;
    public MORELEGSGOBZZZ(BRRR zoomy) {
        ZOOMYGOBZZZ = zoomy;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(zoomy);
      }

    public void initialize() {
        ZOOMYGOBZZZ.AMNESIA();
    }

    public void execute() {
        
        double locaton = ZOOMYGOBZZZ.LOCAIONCRISIS();
        double rotations = Maths.BadWheelMath(whereIGo);
        if(Math.abs(locaton) < rotations) {
            ZOOMYGOBZZZ.GOGOGOBZZZ(0, 1);
        }
        else {
            ZOOMYGOBZZZ.GOGOGOBZZZ(0, 0);
            ENDIT = true;
        }
    }

    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return ENDIT;
      }
}
