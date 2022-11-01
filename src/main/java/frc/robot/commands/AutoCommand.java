package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Maths;
import frc.robot.subsystems.DriveTrain;

public class AutoCommand extends CommandBase{
    private DriveTrain driveTrain;
    private boolean complete = false;
    public AutoCommand(DriveTrain driveTrain){
        this.driveTrain = driveTrain;

    }

    @Override
    public void execute() {
        double position = Math.abs(driveTrain.findposition());
        double maxRotations = Maths.rotationConversion(50);
        if (position < maxRotations){
            driveTrain.drive(0, -1);
            
        } else {
            driveTrain.drive(0, 0);
            complete = true;
        }

    }
 
    @Override
    public boolean isFinished() {
        return complete;
    }
}
