package hello2.metamodel;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLSerializer extends BaseVisitor {

	private Document doc;
	private Element current;

	public XMLSerializer() {
		this.resetDocument();
	}

	Document result() {
		return this.doc;
	}

	protected Transformer newTransformer() throws TransformerConfigurationException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();       
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        return transf;
	}

	public void writeFile (MMEntity entity, File file) throws TransformerException {
        Transformer transf = this.newTransformer(); 
        
        this.resetDocument();
        entity.accept(this);
        
        DOMSource source = new DOMSource(this.doc);        
        StreamResult stream = new StreamResult(file);
        transf.transform(source, stream);
 	}
	
	public String xmlContents(MMEntity entity) throws TransformerException {
	    Transformer transf = this.newTransformer();     
        	
        this.resetDocument();
        entity.accept(this);

        StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		Source source = new DOMSource(this.doc);
		transf.transform(source, result);
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}
	
	public String xmlContentsForAll(List<MMEntity> entities) throws TransformerException {
	    Transformer transf = this.newTransformer();     
        	
        this.resetDocument();
        Iterator<MMEntity> itor = entities.iterator();
        while (itor.hasNext()) {
        	itor.next().accept(this);
        }
        StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		Source source = new DOMSource(this.doc);
		transf.transform(source, result);
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}
	
	protected void resetDocument() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		this.doc = builder.newDocument();
		this.current = this.doc.createElementNS("univ-brest.fr", "root");
		this.doc.appendChild(this.current);		
	}
	
	@Override
	public void visitSchedule(Schedule schedule) {
		Element previous = this.current;
		this.current = doc.createElementNS("univ-brest.fr", "schedule");
		this.doc.getDocumentElement().appendChild(this.current);
		Iterator<Day> itor = schedule.daysIterator();
		while (itor.hasNext()) {
			itor.next().accept(this);
		}
		this.current = previous;
	}

	@Override
	public void visitDay(Day day) {
		Element previous = this.current;
		this.current = doc.createElementNS("univ-brest.fr", "day");
		this.current.setAttribute("which", day.getWhich());
		previous.appendChild(this.current);
		Iterator<Activity> itor = day.activitiesIterator();
		if (itor != null) {
			while (itor.hasNext()) {
				itor.next().accept(this);
			}
		}
		this.current = previous;
	}

	@Override
	public void visitMeeting(Meeting meeting) {
		Element previous = this.current;
		this.current = doc.createElementNS("univ-brest.fr", "meeting");
		this.current.setAttribute("who", meeting.getWho());
		previous.appendChild(this.current);
		this.current = previous;
	}

	@Override
	public void visitPratice(Practice practice) {
		Element previous = this.current;
		this.current = doc.createElementNS("univ-brest.fr", "practice");
		this.current.setAttribute("what", practice.getWhat());
		this.current.setAttribute("duration", practice.getDuration().toString());
		previous.appendChild(this.current);
		this.current = previous;
	}

	@Override
	public void visitSleeping(Sleeping sleeping) {
		Element previous = this.current;
		this.current = doc.createElementNS("univ-brest.fr", "sleeping");
		this.current.setAttribute("duration", sleeping.getDuration().toString());
		previous.appendChild(this.current);
		this.current = previous;
	}

}
