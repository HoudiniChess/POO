package graphicLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GSpace extends JPanel implements GContainer, KeyListener, MouseListener
{
  private static final long serialVersionUID = 1L;
  private List<GElement> elements = new LinkedList<GElement>();
  private List<KeyListener> keyListeners = new LinkedList<KeyListener>();

  String name = "";

  public GSpace(String name, Dimension dim)
  {
    this.name = name;
    super.addKeyListener(this);
    super.addMouseListener(this);
    this.setPreferredSize(dim);
  }

  public List<GElement> contents()
  {
    return elements;
  }

  public void changeWindowSize(Dimension dim)
  {
    this.setPreferredSize(dim);
    JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
    frame.pack();
  }

  public void open()
  {
    JFrame frame = new JFrame(name);
    WindowAdapter wa = new WindowAdapter()
    {
      @Override
      public void windowClosing(WindowEvent e)
      {
        System.exit(0);
      }
    };
    frame.addWindowListener(wa);
    frame.getContentPane().add(this);
    frame.pack();
    frame.setVisible(true);
    requestFocus();
  }

  @Override
  public void addElement(GElement d)
  {
    elements.add(d);
    d.setContainer(this);
  }

  @Override
  public void removeElement(GElement d)
  {
    elements.remove(d);
    d.setContainer(null);
  }

  public void setColor(Color c)
  {
    setBackground(c);
  }

  @Override
  public void paint(Graphics g)
  {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLUE);
    g2d.fill3DRect(0, 150, 800, 450, true);
    g2d.setColor(Color.GRAY);
    g2d.fill3DRect(0, 0, 800, 150, true);
    GElement[] elems = elements.toArray(new GElement[elements.size()]);
    for (int n = 0; n < elems.length; n++)
    {
      elems[n].draw(g2d);
    }
  }

  @Override
  public void addKeyListener(KeyListener k)
  {
    keyListeners.add(k);
  }

  @Override
  public void clear()
  {
    for (Iterator<GElement> iter = elements.iterator(); iter.hasNext();)
    {
      iter.next().setContainer(null);
    }
    elements.clear();
  }

  @Override
  public void keyTyped(KeyEvent e)
  {
    for (Iterator<KeyListener> iter = keyListeners.iterator(); iter.hasNext();)
    {
      KeyListener keyListener = iter.next();
      keyListener.keyTyped(e);
    }
  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    for (Iterator<KeyListener> iter = keyListeners.iterator(); iter.hasNext();)
    {
      KeyListener keyListener = iter.next();
      keyListener.keyPressed(e);
    }
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    for (Iterator<KeyListener> iter = keyListeners.iterator(); iter.hasNext();)
    {
      KeyListener keyListener = iter.next();
      keyListener.keyReleased(e);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e)
  {
    for (Iterator<GElement> iter = elements.iterator(); iter.hasNext();)
    {
      GElement element = iter.next();
      element.dispatchMouseClicked(e);
    }
  }

  @Override
  public void mousePressed(MouseEvent e)
  {
    for (Iterator<GElement> iter = elements.iterator(); iter.hasNext();)
    {
      GElement element = iter.next();
      element.dispatchMousePressed(e);
    }
  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
    for (Iterator<GElement> iter = elements.iterator(); iter.hasNext();)
    {
      GElement element = iter.next();
      element.dispatchMouseReleased(e);
    }
  }

  @Override
  public void mouseEntered(MouseEvent e)
  {}

  @Override
  public void mouseExited(MouseEvent e)
  {}

  @Override
  public Point getGlobalPosition()
  {
    return null;
  }

  @Override
  public GElement[] getRawContents()
  {
    return elements.toArray(new GElement[elements.size()]);
  }

}