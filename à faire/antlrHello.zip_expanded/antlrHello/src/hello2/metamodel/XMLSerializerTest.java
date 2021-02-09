package hello2.metamodel;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.Test;

class XMLSerializerTest {

	@Test
	void test1() {
		String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
				+ "<root xmlns=\"univ-brest.fr\">\n"
				+ "    <schedule/>\n"
				+ "</root>\n";
		XMLSerializer serializer = new XMLSerializer();
		Schedule schd = new Schedule();
		try {
			assertTrue(serializer.xmlContents(schd).equals(r));
		} catch (TransformerException e) {
			fail();
		}
	}

	@Test
	void test2() {
		String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
				+ "<root xmlns=\"univ-brest.fr\">\n"
				+ "    <schedule>\n"
				+ "        <day which=\"Monday\"/>\n"
				+ "    </schedule>\n"
				+ "</root>\n";
		XMLSerializer serializer = new XMLSerializer();
		Schedule schd = new Schedule();
		schd.addDay(new Day("Monday"));
		try {
			assertTrue(serializer.xmlContents(schd).equals(r));
		} catch (TransformerException e) {
			fail();
		}
	}

	@Test
	void test3() {
		String r = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
				+ "<root xmlns=\"univ-brest.fr\">\n"
				+ "    <schedule>\n"
				+ "        <day which=\"Monday\">\n"
				+ "            <meeting who=\"Bill\"/>\n"
				+ "            <sleeping duration=\"12\"/>\n"
				+ "            <practice duration=\"1\" what=\"Swimming\"/>\n"
				+ "        </day>\n"
				+ "        <day which=\"Tuesday\"/>\n"
				+ "    </schedule>\n"
				+ "</root>\n";
		XMLSerializer serializer = new XMLSerializer();
		Schedule schd = new Schedule();
		Day monday = new Day("Monday");
		schd.addDay(monday);
		monday.addActivity(new Meeting("Bill"));
		monday.addActivity(new Sleeping(12));
		monday.addActivity(new Practice("Swimming", 1));
		Day tuesday = new Day("Tuesday");
		schd.addDay(tuesday);
		try {
			assertTrue(serializer.xmlContents(schd).equals(r));
		} catch (TransformerException e) {
			fail();
		}
	}

}
