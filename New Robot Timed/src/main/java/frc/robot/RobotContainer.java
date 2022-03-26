
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DeathSpin;
import frc.robot.commands.NeoDrift;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  // Joysticks
  Joystick leftShaft = new Joystick(Constants.LEFT_SHAFT_PORT);
  Joystick middleShaft = new Joystick(Constants.MIDDLE_SHAFT_PORT);
  Joystick rightShaft = new Joystick(Constants.RIGHT_SHAFT_PORT);

  // subsystems
  DriveTrain gasGasGas = new DriveTrain();

  // commands
  NeoDrift neoDrift = new NeoDrift(gasGasGas);
  DeathSpin deathSpin = new DeathSpin(gasGasGas);

  // buttons
  JoystickButton deathSpinBTN = new JoystickButton(rightShaft, Constants.DEATH_SPIN_BUTTON);

  // other

  public RobotContainer() {

    // gasGasGas.setDefaultCommand(tokyoDrift);
    gasGasGas.setDefaultCommand(
        new RunCommand(() -> gasGasGas.tokyo(middleShaft.getRawAxis(0), leftShaft.getRawAxis(1)), gasGasGas));

    configureButtonBindings();
  }

  private void configureButtonBindings() {

    deathSpinBTN.whileActiveContinuous(deathSpin);
  }

  public Command getAutonomousCommand() {

    return neoDrift;
  }
}
