
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.NeoDrift;
import frc.robot.commands.TokyoDrift;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  // Joysticks
  Joystick leftShaft = new Joystick(Constants.LEFT_SHAFT_PORT);
  Joystick middleShaft = new Joystick(Constants.MIDDLE_SHAFT_PORT);
  Joystick rightShaft = new Joystick(Constants.RIGHT_SHAFT_PORT);

  // subsystems
  DriveTrain gasGasGas = new DriveTrain();

  // commands
  TokyoDrift tokyoDrift = new TokyoDrift(leftShaft.getRawAxis(1), middleShaft.getRawAxis(0), gasGasGas);
  NeoDrift neoDrift = new NeoDrift(gasGasGas);

  // buttons

  // other

  public RobotContainer() {

    gasGasGas.setDefaultCommand(tokyoDrift);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
  }

  public Command getAutonomousCommand() {

    return neoDrift;
  }
}
