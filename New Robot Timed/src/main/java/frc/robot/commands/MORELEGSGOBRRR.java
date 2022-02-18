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

    @Override
    public void initialize() {
        ZOOMYGOBRRR.AMNESIA();
    }

    @Override
    public void execute() {

        double locaton = ZOOMYGOBRRR.SOLVELOCAIONCRISIS();
        double rotations = Maths.BadWheelMath(whereIGo);
        if (Math.abs(locaton) < rotations) {
            ZOOMYGOBRRR.GOGOGOBRRR(0.5, 0);
        } else {
            ZOOMYGOBRRR.GOGOGOBRRR(0, 0);
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
