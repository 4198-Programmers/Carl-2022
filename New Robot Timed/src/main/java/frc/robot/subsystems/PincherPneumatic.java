package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PincherPneumatic extends SubsystemBase {

    Compressor pincherPneumaticCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    DoubleSolenoid pincherPneumaticDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    public void PincherPneumaticPressurize() {
        pincherPneumaticCompressor.enableDigital();
    }

    public void pincerSolenoidActivate(Value togglemode) {
        pincherPneumaticDoubleSolenoid.set(togglemode);
    }

}
