package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveTrain;

public class Drive extends CommandBase{
    DriveTrain driveTrain;
    Joystick forwardJoystick;
    Joystick turningJoystick;
    public Drive(DriveTrain driveTrain, Joystick forwardJoystick, Joystick turningJoystick){
        this.driveTrain = driveTrain;
        this.forwardJoystick = forwardJoystick;
        this.turningJoystick = turningJoystick;
        addRequirements(driveTrain);
    }
    @Override
    public void execute() {
        driveTrain.greenLight(forwardJoystick.getRawAxis(0) , turningJoystick.getRawAxis(1));
    }
}
