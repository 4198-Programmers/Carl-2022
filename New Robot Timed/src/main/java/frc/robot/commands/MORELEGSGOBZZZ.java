package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.BRRR;

public class MORELEGSGOBZZZ extends CommandBase {
    private final BRRR ZOOMYGOBZZZ;
    private boolean ENDIT;
    private double whereIGo = 40;

    public MORELEGSGOBZZZ(BRRR zoomy) {
        ZOOMYGOBZZZ = zoomy;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(zoomy);
    }

    @Override
    public void initialize() {
        ZOOMYGOBZZZ.AMNESIA();
    }

    @Override
    public void execute() {

        double locaton = ZOOMYGOBZZZ.SOLVELOCAIONCRISIS();
        double rotations = Maths.BadWheelMath(whereIGo);
        if (Math.abs(locaton) < rotations) {
            ZOOMYGOBZZZ.GOGOGOBRRR(0, 1);
        } else {
            ZOOMYGOBZZZ.GOGOGOBRRR(0, 0);
            ENDIT = true;
        }
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return ENDIT;
    }
}
