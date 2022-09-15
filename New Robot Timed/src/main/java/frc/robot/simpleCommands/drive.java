package frc.robot.simpleCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class drive extends CommandBase{
    driveTrain driveTrain;
    @Override
    public void execute() {
        driveTrain.drive(xspeed, zrotation);
    }
}
