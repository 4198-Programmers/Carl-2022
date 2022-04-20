package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootingLow extends CommandBase {

    private Shooter shooter;
    double speed;

    public ShootingLow(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.shooterShoots(-0.20);
    }

    @Override
    public boolean isFinished() {
        final double tolerance = 0.01;
        double shouldBeShooting = -0.5;
        return (speed > shouldBeShooting - tolerance && speed < shouldBeShooting + tolerance);
    }

}
