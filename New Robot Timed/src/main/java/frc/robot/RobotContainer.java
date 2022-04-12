
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.Consumption;
import frc.robot.commands.Digestion;
import frc.robot.commands.Indigestion;
import frc.robot.commands.MoveLadderHooksBackwards;
import frc.robot.commands.MoveLadderHooksForward;
import frc.robot.commands.MoveRampHooksBackwards;
import frc.robot.commands.MoveRampHooksForward;
import frc.robot.commands.NeoDrift;
import frc.robot.commands.Regurgitation;
import frc.robot.commands.Shooting;
import frc.robot.commands.TokyoDrift;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LadderHooks;
import frc.robot.subsystems.Mouth;
import frc.robot.subsystems.Organs;
import frc.robot.subsystems.RampHooks;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  // Joysticks
  Joystick leftShaft = new Joystick(Constants.LEFT_SHAFT_PORT);
  Joystick middleShaft = new Joystick(Constants.MIDDLE_SHAFT_PORT);
  Joystick rightShaft = new Joystick(Constants.RIGHT_SHAFT_PORT);

  // subsystems
  DriveTrain gasGasGas = new DriveTrain();
  Shooter ripple = new Shooter();
  Organs internals = new Organs();
  LadderHooks upwards = new LadderHooks();
  RampHooks onwards = new RampHooks();
  Mouth consumer = new Mouth();

  // commands
  TokyoDrift tokyoDrift = new TokyoDrift(leftShaft.getRawAxis(1), middleShaft.getRawAxis(0), gasGasGas);
  NeoDrift neoDrift = new NeoDrift(gasGasGas);
  Shooting shooting = new Shooting(ripple);
  Digestion digestion = new Digestion(internals);
  Indigestion indigestion = new Indigestion(internals);
  MoveLadderHooksForward moveLadderHooksForward = new MoveLadderHooksForward(upwards);
  MoveLadderHooksBackwards moveLadderHooksBackwards = new MoveLadderHooksBackwards(upwards);
  Consumption consumption = new Consumption(consumer);
  Regurgitation regurgitation = new Regurgitation(consumer);
  MoveRampHooksForward moveRampHooksForward = new MoveRampHooksForward(onwards);
  MoveRampHooksBackwards moveRampHooksBackwards = new MoveRampHooksBackwards(onwards);

  // buttons
  JoystickButton shootingButton = new JoystickButton(rightShaft, Constants.SHOOTING_BUTTON);
  JoystickButton overrideButton = new JoystickButton(rightShaft, Constants.OVERRIDE_BUTTON);
  JoystickButton digestionButton = new JoystickButton(rightShaft, Constants.DIGESTION_BUTTON);
  JoystickButton indigestionButton = new JoystickButton(rightShaft, Constants.INDIGESTION_BUTTON);
  JoystickButton mouthButton = new JoystickButton(rightShaft, Constants.MOUTH_BUTTON);
  JoystickButton ladderHooksButton = new JoystickButton(rightShaft, Constants.LADDER_HOOKS_BUTTON);
  JoystickButton rampHooksButton = new JoystickButton(rightShaft, Constants.RAMP_HOOKS_BUTTON);

  // other

  public RobotContainer() {

    gasGasGas.setDefaultCommand(tokyoDrift);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    shootingButton.whileActiveContinuous(shooting);
    digestionButton.whileActiveContinuous(digestion);
    indigestionButton.whileActiveContinuous(indigestion);
    mouthButton.whileActiveContinuous(consumption);
    mouthButton.and(overrideButton).whileActiveContinuous(regurgitation);
    ladderHooksButton.whileActiveContinuous(moveLadderHooksForward);
    ladderHooksButton.and(overrideButton).whileActiveContinuous(moveLadderHooksBackwards);
    rampHooksButton.whileActiveContinuous(moveRampHooksForward);
    rampHooksButton.and(overrideButton).whileActiveContinuous(moveRampHooksBackwards);
  }

  public Command getAutonomousCommand() {

    return neoDrift;
  }
}
