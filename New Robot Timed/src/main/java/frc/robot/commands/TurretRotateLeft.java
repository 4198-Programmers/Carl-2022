package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretRotationMotor;

public class TurretRotateLeft extends CommandBase {

    private TurretRotationMotor turretRotationMotor;

    public TurretRotateLeft(TurretRotationMotor turretRotationMotor) {

        this.turretRotationMotor = turretRotationMotor;
        addRequirements(turretRotationMotor);

    }

    @Override
    public void execute() {
        turretRotationMotor.turretRotationMotorActivate(-0.5);
    }

}