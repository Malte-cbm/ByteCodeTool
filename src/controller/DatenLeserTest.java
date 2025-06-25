package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JTabbedPane;

import org.junit.jupiter.api.Test;

import model.DatenContainer;

class DatenLeserTest {

	@Test
	void testLeseKlasse() throws FileNotFoundException {
		DatenContainer dc = new DatenContainer();
		DatenLeser datenLeser = new DatenLeser( new JTabbedPane() );
		datenLeser.leseKlasse(new File("C:\\Java_Files\\Java2_Projekt\\src\\views\\Funktionen.class"), dc);
		
		fail("Not yet implemented");
	}

}
