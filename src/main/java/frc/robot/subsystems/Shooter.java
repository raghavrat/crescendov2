package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkLimitSwitch;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final CANSparkMax leadShoot;
    private final CANSparkMax followShoot;
    private final CANSparkMax intakeMotor;

    private SparkLimitSwitch intakeLimitSwitch;
    Shooter(){
        leadShoot = new CANSparkMax(1, CANSparkLowLevel.MotorType.kBrushless);
        followShoot = new CANSparkMax(2, CANSparkLowLevel.MotorType.kBrushless);
        followShoot.follow(leadShoot);
        intakeMotor = new CANSparkMax(3, CANSparkLowLevel.MotorType.kBrushless);
        intakeLimitSwitch = intakeMotor.getForwardLimitSwitch(SparkLimitSwitch.Type.kNormallyOpen);
    }
    public void groundIntake(double speed) {
        intakeMotor.set(-speed);
    }
    public void speakShoot(double speed) {
        intakeMotor.set(-speed);
        leadShoot.set(-speed);
    }
}
