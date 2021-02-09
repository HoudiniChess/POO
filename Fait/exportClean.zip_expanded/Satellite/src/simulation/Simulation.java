package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import graphicLayer.GSpace;
import model.Balise;
import model.DeplHorizontal;
import model.DeplVertical;

public class Simulation {

	public static void main(String[] args) {
		GSpace w = new GSpace("Satellite & Balises", new Dimension(800, 600));
		Balise balH = new Balise();
		balH.setPosition(new Point(100,400));
		balH.setDeplacement(new DeplHorizontal());
		GrBalise grBalH = new GrBalise();
		grBalH.setModel(balH);
		grBalH.setColor(Color.RED);
		
		
		Balise balV = new Balise();
		balV.setPosition(new Point(400,400));
		balV.setDeplacement(new DeplVertical(300, 580));
		GrBalise grBalV = new GrBalise();
		grBalV.setModel(balV);
		grBalV.setColor(Color.BLUE);
		
		w.addElement(grBalH);
		w.addElement(grBalV);

		w.open();
		while (true) {
			balH.bouge();
			balV.bouge();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
