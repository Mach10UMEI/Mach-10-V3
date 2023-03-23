// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.ClawOpen;
import frc.robot.commands.ClawClose;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.*;

import frc.robot.commands.*;

// // NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// // information, see:
// // https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto3_Ground_Junction_Lip extends SequentialCommandGroup {
 /** Creates a new Auto1. */
  public Auto3_Ground_Junction_Lip() {

    addCommands(
      new ClawClose(),
      new ConeGroundJunctionAuto(),
      new Delay(1.5),
      new ClawOpen(),
      new HomePositionAuto(),
      new DriveAutoSlowBackwards(88)    
     
    );
  }
}
