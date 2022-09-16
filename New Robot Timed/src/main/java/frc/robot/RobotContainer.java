package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.simpleCommands.Drive;
import frc.robot.simpleCommands.ShooterSystemCommands.ForwardIntakeSpeed;
import frc.robot.simpleCommands.ShooterSystemCommands.ReverseIntakeSpeed;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tunnel;


public class RobotContainer {
Joystick leftJoystick = new Joystick(Constants.LEFT_STICK_PORT);
Joystick middleJoystick = new Joystick(Constants.MID_STICK_PORT);
Joystick rightJoystick = new Joystick(Constants.RIGHT_STICK_PORT);

  // subsystems
DriveTrain drivetrain = new DriveTrain();
Intake intake = new Intake();
Tunnel tunnel = new Tunnel();
  // ungrouped commands

  // command groups
ForwardIntakeSpeed forwardIntakeSpeed = new ForwardIntakeSpeed(intake);
ReverseIntakeSpeed reverseIntakeSpeed = new ReverseIntakeSpeed(intake);

  //Buttons
JoystickButton intakeInButton = new JoystickButton(rightJoystick, Constants.INTAKE_IN_RBUTTON);
JoystickButton intakeOutButton = new JoystickButton(rightJoystick, Constants.INTAKE_OUT_RBUTTON);
  // other
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public void initialize() {
    configureButtonBindings();
    begin();
        drivetrain.setDefaultCommand(new Drive(
                  ()->leftJoystick.getRawAxis(0), 
                  ()-> middleJoystick.getRawAxis(1), 
                  drivetrain));
  }

  private void configureButtonBindings() {
intakeInButton.whenHeld(forwardIntakeSpeed);
intakeOutButton.whenHeld(reverseIntakeSpeed);
  }

  private void begin() {


  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

}
