package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TokyoDrift extends CommandBase {

    double straightLine;
    double sideToSide;

    private DriveTrain runningInThe90s;

    public TokyoDrift(double straightLine, double sideToSide, DriveTrain runningInThe90s) {

        this.straightLine = straightLine;
        this.sideToSide = sideToSide;

        this.runningInThe90s = runningInThe90s;
        addRequirements(runningInThe90s);

    }

    @Override
    public void execute() {
        runningInThe90s.tokyo(sideToSide, straightLine);
    }

}
