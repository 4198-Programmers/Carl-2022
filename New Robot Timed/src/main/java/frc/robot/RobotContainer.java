package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
Joystick middleJoystick = new Joystick(1);
Joystick leftJoystick = new Joystick(0);
Joystick rightJoystick = new Joystick(2);

  // subsystems
SwerveDriveBase swerveDriveBase;
  // ungrouped commands
SwerveDrive swerveDrive = new SwerveDrive(trajectory, pose, kinematics, leftJoystick.getRawAxis(1), middleJoystick.getRawAxis(0), leftJoystick.getRawAxis(3), desiredRotation, outputModuleStates, swerveDriveBase);
  // command groups

  //Buttons
    //RightJoystickButtons

    //MiddleJoystickButtons

    //LeftJoystickButtons

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
