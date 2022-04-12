package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LadderHooks;

public class MoveLadderHooksBackwards extends CommandBase {

    private LadderHooks ladderHooks;

    public MoveLadderHooksBackwards(LadderHooks ladderHooks) {

        this.ladderHooks = ladderHooks;
        addRequirements(ladderHooks);
    }

    @Override
    public void initialize() {
        ladderHooks.resetTheLadderHooks();
    }

    @Override
    public void execute() {
        ladderHooks.ladderHooksGoFast(-0.5);
    }

}