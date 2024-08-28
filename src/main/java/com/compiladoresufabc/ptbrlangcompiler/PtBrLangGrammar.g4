grammar PtBrLangGrammar;

programa    : 'programa' expr 'fimprograma'
            ;

expr        : termo exprl
            ;

exprl       : (OP termo)*
            ;

OP          : '+' | '-' | '*' | '/'
            ;

ID          : [a-z] ([a-z] | [A-Z] | [0-9])*
            ;

NUM         : [0-9]+ ('.' [0-9]+)?
            ;

WS          : (' ' | '\n' | '\r' | '\t') -> skip
            ;

termo       : ID | NUM
            ;