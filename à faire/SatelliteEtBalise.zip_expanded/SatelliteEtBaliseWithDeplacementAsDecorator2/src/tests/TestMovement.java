package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import model.Beacon;
import model.ManagerBis;
import model.Memory;
import movementStrategy.AscendMovement;
import movementStrategy.DiveMovement;
import movementStrategy.HorizontalMovement;
import movementStrategy.Movement;
import movementStrategy.SinusoidaleMovement;
import movementStrategy.VerticalMovement;

class TestMovement
{

  @Test
  void testHorizontalMovement()
  {
    String bal = "bal";
    Memory memory = new Memory(100);
    Beacon beacon = new Beacon(memory);
    beacon.setStandartDeepness(150);
    Movement movement = new HorizontalMovement(1, 0, 10);
    beacon.setMovement(movement);
    beacon.setCollectMovement(movement);
    ManagerBis.getInstance().addBeacon(bal, beacon);
    ManagerBis.getInstance().tick();
    assertEquals(1, beacon.getPosition().x);

  }

  @Test
  void testVerticalMovement()
  {
    String bal = "bal";
    Memory memory = new Memory(100);
    Beacon beacon = new Beacon(memory);
    beacon.setStandartDeepness(150);
    Movement movement = new VerticalMovement(1, 0, 10);
    beacon.setMovement(movement);
    beacon.setCollectMovement(movement);
    ManagerBis.getInstance().addBeacon(bal, beacon);
    ManagerBis.getInstance().tick();
    assertEquals(1, beacon.getPosition().y);

  }

  @Test
  void testSinusoidaleMovement()
  {
    String bal = "bal";
    Memory memory = new Memory(100);
    Beacon beacon = new Beacon(memory);
    beacon.setStandartDeepness(150);
    Movement movement = new SinusoidaleMovement(1, 10, 30, 10, 30);
    beacon.setMovement(movement);
    beacon.setCollectMovement(movement);
    ManagerBis.getInstance().addBeacon(bal, beacon);
    ManagerBis.getInstance().tick();
    assertEquals(1, beacon.getPosition().x);
    assertEquals(20, beacon.getPosition().y);

  }

  @Test
  void testAscendMovement()
  {
    String bal = "bal";
    Memory memory = new Memory(100);
    Beacon beacon = new Beacon(memory);
    beacon.setPosition(new Point(10, 10));
    beacon.setStandartDeepness(150);
    Movement movement = new AscendMovement(1);
    beacon.setMovement(movement);
    beacon.setCollectMovement(movement);
    ManagerBis.getInstance().addBeacon(bal, beacon);
    ManagerBis.getInstance().tick();
    assertEquals(9, beacon.getPosition().y);
  }

  @Test
  void testDiveMovement()
  {
    String bal = "bal";
    Memory memory = new Memory(100);
    Beacon beacon = new Beacon(memory);
    beacon.setStandartDeepness(150);
    Movement movement = new DiveMovement(1, 5);
    beacon.setMovement(movement);
    beacon.setCollectMovement(movement);
    ManagerBis.getInstance().addBeacon(bal, beacon);
    ManagerBis.getInstance().tick();
    assertEquals(1, beacon.getPosition().y);
    for (int i = 0; i <= 4; i++)
    {
      ManagerBis.getInstance().tick();
    }
    assertEquals(5, beacon.getPosition().y);

  }

}
