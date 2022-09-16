package frc.robot.simpleCommands.ShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyWheel;

public class SetFlyWheelSpeed extends CommandBase{
    FlyWheel flyWheel;
    public SetFlyWheelSpeed(FlyWheel flyWheel){
        this.flyWheel = flyWheel;
        addRequirements(flyWheel);
    }
    @Override
    public void execute() {
        flyWheel.setFlyWheelSpeed(Constants.FLYWHEEL_SPEED);
    }
    @Override
    public void end(boolean interrupted) {
        flyWheel.setFlyWheelSpeed(Constants.FREEZE);
    }
}
