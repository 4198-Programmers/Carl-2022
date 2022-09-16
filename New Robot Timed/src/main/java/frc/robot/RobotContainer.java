package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.simpleCommands.Drive;
import frc.robot.simpleCommands.HookCommands.AngledHookSpeed;
import frc.robot.simpleCommands.HookCommands.VerticalHooksSpeed;
import frc.robot.simpleCommands.ShooterSystemCommands.ForwardIntakeSpeed;
import frc.robot.simpleCommands.ShooterSystemCommands.ForwardTunnelSpeed;
import frc.robot.simpleCommands.ShooterSystemCommands.ReverseIntakeSpeed;
import frc.robot.simpleCommands.ShooterSystemCommands.ReverseTunnelSpeed;
import frc.robot.simpleCommands.ShooterSystemCommands.SetFlyWheelSpeed;
import frc.robot.subsystems.AngledHooks;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;
import frc.robot.subsystems.VerticalHooks;


public class RobotContainer {
Joystick leftJoystick = new Joystick(Constants.LEFT_STICK_PORT);
Joystick middleJoystick = new Joystick(Constants.MID_STICK_PORT);
Joystick rightJoystick = new Joystick(Constants.RIGHT_STICK_PORT);

  // subsystems
DriveTrain drivetrain = new DriveTrain();
Intake intake = new Intake();
Tunnel tunnel = new Tunnel();
FlyWheel flyWheel = new FlyWheel();
AngledHooks angledHooks = new AngledHooks();
VerticalHooks verticalHooks = new VerticalHooks();
  // ungrouped commands

  // command groups
ForwardIntakeSpeed forwardIntakeSpeed = new ForwardIntakeSpeed(intake);
ReverseIntakeSpeed reverseIntakeSpeed = new ReverseIntakeSpeed(intake);
ForwardTunnelSpeed forwardTunnelSpeed = new ForwardTunnelSpeed(tunnel);
ReverseTunnelSpeed reverseTunnelSpeed = new ReverseTunnelSpeed(tunnel);
SetFlyWheelSpeed setFlyWheelSpeed = new SetFlyWheelSpeed(flyWheel);
AngledHookSpeed angledHookSpeed = new AngledHookSpeed(angledHooks, ()->rightJoystick.getRawAxis(1));

  //Buttons
JoystickButton intakeInButton = new JoystickButton(rightJoystick, Constants.INTAKE_IN_RBUTTON);
JoystickButton intakeOutButton = new JoystickButton(rightJoystick, Constants.INTAKE_OUT_RBUTTON);
JoystickButton tunnelInButton = new JoystickButton(rightJoystick, Constants.INTERNAL_MOVER_FORWARDS_RBUTTON);
JoystickButton tunnelOutButton = new JoystickButton(rightJoystick, Constants.INTERNAL_MOVER_BACKWARDS_RBUTTON);
JoystickButton flyWheelButton = new JoystickButton(rightJoystick, Constants.FLYWHEEL_RBUTTON);
JoystickButton angledButton = new JoystickButton(rightJoystick, Constants.ANGLED_BUTTON);
JoystickButton verticalButton = new JoystickButton(middleJoystick, Constants.VERTICAL_HOOK_BUTTON);
  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
  }

  private void configureButtonBindings() {
intakeInButton.whenHeld(forwardIntakeSpeed);
intakeOutButton.whenHeld(reverseIntakeSpeed);
tunnelInButton.whenHeld(forwardTunnelSpeed);
tunnelOutButton.whenHeld(reverseTunnelSpeed);
flyWheelButton.whenHeld(setFlyWheelSpeed);
angledButton.whileHeld(new AngledHookSpeed(angledHooks, ()->rightJoystick.getRawAxis(1)));
verticalButton.whenHeld(new VerticalHooksSpeed(verticalHooks, ()-> middleJoystick.getRawAxis(0)));
verticalButton.whenInactive(new Drive(
  ()->leftJoystick.getRawAxis(0), 
  ()->middleJoystick.getRawAxis(1), 
  drivetrain));
}

  private void begin() {


  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
