package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

public class Robot extends TimedRobot {
  private Command autoSelected;
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  Joystick leftStick = new Joystick(Constants.LEFT_STICK_PORT);
  Joystick midStick = new Joystick(Constants.MID_STICK_PORT);
  Joystick rightStick = new Joystick(Constants.RIGHT_STICK_PORT);

  DriveTrain vroomVroom = new DriveTrain();
  Shooter pewPew = new Shooter();

  DoNotMove doNotMove = new DoNotMove(vroomVroom, pewPew);
  TaxiAndShoot taxiAndShoot = new TaxiAndShoot(vroomVroom, pewPew);



  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", doNotMove);
    m_chooser.addOption("My Auto", taxiAndShoot);
    SmartDashboard.putData("Auto choices", m_chooser);
  }



  @Override
  public void robotPeriodic() {
  }

 

  @Override
  public void autonomousInit() {
    autoSelected = m_chooser.getSelected();
    autoSelected.initialize();

  }



  @Override
  public void autonomousPeriodic() {
    autoSelected.execute();

  }



  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    vroomVroom.greenLight(leftStick.getRawAxis(0), leftStick.getRawAxis(1));
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
