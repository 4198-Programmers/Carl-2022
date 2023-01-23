
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.PinchIn;
import frc.robot.commands.PinchOut;
import frc.robot.subsystems.TurretRotationMotor;
import frc.robot.subsystems.PincherMotor;
import frc.robot.subsystems.TurretArmMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  // Joysticks
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  // subsystems
  TurretRotationMotor turretRotationMotor = new TurretRotationMotor();
  PincherMotor pincherMotor = new PincherMotor();
  TurretArmMotor turretArmMotor = new TurretArmMotor();

  // commands

  // Joystick Buttons

  JoystickButton pinchInButton = new JoystickButton(rightJoystick, Constants.PINCH_IN_BUTTON);
  JoystickButton pinchOutButton = new JoystickButton(rightJoystick, Constants.PINCH_OUT_BUTTON);
  JoystickButton turretArmUpButton = new JoystickButton(rightJoystick, Constants.TURRET_ARM_UP_BUTTON);
  JoystickButton turretArmDownButton = new JoystickButton(rightJoystick, Constants.TURRET_ARM_DOWN_BUTTON);
  JoystickButton turretRotationLeftButton = new JoystickButton(rightJoystick, Constants.TURRET_ROTATE_LEFT_BUTTON);
  JoystickButton turretRotationRightButton = new JoystickButton(rightJoystick, Constants.TURRET_ROTATE_RIGHT_BUTTON);

  // other

  public RobotContainer() {

    configureButtonBindings();

  }

  private void configureButtonBindings() {

  }

  public Command getAutonomousCommand() {

    return null;
  }
}
