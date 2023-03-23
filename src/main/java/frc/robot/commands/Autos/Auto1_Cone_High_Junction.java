// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Delay;
import frc.robot.commands.ClawOpen;
import frc.robot.commands.ClawClose;
// import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto1_Cone_High_Junction extends SequentialCommandGroup {
  /** Creates a new Auto1. */
  public Auto1_Cone_High_Junction() {
 
    addCommands(
      new ClawClose(),
      new ConeHighJunctionAuto(),
      new Delay(1.75),//i added a comment;)
      new ClawOpen(),
      new Delay(0.5),
      new HomePositionAuto(),
      
      new DriveAutoBackwards(80)
    );
  }
}



// new ConeGrabPositionAuto(),
// new ClawClose(),
// new Delay(0.75), 