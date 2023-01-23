
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.PinchIn;
import frc.robot.commands.PinchOut;
import frc.robot.commands.PincherPneumaticPinchIn;
import frc.robot.commands.PincherPneumaticPinchOut;
import frc.robot.commands.TurretArmDown;
import frc.robot.commands.TurretArmUp;
import frc.robot.commands.TurretRotateLeft;
import frc.robot.commands.TurretRotateRight;
import frc.robot.subsystems.TurretRotationMotor;
import frc.robot.subsystems.PincherMotor;
import frc.robot.subsystems.PincherPneumatic;
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
  PincherPneumatic pincherPneumatic = new PincherPneumatic();

  // commands
  PinchIn pinchIn = new PinchIn(pincherMotor);
  PinchOut pinchOut = new PinchOut(pincherMotor);
  TurretArmDown turretArmDown = new TurretArmDown(turretArmMotor);
  TurretArmUp turretArmUp = new TurretArmUp(turretArmMotor);
  TurretRotateLeft turretRotateLeft = new TurretRotateLeft(turretRotationMotor);
  TurretRotateRight turretRotateRight = new TurretRotateRight(turretRotationMotor);
  PincherPneumaticPinchIn pincherPneumaticPinchIn = new PincherPneumaticPinchIn(pincherPneumatic);
  PincherPneumaticPinchOut pincherPneumaticPinchOut = new PincherPneumaticPinchOut(pincherPneumatic);

  // Joystick Buttons
  JoystickButton pinchInButton = new JoystickButton(rightJoystick, Constants.PINCH_IN_BUTTON);
  JoystickButton pinchOutButton = new JoystickButton(rightJoystick, Constants.PINCH_OUT_BUTTON);
  JoystickButton turretArmUpButton = new JoystickButton(rightJoystick, Constants.TURRET_ARM_UP_BUTTON);
  JoystickButton turretArmDownButton = new JoystickButton(rightJoystick, Constants.TURRET_ARM_DOWN_BUTTON);
  JoystickButton turretRotateLeftButton = new JoystickButton(rightJoystick, Constants.TURRET_ROTATE_LEFT_BUTTON);
  JoystickButton turretRotateRightButton = new JoystickButton(rightJoystick, Constants.TURRET_ROTATE_RIGHT_BUTTON);
  JoystickButton pincherPneumaticInButton = new JoystickButton(rightJoystick,
      Constants.PINCHER_PNEUMATIC_PINCH_IN_BUTTON);
  JoystickButton pincherPneumaticOutButton = new JoystickButton(rightJoystick,
      Constants.PINCHER_PNEUMATIC_PINCH_OUT_BUTTON);

  // other

  public RobotContainer() {

    configureButtonBindings();

  }

  private void configureButtonBindings() {

    pinchInButton.whileActiveContinuous(pinchIn);
    pinchOutButton.whileActiveContinuous(pinchOut);
    turretArmUpButton.whileActiveContinuous(turretArmUp);
    turretArmDownButton.whileActiveContinuous(turretArmDown);
    turretRotateRightButton.whileActiveContinuous(turretRotateRight);
    turretRotateLeftButton.whileActiveContinuous(turretRotateLeft);
    pincherPneumaticInButton.whileActiveContinuous(pincherPneumaticPinchIn);
    pincherPneumaticOutButton.whileActiveContinuous(pincherPneumaticPinchOut);

  }

  public Command getAutonomousCommand() {

    return null;
  }
}
