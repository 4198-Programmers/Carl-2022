package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.Constants;
import frc.robot.Commands.DriveCommand;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Commands.AutoDrive;


public class RobotContainer {
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_THING_ID);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_THING_ID);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_THING_ID);

  // subsystems
  Drivetrain drivetrain;
  // ungrouped commands
  AutoDrive autoDrive = new AutoDrive(4, drivetrain);
  // command groups

  //Buttons
  JoystickButton autoButton = new JoystickButton(leftJoystick, Constants.AUTO_BUTTON_ID);
  // others
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
    drivetrain.setDefaultCommand(new DriveCommand(()->leftJoystick.getRawAxis(1), ()->middleJoystick.getRawAxis(0), drivetrain));
  }

  private void configureButtonBindings() {

    autoButton.whenPressed(autoDrive);
   

}

  private void begin() {
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
