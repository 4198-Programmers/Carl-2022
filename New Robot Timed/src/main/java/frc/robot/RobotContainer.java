package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {


  // subsystems

  
  // ungrouped commands
  


  // command groups
//RunCommand drivesticks = new RunCommand(()-> drivetrain.driveBoy(middleJoystick.getRawAxis(0), leftJoystick.getRawAxis(1)), drivetrain);
  //Buttons
  
  
  // others
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
  }

  private void configureButtonBindings() {

}

  private void begin() {
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
