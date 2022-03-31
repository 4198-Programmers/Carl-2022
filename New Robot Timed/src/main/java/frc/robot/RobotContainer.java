package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drive;
import frc.robot.commands.SetFlyWheelSpeed;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FlyWheel;


public class RobotContainer {
  Joystick leftStick = new Joystick(Constants.LEFT_JOYSTICK_PORT);
  Joystick middleStick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  // subsystems
  DriveTrain driveTrain;
  FlyWheel flyWheel;
  // commands
  Drive drive = new Drive(driveTrain, () -> leftStick.getRawAxis(0), () -> middleStick.getRawAxis(1));
  SetFlyWheelSpeed setFlyWheelSpeed = new SetFlyWheelSpeed(flyWheel, () -> middleStick.getRawAxis(3));
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
    JoystickButton shooterButton = new JoystickButton(middleStick, Constants.SHOOTER_BUTTON);
    
  }

  private void begin() {
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
