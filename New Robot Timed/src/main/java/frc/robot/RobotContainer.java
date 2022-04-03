package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drive;
import frc.robot.commands.MoveAngledHooks;
import frc.robot.commands.MoveVerticalHooks;
import frc.robot.commands.SetFlyWheelSpeed;
import frc.robot.subsystems.AngledHooks;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.Tunnel;
import frc.robot.subsystems.VerticalHooks;

public class RobotContainer {
  Joystick leftStick = new Joystick(Constants.LEFT_JOYSTICK_PORT);
  Joystick middleStick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  // subsystems
  DriveTrain driveTrain;
  FlyWheel flyWheel;
  AngledHooks angledHooks;
  VerticalHooks verticalHooks;
  Intake intake;
  Tunnel tunnel;
  Sensors sensors;
  // commands
  Drive drive = new Drive(driveTrain, () -> leftStick.getRawAxis(0), () -> middleStick.getRawAxis(1));
  SetFlyWheelSpeed setFlyWheelSpeed = new SetFlyWheelSpeed(flyWheel, () -> middleStick.getRawAxis(3));
  // buttons
  JoystickButton shooterButton = new JoystickButton(middleStick, Constants.SHOOTER_BUTTON);
  JoystickButton angledOverRideButton = new JoystickButton(middleStick, Constants.ANGLED_OVERRIDE_BUTTON);
  JoystickButton verticalOverRideButton = new JoystickButton(rightStick, Constants.VERTICAL_OVERRIDE_BUTTON);

  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {

  }

  public void initialize() {
    configureButtonBindings();
    begin();

  }

  private void configureButtonBindings() {
    shooterButton.whenHeld(new SetFlyWheelSpeed(flyWheel, () -> middleStick.getRawAxis(3)));
    angledOverRideButton.whenHeld(new MoveAngledHooks(angledHooks, () -> middleStick.getRawAxis(1)));
    angledOverRideButton
        .whenInactive(new Drive(driveTrain, () -> leftStick.getRawAxis(0), () -> middleStick.getRawAxis(1)));
    verticalOverRideButton.whenHeld(new MoveVerticalHooks(verticalHooks, () -> rightStick.getRawAxis(0)));
  }

  private void begin() {
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}