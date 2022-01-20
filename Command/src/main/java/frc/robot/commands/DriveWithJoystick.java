package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveWithJoystick extends CommandBase {

    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrain driver;

    public DriveWithJoystick(DriveTrain subsystem){
        driver = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {}
  
    @Override
    public void execute() {}
  
    @Override
    public void end(boolean interrupted) {}
  
    @Override
    public boolean isFinished() {
      return false;
    }
    
}
