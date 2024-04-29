lexer grammar ReactjsLexer;

/////////////////////////////////////////////
// Keywords

CONST: 'const';
LET: 'let';
VAR: 'var';

IMPORT: 'import';
FROM: 'from';
EXPORT: 'export';

// Loop Constructs and Control Flow
FOR_EACH: 'forEach';
BREAK: 'break';
CONTINUE: 'continue';
RETURN: 'return';
IF: 'if';
ELSE: 'else';
ELSE_IF: 'else' 'if';
FOR: 'for';
WHILE: 'while';
DO: 'do';
IN: 'in';
AS:'as';
DEFAULT_CASE: 'default';

THIS: 'this';
NEW: 'new';
TRY: 'try';
CATCH: 'catch';
FINALLY: 'finally';
THROW: 'throw';
TYPEOF: 'typeof';
INSTANCEOF: 'instanceof';
DELETE: 'delete';
ASYNC: 'async';
AWAIT: 'await';
CLASS: 'class';
EXTENDS: 'extends';
SUPER: 'super';
STATIC: 'static';

////////////////////////////////////////////////
// print

CONSOLE: 'console';
LOG: 'log';

////////////////////////////////////////////////
/*
ESCAPE: '\\' ( '`' | '\\' | '$' );
INTERPOLATION: '${' IDENTIFIER '}';
VALIDCHARACTER: ~[`$] | '${' | '\\' | IDENTIFIER | '}';

BACKTICK: '`';
*/

// Functions
FUNCTION: 'function';
UNDEFINED: 'undefined';

///////////////////////////////////////////////////
// Operators

// Comparison Operators
EQUALS: '==';
NOT: '!';
ASSING: '=';
NOT_EQUALS: '!=';
IDENTITY_EQUALS: '===';
IDENTITY_NOT_EQUALS: '!==';
LESS_THAN: '<';
GREATER_THAN: '>';
LESS_THAN_EQUALS: '<=';
GREATER_THAN_EQUALS: '>=';

// Arithmatic Operators
PLUS : '+';
MINUS : '-';
MULTIPLY : '*';
DIV :'/' ;
MODULUS: '%';

// Logical Operators
BIT_AND: '&';
BIT_XOR: '^';
BIT_OR: '|';
AND: '&&';
OR: '||';


// Assignment Operators
PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
MULTIPLY_ASSIGN: '*=';
DIVIDE_ASSIGN: '/=';
MODULUS_ASSIGN: '%=';
POWER_ASSIGN: '**=';
RIGHT_SHIFT_ARITHMETIC_ASSIGN: '>>=';
LEFT_SHIFT_ARITHMETIC_ASSIGN: '<<=';
RIGHT_SHIFT_LOGICAL_ASSIGN: '>>>=';
BIT_AND_ASSIGN: '&=';
BIT_XOR_ASSIGN: '^=';
BIT_OR_ASSIGN: '|=';
ARROW: '=>';
NULLCOALESCE: '??';


// Increment and Decrement
PLUS_PLUS: '++';
MINUS_MINUS: '--';

////////////////////////////////////////////////
// Literals

// String Literals
STRING: ('"' (~["\r\n] | '\\"')* '"') | ('\'' (~['\r\n] | '\\"')* '\'');



// Delcare variables in string
TEMPLATE_LITERAL: '`' ( ~['`', '\\', '$'] | '\\' . | '$' ~['{'] | '${' | TEMPLATE_EXPRESSION )* '`';
fragment TEMPLATE_EXPRESSION: '{' IDENTIFIER '}';

// Number Literals
NUMBER: [0-9]+ ( '.' [0-9]+ )?;
INTEGER: '0' | [1-9][0-9]*;
FLOAT: [0-9]+ '.'[0-9]+;

// Null Literal
NULL: 'null';

// Boolean Literals
BOOLEAN: 'true' | 'false';

///////////////////////////////////////////////
// Punctuations

SEMI_COLON: ';';
COMMA: ',';
COLON: ':';
DOT: '.';
QUESTION_MARK: '?';
HASH_TAG: '#';

// Brackets
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
OPEN_BRACKET: '[';
CLOSE_BRACKET: ']';
OPEN_PAREN: '(';
CLOSE_PAREN: ')';

///////////////////////////////////////////////
// WhiteSpace

WS: [ \t\r\n]+ -> skip;
NEWLINE: '\r'? '\n' | '\r';

///////////////////////////////////////////////
// Comments
//  .*? is a construct that matches any character
MultiLineComment: '/*' .*? '*/' -> channel(HIDDEN);
SingleLineComment: '//'~[\r\n\u2028\u2029]* -> channel(HIDDEN);

// Skip $ and –
EscapeDollarSign:  '$' -> channel(HIDDEN);
EscapeDash:  '–' -> channel(HIDDEN);


///////////////////////////////////////////////
// Pure React
REACT: 'React';
CREATE_ELEMENT: 'createElement';

////////////////////////////////////////////////
// Hooks
USE_STATE: 'useState';
USE_EFFECT: 'useEffect';
USE_REF: 'useRef';

////////////////////////////////////////////////
// IDENTIFIER
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]* ;
////////////////////////////////////////////////