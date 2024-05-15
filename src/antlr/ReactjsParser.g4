parser grammar ReactjsParser;

options {tokenVocab=ReactjsLexer; }

program: statement+ EOF;

statement : block                               # BlockSt
          | printStatement                      # PrintStatementSt
          | arrayAccess                         # ArrayAccessSt
          | variableStatement                   # VariableStatementSt
          | importStatement                     # ImportStatementSt
          | exportStatement                     # ExportStatementSt
          | classDeclaration                    # ClassDeclarationSt
          | ifStatement                         # IfStatementSt
          | iterationStatement                  # IterationStatementSt
          | returnStatment                      # ReturnStatmentSt
          | functionDeclartion                  # FunctionDeclartionSt
          | functionCreateElement               # FunctionCreateElementSt
          | functionCall                        # FunctionCallSt
          | expression SEMI_COLON?              # ExpressionSt
          ;

// test : STRING statement*;

// block
block : OPEN_BRACE statement* CLOSE_BRACE SEMI_COLON?
      ;

///////////////////////////////////////////////////////////////////////
// print
// console.log('d');
printStatement : CONSOLE DOT LOG OPEN_PAREN (expression)? CLOSE_PAREN SEMI_COLON?
               ;
///////////////////////////////////////////////////////////////////////

// arrayAccess
arrayAccess : IDENTIFIER OPEN_BRACKET expression CLOSE_BRACKET
            ;

///////////////////////////////////////////////////////////////////////
// import

importStatement : IMPORT importDeclaration (FROM STRING)? SEMI_COLON?
                ;

importDeclaration : importDefaultSpecifier         #ImportDefaultSpecifier_L
                  | importNamespaceSpecifier       #ImportNamespaceSpecifier_L
                  | importNamedSpecifier           #ImportNamedSpecifier_L
                  ;

//import myDefault from 'modulePath';
importDefaultSpecifier : IDENTIFIER
                       | STRING
                       | REACT
                       | DEFAULT_CASE AS IDENTIFIER
                       ;

//import * as myModule from 'modulePath';
importNamespaceSpecifier: MULTIPLY AS IDENTIFIER
                        ;
//import { export1, export2 as alias2 } from 'modulePath';
importNamedSpecifier: (importSpecifier COMMA)* OPEN_BRACE (importSpecifier (COMMA importSpecifier)* COMMA? )? CLOSE_BRACE
                    ;

importSpecifier: IDENTIFIER
               | USE_STATE
               | USE_EFFECT
               | USE_REF
               | REACT
               | IDENTIFIER AS IDENTIFIER
               ;

///////////////////////////////////////////////////////////////////////
// export

// export default App;

exportStatement : exportDefaultDeclaration                      #ExportDefaultDeclaration_L
                | exportDeclaration                             #ExportDeclaration_L
                ;

exportDefaultDeclaration: EXPORT DEFAULT_CASE expression SEMI_COLON?
                        ;

exportDeclaration: EXPORT (variableStatement | classDeclaration | functionDeclartion) SEMI_COLON?
                 ;


///////////////////////////////////////////////////////////////////////
// class

// class s {}
classDeclaration : CLASS IDENTIFIER (EXTENDS expression)? OPEN_BRACE statement* CLOSE_BRACE
                 ;

///////////////////////////////////////////////////////////////////////
// variable

// const pro = '443';
// var pro

variableStatement: varHelpers variableDeclaration (COMMA variableDeclaration)* SEMI_COLON?                # VariableDeclarationVr
                 | CONST variableDeclarationConst (COMMA variableDeclarationConst)* SEMI_COLON?            # VariableDeclarationConstVr
                 ;

variableDeclarationConst: variableType ASSING expression
                        ;

variableDeclaration: variableType (ASSING expression)?
                   ;


variableType : IDENTIFIER                #IdentidierVt
             | arrayDeclaration          #ArrayDeclarationVt
             | objectDeclaration         #ObjectDeclarationVt
             ;
//let [x,y]=[1,2]
/////////////////////

/*
{
  id: 1,
  name: 'Product 1',
  image: productss1Image,
  description: 'Description for Product 1',
}
*/

objectDeclaration : OPEN_BRACE (objectProperty (COMMA objectProperty)* COMMA?)? CLOSE_BRACE
                  ;

