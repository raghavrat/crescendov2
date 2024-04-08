package frc.robot.commands.IntakeShoot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class SpeakerShoot extends Command {
    Shooter shooter;
    double speed;
    public SpeakerShoot(Shooter shooter) {
        addRequirements(shooter);
        this.shooter = shooter;
    }

    @Override
    public void initialize() {
        speed = 1;
        shooter.setIntakeLimitSwitch(false);
    }

    @Override
    public void execute() {
        shooter.speakShoot(0.5);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.speakShoot(0);
    }
}
