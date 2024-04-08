package frc.robot.commands.IntakeShoot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class GroundIntake extends Command {
    Shooter shooter;
    double speed;
    public GroundIntake(Shooter shooter) {
        addRequirements(shooter);
        this.shooter = shooter;
    }

    @Override
    public void end(boolean interrupted) {
        shooter.startGroundIntake(0);
    }

    @Override
    public void initialize() {
        speed = 1;
        shooter.setIntakeLimitSwitch(true);
    }

    @Override
    public void execute() {
        shooter.startGroundIntake(0.5);
    }

    @Override
    public boolean isFinished() {
        return shooter.isIntakeLimitSwitchPressed();
    }
}