objectProperty : (IDENTIFIER COLON expression)        #ExpressionObjectProperty
               | expression                           #ExpressionProperty
               ;

// [1,2,3]

arrayDeclaration : OPEN_BRACKET COMMA* (expression COMMA)* expression? COMMA* CLOSE_BRACKET
                 ;


///////////////////////////////////////////////////////////////////////
// experssion

expression:functionDeclartion                                                                                # FunctionExpression
          | functionCall                                                                                     # FunctionCallExpression
          | arrayAccess                                                                                      # ArrayAcessExpression
          | expression QUESTION_MARK? DOT HASH_TAG? expression                                               # MemberDotExpression
          | expression PLUS_PLUS                                                                             # PostIncrementExpression
          | expression MINUS_MINUS                                                                           # PostDecreaseExpression
          | PLUS_PLUS expression                                                                             # PreIncrementExpression
          | MINUS_MINUS expression                                                                           # PreDecreaseExpression
          | NOT expression                                                                                   # NotExpression
          | expression (MULTIPLY | DIV | MODULUS) expression                                                 # MultiplicativeExpression
          | expression (PLUS | MINUS) expression                                                             # AdditiveExpression
          | expression (LESS_THAN | GREATER_THAN | LESS_THAN_EQUALS | GREATER_THAN_EQUALS) expression        # RelationalExpression
          | expression (EQUALS | NOT_EQUALS | IDENTITY_EQUALS | IDENTITY_NOT_EQUALS | ASSING) expression     # EqualityExpression
          | expression AND expression                                                                        # LogicalAndExpression
          | expression OR expression                                                                         # LogicalOrExpression
          | expression QUESTION_MARK expression COLON expression                                             # TernaryExpression
          | value                                                                                            # ValueExpression
          | arrayDeclaration                                                                                 # ArrayExpression
          | objectDeclaration                                                                                # ObjectExpression
          | hook                                                                                             # HookExpression
          | functionCreateElement                                                                            # FunctionCreateElementExpression
          | htmlBody                                                                                         # HtmlBodyExpression
          | OPEN_PAREN expression CLOSE_PAREN                                                                # ParenthesizedExpression
          ;

///////////////////////////////////////////////////////////////////////
// if statment

/*
if (x=2){
    o=3;
    x=2;
  }
  else if (x=2) {

  }
  else {

  }
*/


ifStatement : IF OPEN_PAREN expression CLOSE_PAREN block?  elseIf* else? SEMI_COLON?
            ;

elseIf :(ELSE IF OPEN_PAREN expression CLOSE_PAREN block?)
       ;

else :(ELSE block?)
     ;

// iteration Statement

/*
for (i=0;i<n;i++) {

  }
  for(;;)

  do{

  } while(true);

*/

iterationStatement: DO statement WHILE OPEN_PAREN expression CLOSE_PAREN SEMI_COLON?                                                     # DoStatement
                  | WHILE OPEN_PAREN expression CLOSE_PAREN statement                                                                    # WhileStatement
                  | FOR OPEN_PAREN (expression | variableStatement)? SEMI_COLON expression? SEMI_COLON expression? CLOSE_PAREN statement # ForStatement
                  | FOR OPEN_PAREN (expression | variableStatement) IN expression CLOSE_PAREN statement                                  # ForInStatement
                  ;

///////////////////////////////////////////////////////////////////////
// return

returnStatment  : RETURN OPEN_PAREN htmlBody CLOSE_PAREN SEMI_COLON           #HtmlBody_R
                | RETURN expression SEMI_COLON                                #Expression_R
                ;
/*
retrunHtmlBody: RETURN OPEN_PAREN htmlBody CLOSE_PAREN SEMI_COLON;
              | RETURN expression SEMI_COLON
              ;
returnExpression: RETURN expression SEMI_COLON;
*/
///////////////////////////////////////////////////////////////////////
// Hooks

hook : useStateHook                       #UseStateHook_L
     | useEffectHook                      #UseEffectHook_L
     | useRefHook                         #UseRefHook_L
     ;

///////////////////////////////////////////////////////////////////////
// useState declartion
// useState(3);
useStateHook : (REACT DOT)? USE_STATE OPEN_PAREN (value COMMA?)* CLOSE_PAREN SEMI_COLON?
             ;

