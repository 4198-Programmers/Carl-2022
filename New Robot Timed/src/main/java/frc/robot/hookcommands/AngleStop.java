package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleHooks;

public class AngleStop extends CommandBase {
    private AngleHooks angleHooks;
    boolean done;

    @Override
    public void initialize() {
        done = false;
    }

    public AngleStop(AngleHooks angleHooksSub) {
        angleHooks = angleHooksSub;
        addRequirements(angleHooksSub);
    }

    @Override
    public void execute() {
        angleHooks.moveAngledHooks(Constants.FREEZE);
        done = true;
    }

    @Override
    public boolean isFinished() {
        return done;
    }

}
