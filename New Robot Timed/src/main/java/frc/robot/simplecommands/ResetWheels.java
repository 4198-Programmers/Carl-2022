package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ResetWheels extends CommandBase{
    private DriveTrain driver;

    public ResetWheels(DriveTrain driverArg){
        driver = driverArg;
        addRequirements(driverArg);
    }
    
    @Override
    public void initialize() {
        driver.resetPosition();
    }

    @Override
    public void execute(){

    }

    @Override
    public boolean isFinished() {
        return (driver.findPosition() <= 0.025);
    }
}
