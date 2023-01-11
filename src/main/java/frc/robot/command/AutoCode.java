package frc.robot.command;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class AutoCode extends CommandBase{

    boolean complete; 
    double drivedistance; 
    private DriveTrain driveTrain; 

    public AutoCode(DriveTrain driveTrain) {

        this.driveTrain = driveTrain; 
        addRequirements(driveTrain);
    }

    @Override
    public void initialize () {

        complete = false; 
    }
    
    @Override 
    public void execute () {

        double rotation = Maths.rotationConversion(50);
        double position = driveTrain.findposition();

        if (rotation < position){
            driveTrain.drive(-1,0);
        }

        else {
            driveTrain.drive(0, 0);

            complete = true;
        }
    }

    @Override
    public boolean isFinished() {
        return complete; 
    }

}