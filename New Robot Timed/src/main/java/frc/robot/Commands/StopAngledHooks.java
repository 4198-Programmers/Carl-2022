package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.AnglesHooks;

public class StopAngledHooks extends CommandBase{
    AnglesHooks anglesHooks;
    public StopAngledHooks(AnglesHooks anglesHooks){
        this.anglesHooks = anglesHooks;

        addRequirements(anglesHooks);
    }
    @Override
    public void execute() {
        anglesHooks.angleHooksMove(0);
    }
}
