// define a grammar called hello
grammar Hello2;

@header {
// example :
// lundi : Sleeping 10; Practice swimming 1; Meeting John;
// mardi : Sleeping 7; Practice running 2; Meeting Bill;
// mercredi : None;

// Exercice : Compléter l'exemple 2 avec :
// - Méta-modélisation : Spécifier un méta-modèle pour le langage en Java
// - Outils d'analyse : Construire un visiteur "Antlr" pour construire les instances de votre méta-model
// - Back-end XML : Construire un visiteur "classique" pour produire du XML à partir des instances du méta-model
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

