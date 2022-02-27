package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class NeoDrift extends CommandBase {

    boolean complete;
    private DriveTrain neoYokio;

    public NeoDrift(DriveTrain NeoYokio) {

        this.neoYokio = NeoYokio;
        addRequirements(neoYokio);
    }

    @Override
    public void initialize() {
        complete = false;
    }

    @Override
    public void execute() {

        double rotations = Maths.rotationConversion(11);
        double position = neoYokio.whereAmI();
        System.out.println("trying to go" + rotations);

        if(Math.abs(rotations) > Math.abs(position)){

            neoYokio.tokyo(0, -1);
        }
        else {
            neoYokio.tokyo(0, 0);
            complete = true;
            neoYokio.resetPosition();
            System.out.println(complete);
        }
    }

    @Override
    public boolean isFinished() {
        return complete;
    }
}
