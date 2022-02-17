package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
    Joystick forward;
    Joystick turning;
    DriveTrain robotPosition;
    public Drive(Joystick forwardArg, Joystick turningArg, DriveTrain robotPositionArg){
        forward = forwardArg;
        turning = turningArg;
        robotPosition = robotPositionArg;
        addRequirements(robotPosition);
    }
    @Override
    public void initialize() {
        robotPosition.resetPosition();
    }
    @Override
    public void execute() {
        robotPosition.greenLight(turning.getX(), forward.getY());
    }
}
