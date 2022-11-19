package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
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
        System.out.println("Fly Wheel Speed:" + flyWheel.get());
        return(flyWheel.get());

    }

    public void intakeSpeed(double speed){

        intake.set(speed);

    }

    public double getIntakeSpeed(){

        System.out.println("Intake Speed:" + intake.get());
        return(intake.get());

    }

    public void tunnelSpeed(double speed){

        tunnel.set(speed);

    }

    public double getTunnelSpeed(){

        System.out.println("Tunnel Speed:" + tunnel.get());
        return(tunnel.get());

    }
}
