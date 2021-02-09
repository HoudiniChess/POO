package hello1.visiting;

import java.util.ArrayList;

import hello1.generated.Hello1BaseVisitor;
import hello1.generated.Hello1Parser;

public class Hello1Visitor extends Hello1BaseVisitor<Object> {
	ArrayList<String> allMet = new ArrayList<String>();

	public Object visitMeeting(Hello1Parser.MeetingContext ctx) {
		allMet.add(ctx.ID.getText());
		return ctx;
	}

	public ArrayList<String> result() {
		return allMet;
	}

}

//	meeting   returns [String met] : 'Hello' ID { $met = "Meet " + $ID.getText(); };
//	ID  : [a-zA-Z]+ ;
//	WS  : [ \t\r\n]+ -> skip ;
