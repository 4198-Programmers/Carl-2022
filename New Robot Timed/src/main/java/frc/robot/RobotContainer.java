
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.PrimaryMotorTesting;
import frc.robot.commands.SecondaryMotorTesting;
import frc.robot.subsystems.PrimaryMotor;
import frc.robot.subsystems.SecondaryMotor;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  // Joysticks
  Joystick primaryTestJoystick = new Joystick(Constants.PRIMARY_MOTOR_TEST_JOYSTICK_PORT);
  Joystick secondaryTestJoystick = new Joystick(Constants.SECONDARY_MOTOR_TEST_JOYSTICK_PORT);

  // subsystems
  PrimaryMotor primaryMotor = new PrimaryMotor();
  SecondaryMotor secondaryMotor = new SecondaryMotor();

  // commands
  PrimaryMotorTesting primaryMotorTesting = new PrimaryMotorTesting(primaryTestJoystick.getRawAxis(1), primaryMotor);
  SecondaryMotorTesting secondaryMotorTesting = new SecondaryMotorTesting(secondaryTestJoystick.getRawAxis(1),
      secondaryMotor);

  // other

  public RobotContainer() {

    configureButtonBindings();
  }

  private void configureButtonBindings() {
  }

  public Command getAutonomousCommand() {

    return primaryMotorTesting;
  }
}
