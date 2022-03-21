package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
    Joystick forward;
    Joystick turn;
    DriveTrain robotPosition;

    public Drive(Joystick forward, Joystick turn, DriveTrain vroomVroom){
        this.forward = forward;
        this.turn = turn;
        robotPosition = vroomVroom;
        addRequirements(robotPosition);
    }
    // @Override
    // public void initialize() {
    //     robotPosition.resetPosition();
    // }
    @Override
    public void execute() {
        robotPosition.greenLight(forward.getRawAxis(0), turn.getRawAxis(1));
    }
}
