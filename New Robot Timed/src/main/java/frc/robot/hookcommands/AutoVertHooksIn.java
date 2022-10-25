package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VertHooks;

public class AutoVertHooksIn extends CommandBase{
    private VertHooks grabbers;
    private double position;
    private double limit;

    public AutoVertHooksIn(VertHooks vertHooksSub, double limit) {
        this.limit = limit;
        grabbers = vertHooksSub;
        addRequirements(grabbers);
    }

    @Override
    public void execute() {
        grabbers.moveVertHooks(-Constants.VERT_HOOK_SPEED);
        position = grabbers.vertHooksPosition();
    }

    @Override
    public boolean isFinished() {
        return position >= limit;
    }
}
