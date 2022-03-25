package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.VertHooks;

public class HookStop extends CommandBase {
    private VertHooks vertHooks;
    boolean done;

    public HookStop(VertHooks vertHooksArg) {
        vertHooks = vertHooksArg;
        addRequirements(vertHooks);
    }

    @Override
    public void initialize() {
        done = false;
    }

    @Override
    public void execute() {
        vertHooks.moveVertHooks(Constants.FREEZE);
        done = true;
    }

    @Override
    public boolean isFinished() {
        return done;
    }

}
