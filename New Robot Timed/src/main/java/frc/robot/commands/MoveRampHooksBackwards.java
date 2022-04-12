package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RampHooks;

public class MoveRampHooksBackwards extends CommandBase {

    private RampHooks rampHooks;

    public MoveRampHooksBackwards(RampHooks rampHooks) {
        this.rampHooks = rampHooks;
        addRequirements(rampHooks);
    }

    @Override
    public void initialize() {
        rampHooks.resetTheRampHooks();
    }

    @Override
    public void execute() {
        rampHooks.rampHooksGoFast(-0.5);
    }

}
