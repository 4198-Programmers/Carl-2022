package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootingHigh extends CommandBase {

    private Shooter shooter;
    double speed;

    public ShootingHigh(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.shooterShoots(-0.50);
    }

    @Override
    public boolean isFinished() {
        final double tolerance = 0.01;
        double shouldBeShooting = -0.5;
        return (speed > shouldBeShooting - tolerance && speed < shouldBeShooting + tolerance);
    }

}