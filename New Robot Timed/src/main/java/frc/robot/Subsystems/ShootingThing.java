package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class ShootingThing extends SubsystemBase {

    private CANSparkMax flyWheel = new CANSparkMax(Constants.FLYWHEEL_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax intake = new CANSparkMax(Constants.INTAKE_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax tunnel = new CANSparkMax(Constants.TUNNEL_MOTOR_ID, MotorType.kBrushless);

    public void flyWheelSpeed(double speed){

        flyWheel.set(speed);

    }

    public double getFlyWheelSpeed(){
        
        return(flyWheel.get());
    }
}
