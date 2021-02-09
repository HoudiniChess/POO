script: command *;
command: call|assign;
call: ID '.' ID '(' args ')' ';' ;
assign: ID '=' value ';' ;
args: | arg (',' arg)*;
arg: ID ':' value ';' ;
value: ENTIER | SYMBOL | call;
ENTIER: [0-9]+;
SYMBOL: '#' ID;
ID: [a-zA-Z][a-zA-Z0-9]*; 
















// define a grammar called hello
grammar Hello2;

@header {
// example :
// lundi : Sleeping 10; Practice swimming 1; Meeting John;
// mardi : Sleeping 7; Practice running 2; Meeting Bill;
// mercredi : None;

// Exercice : ComplÃ©ter l'exemple 2 avec :
// - MÃ©ta-modÃ©lisation : SpÃ©cifier un mÃ©ta-modÃ¨le pour le langage en Java
// - Outils d'analyse : Construire un visiteur "Antlr" pour construire les instances de votre mÃ©ta-model
// - Back-end XML : Construire un visiteur "classique" pour produire du XML Ã  partir des instances du mÃ©ta-model
}

schedule : dayActivities* ;
dayActivities : day ':' actualActivities  ;
actualActivities 
	: activity+  	# activities 
	| none 	 		# noActivity
	;
day : ID ;
activity : (sleeping | meeting | practice) ';' ;
sleeping : 'Sleeping' NB ;
practice : 'Practice' ID NB ;
meeting  : 'Meeting' ID ;
none : 'None' ';'  ;

NB  : [0-9]+ ; 
ID  : [a-zA-Z]+ ;
WS  : [ \t\r\n]+ -> skip ;





















grammar BalSat;

@header {
}

script : command*;

command : (call|assign);

assign :
	VAR EQUAL VAR VAR |;
	
call : (VAR POINT VAR PARG ARGS PARD POINTVIRG;
	
affectBalise : 'new ' balise PARG deplacement VIRG NB PARD;
affectSatellite : 'new ' satellite PARG NB;
actionBalise : balise POINT commandes;
actionSatellite : satellite POINT commandes;

balise : 'Balise';
satellite : 'Satellite';

deplacement : (horizontale|verticale|sinusoidale);	
commandes : (start|stop);

start : 'start' PARG PARD;
stop : 'stop' PARG PARD;
horizontale : 'Horizontale';
verticale : 'Verticale';
sinusoidale : 'Sinusoidale';	

NB  : [0-9]+ ; 
VAR  : [a-zA-Z]+ ;
WS  : [ \t\r\n]+ -> skip ;
PARG : '(';
PARD : ')';
EQUAL : '=';
VIRG : ',';
POINT : '.';
POINTVIRG : ';';