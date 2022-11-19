package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class TunnelThing extends SubsystemBase {

    private CANSparkMax tunnel = new CANSparkMax(Constants.TUNNEL_MOTOR_ID, MotorType.kBrushless);

    public void tunnelSpeed(double speed){

        tunnel.set(speed);

    }

    public double getTunnelSpeed(){

        System.out.println("Tunnel Speed:" + tunnel.get());
        return(tunnel.get());

    }
    
}
