package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.Subsystems.DriveTrain;
import frc.Subsystems.Hooks;
import frc.robot.Commands.Drive;
import frc.robot.Commands.VerticalHooksMove;


public class RobotContainer {
  Joystick rightJoystick =  new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  // subsystems
  DriveTrain driveTrain;
  Hooks hooks;
  // commands
  Drive drive =  new Drive(driveTrain, leftJoystick , leftJoystick);
  VerticalHooksMove verticalHooksMove = new VerticalHooksMove(hooks, rightJoystick);
  // buttons


  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureButtonBindings();
    begin();
    driveTrain.setDefaultCommand(new Drive(driveTrain, leftJoystick, leftJoystick));
    hooks.setDefaultCommand(new VerticalHooksMove(hooks, rightJoystick));
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
