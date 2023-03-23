// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.ClawOpen;
import frc.robot.commands.ClawClose;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto4_Cube_Middle_Boogie extends SequentialCommandGroup {
  /** Creates a new Auto4_Cube_Middle_Boogie. */
  public Auto4_Cube_Middle_Boogie() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ClawClose(),
      new CubeOverRobot(),
      new Delay(0.75),
      new ClawOpen(),
      new Delay(0.5),
      new HomePositionAuto(), 
      new DriveAutoForwards(100),
      new BrakeCommand()
    );
  }
}
