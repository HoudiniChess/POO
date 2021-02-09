grammar BalSat;

@header {
}

script: command *;

command: call|assign POINTVIRG;

assign: VAR EQUAL valueAssign ;
call: VAR POINT VAR PARG arguments PARD ;

valueAssign: value | call | creation;
creation: 'new' VAR PARG arguments? PARD;

value: NB | SYMBOL ; 

arguments: arg (VIRG arg)*;
arg: VAR '=' valueAssign;

SYMBOL: '#' VAR;
NB  : [0-9]+ ; 
VAR  : [a-zA-Z]+ ;
WS  : [ \t\r\n]+ -> skip ;
PARG : '(';
PARD : ')';
EQUAL : '=';
VIRG : ',';
POINT : '.';
POINTVIRG : ';';