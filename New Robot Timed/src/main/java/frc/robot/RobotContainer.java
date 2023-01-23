
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.PinchIn;
import frc.robot.commands.PinchOut;
import frc.robot.subsystems.TurretRotationMotor;
import frc.robot.subsystems.PincherMotor;
import frc.robot.subsystems.TurretArmMotor;
import edu.wpi.first.wpilibj2.command.Command;

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
