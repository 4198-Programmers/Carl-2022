package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.DoNotMove;
import frc.robot.command.TaxiAndShoot;
import frc.robot.command.TaxiTarmac;
import frc.robot.command.hookcommands.AngledHookJoystick;
import frc.robot.command.hookcommands.MoveCloserToNinetyDegrees;
import frc.robot.command.hookcommands.MoveCloserToZeroDegrees;
import frc.robot.command.hookcommands.PullVertHooksIn;
import frc.robot.command.hookcommands.ReachVertHooksUp;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hooks;
import frc.robot.subsystems.ShooterPathMovement;

public class RobotContainer {

    private final SendableChooser<Command> m_chooser = new SendableChooser<>();

    Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT);
    Joystick midStick = new Joystick(Constants.MID_STICK_PORT);
    Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);

    // subsystems
    DriveTrain vroomVroom = new DriveTrain();
    ShooterPathMovement pewPew = new ShooterPathMovement();
    Hooks climber = new Hooks();

    // commands
    DoNotMove doNotMove = new DoNotMove(vroomVroom, pewPew);
    TaxiAndShoot taxiAndShoot = new TaxiAndShoot(vroomVroom, pewPew);
    TaxiTarmac taxiTarmac = new TaxiTarmac(vroomVroom);
    AngledHookJoystick angledHookJoystick = new AngledHookJoystick(climber, rightStick);
    ReachVertHooksUp reachHooksUp = new ReachVertHooksUp(climber);
    PullVertHooksIn pullVertHooksIn = new PullVertHooksIn(climber);
    MoveCloserToZeroDegrees moveCloserToZeroDegrees = new MoveCloserToZeroDegrees(climber);
    MoveCloserToNinetyDegrees moveCloserToNinetyDegrees = new MoveCloserToNinetyDegrees(climber);

    // buttons
    JoystickButton overrideButton = new JoystickButton(rightStick, Constants.HUMAN_OVERRIDE_BUTTON);
    JoystickButton verticalHookUp = new JoystickButton(rightStick, Constants.VERT_HOOK_UP_BUTTON);
    JoystickButton verticalHookDown = new JoystickButton(rightStick, Constants.VERT_HOOK_DOWN_BUTTON);
    JoystickButton angledHookUp = new JoystickButton(rightStick, Constants.ANGLE_HOOK_UP_BUTTON);
    JoystickButton angledHookDown = new JoystickButton(rightStick, Constants.ANGLE_HOOK_DOWN_BUTTON);

    // other

    public RobotContainer() {
        configureButtonBindings();
        begin();
        vroomVroom.setDefaultCommand(new RunCommand(
                () -> vroomVroom.greenLight(leftStick.getRawAxis(0), rightStick.getRawAxis(0)), vroomVroom));
    }

    private void configureButtonBindings() {
        overrideButton.whenHeld(angledHookJoystick);
        overrideButton.and(verticalHookUp).whileActiveContinuous(reachHooksUp);
        overrideButton.and(verticalHookDown).whileActiveContinuous(pullVertHooksIn);
        overrideButton.and(angledHookUp).whileActiveContinuous(moveCloserToNinetyDegrees);
        overrideButton.and(angledHookDown).whileActiveContinuous(moveCloserToNinetyDegrees);
    }

    private void begin() {
        m_chooser.setDefaultOption("Default Auto", doNotMove);
        m_chooser.addOption("Taxi + Shoot One", taxiAndShoot);
        m_chooser.addOption("Taxi", taxiTarmac);
        SmartDashboard.putData("Auto choices", m_chooser);
    }

    public Command getAutonomousCommand() {
        return m_chooser.getSelected();
    }
}
