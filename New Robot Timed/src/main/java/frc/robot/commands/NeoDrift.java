package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class NeoDrift extends CommandBase {

    boolean complete;
    double farGone;
    boolean autoResetSuccess;
    private DriveTrain neoYokio;

    public NeoDrift(DriveTrain NeoYokio) {

        this.neoYokio = NeoYokio;
        addRequirements(neoYokio);
    }

    @Override
    public void initialize() {
        System.out.println("init");
        autoResetSuccess = false;
        complete = false;
    }

    @Override
    public void execute() {

        double rotations = Maths.rotationConversion(10);
        double position = neoYokio.whereAmI();
        System.out.println("trying to go" + rotations);

        if(Math.abs(neoYokio.whereAmI()) >= 0.05 && !autoResetSuccess){
            neoYokio.resetPosition();
            System.out.println("resetting");
        }
        else if(Math.abs(neoYokio.whereAmI()) < 0.05){
        autoResetSuccess = true;
        System.out.println("Funky");
        }

        if (rotations > position && autoResetSuccess) {
            neoYokio.tokyo(0, -1);
        } 
        else {
            neoYokio.tokyo(0, 0);
            complete = true;
        }
    }

    @Override
    public boolean isFinished() {
        return complete;
    }
}
