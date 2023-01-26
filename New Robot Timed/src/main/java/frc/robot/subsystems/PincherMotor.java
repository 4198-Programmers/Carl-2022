package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PincherMotor extends SubsystemBase {

    private TalonSRX pincherMotor = new TalonSRX(Constants.PINCHER_MOTOR_ID);


    public void pincherMotorActivate(double speed) {
        pincherMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }

}