///////////////////////////////////////////////////////////////////////
// useEffect declartion
/*
useEffect(() => {
    console.log('d');
  }, [selectedProduct]);
*/
useEffectHook : (REACT DOT)? USE_EFFECT OPEN_PAREN arrowFunction (COMMA arrayDeclaration)? COMMA? CLOSE_PAREN SEMI_COLON?
              ;

///////////////////////////////////////////////////////////////////////

// useRef declartion
// useRef<HTMLInputElement>(null);
useRefHook  : (REACT DOT)? USE_REF OPEN_PAREN (value COMMA?)* CLOSE_PAREN SEMI_COLON?                                    #useRefHook_value
            | (REACT DOT)? USE_REF LESS_THAN IDENTIFIER GREATER_THAN OPEN_PAREN (value COMMA?)+ CLOSE_PAREN SEMI_COLON?  #useRefHook_value_IDENTIFIER
            ;

///////////////////////////////////////////////////////////////////////
// function call

// x();
functionCall : IDENTIFIER OPEN_PAREN (expression COMMA?)* CLOSE_PAREN SEMI_COLON?
             ;

///////////////////////////////////////////////////////////////////////
// function createElement

/*
return React.createElement(
    'div',
    {},
    React.createElement('h2', {}, "Let's get started!"),
    React.createElement(Expenses, { items: expenses })
);
*/
functionCreateElement : REACT DOT CREATE_ELEMENT OPEN_PAREN value? (COMMA objectDeclaration)? functionthirdParam* COMMA? CLOSE_PAREN SEMI_COLON?
                      ;
functionthirdParam :(COMMA (value | functionCreateElement))
                   ;
///////////////////////////////////////////////////////////////////////
// function declartion

functionDeclartion : normalFunction          #NormalFunction_L
                   | anoymousFunction        #AnoymousFunction_L
                   | arrowFunction           #ArrowFunction_L
                   ;

// normalFunction
// anoymousFunction
// arrowFunction

// function s(){}
normalFunction  : ASYNC? FUNCTION MULTIPLY? IDENTIFIER OPEN_PAREN (expression COMMA?)* CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE SEMI_COLON?;

// function (){}
anoymousFunction  : ASYNC? FUNCTION MULTIPLY? OPEN_PAREN (expression COMMA?)* CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE SEMI_COLON?;

// () => {}
arrowFunction : arrowParameters ARROW (block | expression);

arrowParameters : value                                           #ValueArrow
                | OPEN_PAREN (expression COMMA?)* CLOSE_PAREN     #ExpressionArrow
                ;

htmlBody : htmlBodyWithDiv                 #HtmlBodyWithDiv_L
         | htmlBodyNestedDiv               #HtmlBodyNestedDiv_L
         | htmlBodyDivAlone                #HtmlBodyDivAlone_L
         | htmlBodyNoDiv                   #HtmlBodyNoDiv_L
         ;


// <div classname = "key">jsxContent</div>
htmlBodyWithDiv: LESS_THAN (IDENTIFIER jsxAttribute*)? GREATER_THAN jsxContent LESS_THAN DIV IDENTIFIER? GREATER_THAN;

// <div classname = "key" jsxContent/>
htmlBodyNestedDiv : LESS_THAN IDENTIFIER jsxAttribute* jsxContent DIV GREATER_THAN
                  ;

// <div classname = "key"/> | <div/>
htmlBodyDivAlone : LESS_THAN IDENTIFIER jsxAttribute* DIV GREATER_THAN
                 ;

// <sidebar>
htmlBodyNoDiv : LESS_THAN IDENTIFIER jsxAttribute* GREATER_THAN
              ;

jsxContent : jsxText? ((htmlBody | jsxExpression) jsxText?)*
           ;

jsxExpression: OPEN_BRACE expression* CLOSE_BRACE;

jsxText : ~(LESS_THAN | OPEN_BRACE)+
        ;

jsxAttribute : IDENTIFIER ASSING objectDeclaration  #JsxAtteibute_Object
             | IDENTIFIER ASSING STRING             #JsxAtteibute_String
             | IDENTIFIER                           #JsxAtteibute_Identifier
             ;

// Helpers
varHelpers : VAR
           | LET
           ;

// Value
value : STRING
      | TEMPLATE_LITERAL
      | NUMBER
      | BOOLEAN
      | NULL
      | UNDEFINED
      | IDENTIFIER
      ;



