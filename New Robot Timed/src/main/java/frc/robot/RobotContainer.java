package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;



public class RobotContainer {
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);
  Joystick rightJoystick =  new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);

  // commands
  
  // buttons
  

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();
  public RobotContainer() {

  }

  public void initialize() {
    configureButtonBindings();
    begin();
    

  }

  private void configureButtonBindings() {
    
  }

  private void begin() {
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
