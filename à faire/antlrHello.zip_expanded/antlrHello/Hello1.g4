// define a grammar called hello
grammar Hello1;

@header {
// antlr exo1
}

//meeting 
//	: 'Hello' ID ;

//ID  : [a-zA-Z]+ ;
//WS  : [ \t\r\n]+ -> skip ;


meeting returns [String met] 
	: 'Hello' ID { $met = "Meet " + $ID.getText(); };

 ID  : [a-zA-Z]+ ;
 WS  : [ \t\r\n]+ -> skip ;
