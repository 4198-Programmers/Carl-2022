package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {
Joystick leftJoystick = new Joystick(Constants.LEFT_STICK_PORT);
Joystick middleJoystick = new Joystick(Constants.MID_STICK_PORT);
Joystick rightJoystick = new Joystick(Constants.RIGHT_STICK_PORT);

  // subsystems


  // ungrouped commands

  // command groups


  //Buttons

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
        driveTrain.setDefaultCommand(new Drive(leftJoystick.getRawAxis(1), middleJoystick.getRawAxis(2), driveTrain));
  }

  private void configureButtonBindings() {

  }

  private void begin() {


  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
