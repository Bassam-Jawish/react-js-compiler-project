package Visitor;

import AST.Space;
import AST.expression.*;
import AST.function.*;
import AST.helpers.*;
import AST.hook.UseEffectHook;
import AST.hook.UseRefHook;
import AST.hook.UseStateHook;
import AST.iteration.DoStatement;
import AST.iteration.ForInStatement;
import AST.iteration.ForStatement;
import AST.iteration.WhileStatement;
import AST.jsx.*;
import AST.program.Program;
import AST.pureReact.FunctionCreateElement;
import AST.pureReact.CreateFunctionParams;
import AST.statement.*;
import ErrorHandling.SemanticCheck;
import SymbolTableStructure.Row;
import SymbolTableStructure.SymbolTable;
import SymbolTableStructure.SymbolTable2;
import antlr.ReactjsParser;
import antlr.ReactjsParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends ReactjsParserBaseVisitor {

    private SymbolTable2 s;

    public ASTVisitor(SemanticCheck semanticCheck) {
        this.s = new SymbolTable2();
        this.semanticCheck = semanticCheck;
    }

    private final SemanticCheck semanticCheck;

    public SymbolTable symbolTable = new SymbolTable();

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public SymbolTable2 getSymbolTable2() {
        return s;
    }

    //-------------------- Program ---------------------
    @Override
    public Program visitProgram(ReactjsParser.ProgramContext ctx) {

        Program p = new Program();
        List<Statement> st = new ArrayList<>();
        for (ReactjsParser.StatementContext stat : ctx.statement()) {
            st.add((Statement) visit(stat));
        }

        p.setStatements(st);

        // System.out.println(symbolTable);

        System.out.println();
        System.out.println("Program: \n");

        return p;
    }

    //------------------------- Statement -----------------------------

    @Override
    public Statement visitBlockSt(ReactjsParser.BlockStContext ctx) {
        return visitBlock(ctx.block());
    }


    @Override
    public Statement visitPrintStatementSt(ReactjsParser.PrintStatementStContext ctx) {
        return visitPrintStatement(ctx.printStatement());
    }


    @Override
    public Statement visitArrayAccessSt(ReactjsParser.ArrayAccessStContext ctx) {
        return visitArrayAccess(ctx.arrayAccess());
    }


    @Override
    public Statement visitVariableStatementSt(ReactjsParser.VariableStatementStContext ctx) {
        return (Statement) visit(ctx.variableStatement());
    }


    @Override
    public Statement visitImportStatementSt(ReactjsParser.ImportStatementStContext ctx) {
        return visitImportStatement(ctx.importStatement());
    }


    @Override
    public Statement visitExportStatementSt(ReactjsParser.ExportStatementStContext ctx) {
        return (Statement) visit(ctx.exportStatement());
    }

    @Override
    public Statement visitClassDeclarationSt(ReactjsParser.ClassDeclarationStContext ctx) {
        return visitClassDeclaration(ctx.classDeclaration());
    }

    @Override
    public Object visitIfStatementSt(ReactjsParser.IfStatementStContext ctx) {
        return visitIfStatement(ctx.ifStatement());
    }

    @Override
    public Statement visitIterationStatementSt(ReactjsParser.IterationStatementStContext ctx) {
        return (Statement) visit(ctx.iterationStatement());
    }

    @Override
    public Object visitFunctionDeclartionSt(ReactjsParser.FunctionDeclartionStContext ctx) {
        return visit(ctx.functionDeclartion());
    }

    @Override
    public Object visitFunctionCreateElementSt(ReactjsParser.FunctionCreateElementStContext ctx) {
        return visitFunctionCreateElement(ctx.functionCreateElement());
    }

    @Override
    public Object visitFunctionCallSt(ReactjsParser.FunctionCallStContext ctx) {
        return visitFunctionCall(ctx.functionCall());
    }

    @Override
    public Object visitExpressionSt(ReactjsParser.ExpressionStContext ctx) {
        return visit(ctx.expression());
    }

    //--------------------------- Block -------------------------------

    @Override
    public Statement visitBlock(ReactjsParser.BlockContext ctx) {
        symbolTable.enterScope();
        s.enterScope();
        BlockStatement blockStatement = new BlockStatement();
        List<Statement> st = new ArrayList<>();
        for (ReactjsParser.StatementContext state : ctx.statement()) {
            if (state != null) {
                st.add((Statement) visit(state));
            }
        }
        blockStatement.setStatements(st);
        symbolTable.exitScope();
        s.exitScope();
        return blockStatement;
    }


    //-------------------- Print ------------------------

    @Override
    public Statement visitPrintStatement(ReactjsParser.PrintStatementContext ctx) {
        PrintStatement printStatement = new PrintStatement();

        printStatement.setExpression((Expression) visit(ctx.expression()));

        return printStatement;
    }

    //-------------------- Access Array ------------------------


    @Override
    public Statement visitArrayAccess(ReactjsParser.ArrayAccessContext ctx) {
        ArrayAccess arrayAccess = new ArrayAccess();

        arrayAccess.setArrayName(ctx.IDENTIFIER().toString());
        arrayAccess.setIndex((Expression) visit(ctx.expression()));

        return arrayAccess;
    }


    //-------------------- ImportStatement ------------------------


    @Override
    public Statement visitImportStatement(ReactjsParser.ImportStatementContext ctx) {
        ImportStatement importStatement = new ImportStatement();

        importStatement.setImportDeclaration((ImportDeclaration) visit(ctx.importDeclaration()));

        return importStatement;
    }

    @Override
    public Object visitImportDefaultSpecifier_L(ReactjsParser.ImportDefaultSpecifier_LContext ctx) {
        return visitImportDefaultSpecifier(ctx.importDefaultSpecifier());
    }


    @Override
    public Object visitImportNamespaceSpecifier_L(ReactjsParser.ImportNamespaceSpecifier_LContext ctx) {
        return visitImportNamespaceSpecifier(ctx.importNamespaceSpecifier());
    }

    @Override
    public Object visitImportNamedSpecifier_L(ReactjsParser.ImportNamedSpecifier_LContext ctx) {
        return visitImportNamedSpecifier(ctx.importNamedSpecifier());
    }


    @Override
    public Object visitImportDefaultSpecifier(ReactjsParser.ImportDefaultSpecifierContext ctx) {

        ImportDefaultSpecifier importDefaultSpecifier = new ImportDefaultSpecifier();

        if (ctx.IDENTIFIER() != null) {
            importDefaultSpecifier.setType(ctx.IDENTIFIER().getText());
            // semanticCheck.setOneDeclaredVariable(ctx.IDENTIFIER().getText(), symbolTable.getScopeId(), "import");
        } else if (ctx.STRING() != null) {
            importDefaultSpecifier.setType(ctx.STRING().getText());
        } else if (ctx.REACT() != null) {
            // semanticCheck.setReactImported(true);
            importDefaultSpecifier.setType(ctx.REACT().getText());
        } else if (ctx.DEFAULT_CASE() != null && ctx.IDENTIFIER() != null) {
            importDefaultSpecifier.setType("DEFAULT_CASE AS " + ctx.IDENTIFIER().getText());
        }

        importDefaultSpecifier.validateImport(semanticCheck, symbolTable.getScopeId());

        return importDefaultSpecifier;
    }


    @Override
    public Object visitImportNamespaceSpecifier(ReactjsParser.ImportNamespaceSpecifierContext ctx) {

        ImportNamespaceSpecifier importNamespaceSpecifier = new ImportNamespaceSpecifier();

        //semanticCheck.setOneDeclaredVariable(ctx.IDENTIFIER().getText(), symbolTable.getScopeId(), "import");
        importNamespaceSpecifier.validateImport(semanticCheck, symbolTable.getScopeId());
        importNamespaceSpecifier.setType(ctx.IDENTIFIER().toString());

        return importNamespaceSpecifier;

    }


    @Override
    public Object visitImportNamedSpecifier(ReactjsParser.ImportNamedSpecifierContext ctx) {
        ImportNamedSpecifier importNamedSpecifier = new ImportNamedSpecifier();

        List<ImportSpecifier> importSpecifiers = new ArrayList<>();

        for (ReactjsParser.ImportSpecifierContext importSpecifierContext : ctx.importSpecifier()) {

            importSpecifiers.add((ImportSpecifier) visit(importSpecifierContext));

        }
        importNamedSpecifier.setImportSpecifiers(importSpecifiers);

        return importNamedSpecifier;

    }

    @Override
    public Object visitImportSpecifier(ReactjsParser.ImportSpecifierContext ctx) {
        ImportSpecifier importSpecifier = new ImportSpecifier();

        if (ctx.IDENTIFIER().size() == 2) {
            String alias = ctx.IDENTIFIER(1).getText();
            importSpecifier.setType(ctx.IDENTIFIER(0).getText() + " AS " + alias);
            // semanticCheck.setOneDeclaredVariable(ctx.IDENTIFIER(0).getText(), symbolTable.getScopeId(), "import");
            if (ctx.IDENTIFIER(0).getText().equals("React")) {
                // semanticCheck.setReactImported(true);
            }
        } else {
            if (!ctx.IDENTIFIER().isEmpty()) {
                importSpecifier.setType(ctx.IDENTIFIER(0).getText());
                // semanticCheck.setOneDeclaredVariable(ctx.IDENTIFIER(0).getText(), symbolTable.getScopeId(), "import");
            } else if (ctx.USE_STATE() != null) {
                importSpecifier.setType(ctx.USE_STATE().getText());
                // semanticCheck.setUseStateImported(true);
            } else if (ctx.USE_EFFECT() != null) {
                importSpecifier.setType(ctx.USE_EFFECT().getText());
                // semanticCheck.setUseEffectImported(true);
            } else if (ctx.USE_REF() != null) {
                importSpecifier.setType(ctx.USE_REF().getText());
                // semanticCheck.setUseRefImported(true);
            } else if (ctx.REACT() != null) {
                importSpecifier.setType(ctx.REACT().getText());
                // semanticCheck.setReactImported(true);
            }
        }

        importSpecifier.validateImport(semanticCheck, symbolTable.getScopeId());

        return importSpecifier;
    }

    //-------------------- ExportStatement ------------------------

    @Override
    public Object visitExportDefaultDeclaration_L(ReactjsParser.ExportDefaultDeclaration_LContext ctx) {
        return visitExportDefaultDeclaration(ctx.exportDefaultDeclaration());
    }

    @Override
    public Object visitExportDeclaration_L(ReactjsParser.ExportDeclaration_LContext ctx) {
        return visitExportDeclaration(ctx.exportDeclaration());
    }

    @Override
    public Object visitExportDefaultDeclaration(ReactjsParser.ExportDefaultDeclarationContext ctx) {

        ExportDefaultDeclaration exportDefaultDeclaration = new ExportDefaultDeclaration();

        exportDefaultDeclaration.setExpression((Expression) visit(ctx.expression()));

        return exportDefaultDeclaration;
    }

    @Override
    public Object visitExportDeclaration(ReactjsParser.ExportDeclarationContext ctx) {
        ExportDeclaration exportDeclaration = new ExportDeclaration();

        if (ctx.variableStatement() != null) {
            exportDeclaration.setVariableStatement((VariableStatement) visit(ctx.variableStatement()));
        } else if (ctx.classDeclaration() != null) {
            exportDeclaration.setClassDeclaration((ClassDeclaration) visit(ctx.classDeclaration()));
        } else if (ctx.functionDeclartion() != null) {
            exportDeclaration.setFunctionDeclaration((FunctionDeclaration) visit(ctx.functionDeclartion()));
        }

        return exportDeclaration;
    }

    //-------------------- ClassDeclaration ------------------------

    @Override
    public Statement visitClassDeclaration(ReactjsParser.ClassDeclarationContext ctx) {
        ClassDeclaration classDeclaration = new ClassDeclaration();

        String className = ctx.IDENTIFIER().toString();
        classDeclaration.setClassName(className);

        if (ctx.expression() != null) {
            Expression extendedClass = (Expression) visit(ctx.expression());
            classDeclaration.setExtendedClassName(extendedClass);
        }

        BlockStatement blockStatement = new BlockStatement();
        classDeclaration.setBlockStatement(blockStatement);

        // Symbol Table
        Row row = new Row();
        row.setLine(ctx.start.getLine());
        row.setScopeid(symbolTable.getScopeId());
        row.setVariableName(classDeclaration.getClassName());
        row.setType("");
        row.setValue(classDeclaration.getBlockStatement().toString());
        this.symbolTable.addVariable(row);

        // Symbol Table 2
        s.addVariable(classDeclaration.getClassName(), classDeclaration.getBlockStatement().toString());

        return classDeclaration;
    }

    //-------------------- VariableStatement ------------------------


    @Override
    public Statement visitVariableDeclarationVr(ReactjsParser.VariableDeclarationVrContext ctx) {
        VariableStatement variableStatement = new VariableStatement();

        if (ctx.varHelpers() != null) {
            variableStatement.setVarHelper((VarHelper) visit(ctx.varHelpers()));
        }

        List<VariableDeclaration> declarations = new ArrayList<>();
        for (ReactjsParser.VariableDeclarationContext varCtx : ctx.variableDeclaration()) {
            if (varCtx != null) {
                declarations.add(visitVariableDeclaration(varCtx));
            }
        }
        variableStatement.setVariableDeclarations(declarations);

        return variableStatement;
    }

    @Override
    public Statement visitVariableDeclarationConstVr(ReactjsParser.VariableDeclarationConstVrContext ctx) {
        VariableStatement variableStatement = new VariableStatement();

        List<VariableDeclarationConst> declarations = new ArrayList<>();

        for (ReactjsParser.VariableDeclarationConstContext varConstCtx : ctx.variableDeclarationConst()) {
            if (varConstCtx != null) {
                declarations.add((VariableDeclarationConst) visitVariableDeclarationConst(varConstCtx));
            }
        }
        variableStatement.setVariableConstDeclarations(declarations);
        return variableStatement;
    }


    @Override
    public Object visitVariableDeclarationConst(ReactjsParser.VariableDeclarationConstContext ctx) {
        VariableDeclarationConst variableDeclarationConst = new VariableDeclarationConst();

        variableDeclarationConst.setVariableType((VariableType) visit(ctx.variableType()));

        Expression expression = (Expression) visit(ctx.expression());
        variableDeclarationConst.setExpression(expression);

        // Symbol Table
        Row row = new Row();
        row.setLine(ctx.start.getLine());
        row.setScopeid(symbolTable.getScopeId());
        row.setVariableName(variableDeclarationConst.getVariableType().toString());
        row.setType("");
        row.setValue(variableDeclarationConst.getExpression().toString());
        this.symbolTable.addVariable(row);

        // declaring a new variable
        //semanticCheck.setOneDeclaredVariable(variableDeclarationConst.getVariableType().toString(), symbolTable.getScopeId(), "const");
        variableDeclarationConst.performSemanticCheck(semanticCheck, symbolTable.getScopeId());

        // Symbol Table 2
        s.addVariable(variableDeclarationConst.getVariableType().toString(), variableDeclarationConst.getExpression().toString());
        return variableDeclarationConst;
    }

    @Override
    public VariableDeclaration visitVariableDeclaration(ReactjsParser.VariableDeclarationContext ctx) {
        VariableDeclaration variableDeclaration = new VariableDeclaration();

        variableDeclaration.setVariableType((VariableType) visit(ctx.variableType()));

        if (ctx.expression() != null) {
            variableDeclaration.setExpression((Expression) visit(ctx.expression()));

            // Symbol Table
            Row row = new Row();
            row.setLine(ctx.start.getLine());
            row.setScopeid(symbolTable.getScopeId());
            row.setVariableName(variableDeclaration.getVariableType().toString());
            row.setType("");
            row.setValue(variableDeclaration.getExpression().toString());
            this.symbolTable.addVariable(row);

            System.out.println(ctx.start.getLine());

            // declaring a new variable
            //semanticCheck.setOneDeclaredVariable(variableDeclaration.getVariableType().toString(), symbolTable.getScopeId(), "var/let");
            variableDeclaration.performSemanticCheck(semanticCheck, symbolTable.getScopeId());


            // Symbol Table 2
            s.addVariable(variableDeclaration.getVariableType().toString(), variableDeclaration.getExpression().toString());
        }
        return variableDeclaration;
    }

    @Override
    public Object visitIdentidierVt(ReactjsParser.IdentidierVtContext ctx) {
        IdentifierType identifierType = new IdentifierType();

        identifierType.setIdentifier(ctx.IDENTIFIER().getText());

        return identifierType;
    }

    @Override
    public Object visitArrayDeclarationVt(ReactjsParser.ArrayDeclarationVtContext ctx) {
        return visitArrayDeclaration(ctx.arrayDeclaration());
    }

    @Override
    public Object visitObjectDeclarationVt(ReactjsParser.ObjectDeclarationVtContext ctx) {
        return visitObjectDeclaration(ctx.objectDeclaration());
    }


    @Override
    public Object visitObjectDeclaration(ReactjsParser.ObjectDeclarationContext ctx) {
        ObjectDeclaration objectDeclaration = new ObjectDeclaration();

        List<ObjectProperty> objectProperties = new ArrayList<>();
        for (ReactjsParser.ObjectPropertyContext objectPropertyContext : ctx.objectProperty()) {
            if (objectPropertyContext != null) {
                objectProperties.add((ObjectProperty) visit(objectPropertyContext));
            }
        }
        objectDeclaration.setObjectProperty(objectProperties);
        return objectDeclaration;
    }


    @Override
    public Object visitExpressionObjectProperty(ReactjsParser.ExpressionObjectPropertyContext ctx) {
        ObjectProperty objectProperty = new ObjectProperty();
        objectProperty.setIdentifier(ctx.IDENTIFIER().getText());

        //semanticCheck.setOneDeclaredVariable(ctx.expression().getText(), symbolTable.getScopeId(), "object");
        objectProperty.performSemanticCheck(semanticCheck, ctx.expression().getText(), symbolTable.getScopeId());

        objectProperty.setExpression((Expression) visit(ctx.expression()));

        return objectProperty;
    }

    @Override
    public Object visitExpressionProperty(ReactjsParser.ExpressionPropertyContext ctx) {
        ObjectProperty objectProperty = new ObjectProperty();

        //semanticCheck.setOneDeclaredVariable(ctx.expression().getText(), symbolTable.getScopeId(), "object");
        objectProperty.performSemanticCheck(semanticCheck, ctx.expression().getText(), symbolTable.getScopeId());

        objectProperty.setExpression((Expression) visit(ctx.expression()));

        return objectProperty;
    }


    @Override
    public Object visitArrayDeclaration(ReactjsParser.ArrayDeclarationContext ctx) {
        ArrayDeclaration arrayDeclaration = new ArrayDeclaration();

        List<Expression> expressions = new ArrayList<>();
        for (ReactjsParser.ExpressionContext expressionContext : ctx.expression()) {
            if (expressionContext != null) {
                //semanticCheck.setOneDeclaredVariable(expressionContext.getText(), symbolTable.getScopeId(), "array");
                arrayDeclaration.performSemanticChecks(semanticCheck, expressionContext.getText(), symbolTable.getScopeId());
                expressions.add((Expression) visit(expressionContext));
            }
        }
        arrayDeclaration.setExpressions(expressions);
        return arrayDeclaration;

    }


    //-------------------- IfStatement ------------------------


    @Override
    public Object visitIfStatement(ReactjsParser.IfStatementContext ctx) {
        IfStatement ifStatement = new IfStatement();

        ifStatement.setCondition((Expression) visit(ctx.expression()));

        if (ctx.block() != null) {
            ifStatement.setIfBlock((BlockStatement) visit(ctx.block()));
        }

        List<ElseIF> elseIF = new ArrayList<>();
        for (ReactjsParser.ElseIfContext elseIfContext : ctx.elseIf()) {
            if (elseIfContext != null) {
                elseIF.add((ElseIF) visit(elseIfContext));
            }
        }
        ifStatement.setElseIfStatements(elseIF);

        if (ctx.else_() != null) {
            ifStatement.elseStatement((BlockStatement) visit(ctx.else_()));
        }

        return ifStatement;
    }


    @Override
    public Object visitElseIf(ReactjsParser.ElseIfContext ctx) {
        ElseIF elseIF = new ElseIF();
        elseIF.setExpression((Expression) visit(ctx.expression()));

        elseIF.setStatements((BlockStatement) visit(ctx.block()));

        return elseIF;
    }

    @Override
    public Object visitElse(ReactjsParser.ElseContext ctx) {
        return visitBlock(ctx.block());
    }

    //-------------------- IterationStatement ------------------------


    @Override
    public Object visitDoStatement(ReactjsParser.DoStatementContext ctx) {
        DoStatement statement = new DoStatement();

        statement.setStatement((Statement) visit(ctx.statement()));

        statement.setExpression((Expression) visit(ctx.expression()));

        return statement;
    }

    @Override
    public Object visitWhileStatement(ReactjsParser.WhileStatementContext ctx) {
        WhileStatement whileStatement = new WhileStatement();

        whileStatement.setStatement((Statement) visit(ctx.statement()));

        whileStatement.setExpression((Expression) visit(ctx.expression()));
        return whileStatement;
    }

    @Override
    public ForStatement visitForStatement(ReactjsParser.ForStatementContext ctx) {
        symbolTable.enterScope();
        ForStatement forStatement = new ForStatement();

        List<Expression> expressions = new ArrayList<>();
        for (ReactjsParser.ExpressionContext expressionContext : ctx.expression()) {
            expressions.add((Expression) visit(expressionContext));
        }
        forStatement.setExpressions(expressions);

        if (ctx.variableStatement() != null) {
            forStatement.setVariableStatement((VariableStatement) visit(ctx.variableStatement()));
        }

        forStatement.setStatement((Statement) visit(ctx.statement()));
        symbolTable.exitScope();
        return forStatement;
    }

    @Override
    public Object visitForInStatement(ReactjsParser.ForInStatementContext ctx) {
        ForInStatement forInStatement = new ForInStatement();

        List<Expression> expressions = new ArrayList<>();
        for (ReactjsParser.ExpressionContext expressionContext : ctx.expression()) {

            expressions.add((Expression) visit(expressionContext));
        }
        forInStatement.setExpressions(expressions);

        if (ctx.variableStatement() != null) {
            forInStatement.setVariableStatement((VariableStatement) visit(ctx.variableStatement()));
        }

        forInStatement.setStatement((Statement) visit(ctx.statement()));

        return forInStatement;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    //-------------------- ReturnStatement ------------------------

    @Override
    public Object visitReturnExpression(ReactjsParser.ReturnExpressionContext ctx) {
        return visit(ctx.return_());
    }

    @Override
    public Object visitHtmlBody_R(ReactjsParser.HtmlBody_RContext ctx) {
        ReturnExpression returnExpression = new ReturnExpression();
        if (ctx.htmlBody() != null) {
            returnExpression.setHtmlBody((HtmlBody) visit(ctx.htmlBody()));
        }
        return returnExpression;
    }

    @Override
    public Object visitExpression_R(ReactjsParser.Expression_RContext ctx) {
        ReturnExpression returnExpression = new ReturnExpression();
        if (ctx.expression() != null) {
            returnExpression.setExpression((Expression) visit(ctx.expression()));
        }
        return returnExpression;
    }

    //-------------------------------------------------FunctionDeclartion-----------------------------------------------------

    @Override
    public Object visitNormalFunction_L(ReactjsParser.NormalFunction_LContext ctx) {
        return visitNormalFunction(ctx.normalFunction());
    }

    @Override
    public Object visitNormalFunction(ReactjsParser.NormalFunctionContext ctx) {
        semanticCheck.setFunctionComponentScope(semanticCheck.getFunctionComponentScope() + 1);

        NormalFunction normalFunction = new NormalFunction();

        normalFunction.setFunctionName(ctx.IDENTIFIER().toString());

        List<Expression> expressions = new ArrayList<>();
        for (ReactjsParser.ExpressionContext expressionContext : ctx.expression()) {
            expressions.add((Expression) visit(expressionContext));
        }
        normalFunction.setExpression(expressions);

        normalFunction.setBlockStatement((BlockStatement) visitBlock(ctx.block()));

        //semanticCheck.setOneDeclaredVariable(ctx.IDENTIFIER().toString(), symbolTable.getScopeId(), "function");
        normalFunction.performSemanticChecks(semanticCheck, symbolTable.getScopeId());

        // Symbol Table
        Row row = new Row();
        row.setLine(ctx.start.getLine());
        row.setScopeid(symbolTable.getScopeId());
        row.setVariableName(normalFunction.getFunctionName());
        row.setValue(normalFunction.getBlockStatement().toString());
        this.symbolTable.addVariable(row);

        // Symbol Table 2
        s.addVariable(normalFunction.getFunctionName(), normalFunction.getBlockStatement());

        semanticCheck.setFunctionComponentScope(semanticCheck.getFunctionComponentScope() - 1);
        return normalFunction;
    }


    @Override
    public Object visitAnoymousFunction_L(ReactjsParser.AnoymousFunction_LContext ctx) {
        return visitAnoymousFunction(ctx.anoymousFunction());
    }

    @Override
    public Object visitAnoymousFunction(ReactjsParser.AnoymousFunctionContext ctx) {
        semanticCheck.setFunctionComponentScope(semanticCheck.getFunctionComponentScope() + 1);

        AnonymousFunction anonymousFunction = new AnonymousFunction();

        List<Expression> expressions = new ArrayList<>();
        for (ReactjsParser.ExpressionContext expressionContext : ctx.expression()) {
            expressions.add((Expression) visit(expressionContext));
        }
        anonymousFunction.setExpression(expressions);

        anonymousFunction.setBlockStatement((BlockStatement) visitBlock(ctx.block()));

        anonymousFunction.setExpression(expressions);

        semanticCheck.setFunctionComponentScope(semanticCheck.getFunctionComponentScope() - 1);
        return anonymousFunction;
    }

    @Override
    public Object visitArrowFunction_L(ReactjsParser.ArrowFunction_LContext ctx) {
        return visitArrowFunction(ctx.arrowFunction());
    }

    @Override
    public Object visitArrowFunction(ReactjsParser.ArrowFunctionContext ctx) {
        semanticCheck.setFunctionComponentScope(semanticCheck.getFunctionComponentScope() + 1);

        ArrowFunction arrowFunction = new ArrowFunction();

        if (ctx.arrowParameters() != null)
            arrowFunction.setArrowParameters((ArrowParameters) visit(ctx.arrowParameters()));

        if (ctx.block() != null)
            arrowFunction.setBlockStatement((BlockStatement) visit(ctx.block()));
        else if (ctx.expression() != null)
            arrowFunction.setExpressionPar((Expression) visit(ctx.expression()));

        semanticCheck.setFunctionComponentScope(semanticCheck.getFunctionComponentScope() - 1);
        return arrowFunction;
    }

    //-------------------------------------FunctionCreateElemen----------------------------------


    @Override
    public Object visitFunctionCreateElement(ReactjsParser.FunctionCreateElementContext ctx) {

        FunctionCreateElement functionCreateElement = new FunctionCreateElement();

        if (ctx.value() != null) {
            functionCreateElement.setValue((Value) visitValue(ctx.value()));
        }
        if (ctx.objectDeclaration() != null) {
            functionCreateElement.setObjectDeclarationTY((ObjectDeclaration) visitObjectDeclaration(ctx.objectDeclaration()));
        }
        List<CreateFunctionParams> createFunctionParams = new ArrayList<>();
        for (ReactjsParser.FunctionthirdParamContext functionthirdParamContext : ctx.functionthirdParam()) {
            if (functionthirdParamContext != null) {
                createFunctionParams.add((CreateFunctionParams) visit(functionthirdParamContext));
            }
        }
        functionCreateElement.setFunctionThirdParam(createFunctionParams);
        return functionCreateElement;
    }

    //-------------------------FunctionCall-------------------------------------------------------------------

    @Override
    public Object visitFunctionCall(ReactjsParser.FunctionCallContext ctx) {
        FunctionCall functionCall = new FunctionCall();

        functionCall.setFunctionName(ctx.IDENTIFIER().toString());

        List<Expression> expressions = new ArrayList<>();
        for (ReactjsParser.ExpressionContext expressionContext : ctx.expression()) {
            expressions.add((Expression) visit(expressionContext));
        }
        functionCall.setExpressions(expressions);

        //semanticCheck.checkIfVariableUsedNotDefined(ctx.IDENTIFIER().toString(), symbolTable.getScopeId(), ctx.start.getLine());
        functionCall.performSemanticChecks(semanticCheck, symbolTable.getScopeId(), ctx.start.getLine());

        return functionCall;
    }

    //-------------------- Expression ------------------------


    @Override
    public Object visitFunctionExpression(ReactjsParser.FunctionExpressionContext ctx) {
        FunctionExpression functionExpression = new FunctionExpression();
        functionExpression.setFunctionDeclaration((FunctionDeclaration) visit(ctx.functionDeclartion()));
        return functionExpression;
    }

    @Override
    public Object visitFunctionCallExpression(ReactjsParser.FunctionCallExpressionContext ctx) {

        FunctionCallExpression functionCallExpression = new FunctionCallExpression();
        functionCallExpression.setFunctionCall((FunctionCall) visitFunctionCall(ctx.functionCall()));


        return functionCallExpression;
    }

    @Override
    public Object visitArrayAcessExpression(ReactjsParser.ArrayAcessExpressionContext ctx) {
        ArrayAccessExpression arrayAccessExpression = new ArrayAccessExpression();

        arrayAccessExpression.setArrayDeclaration((ArrayAccess) visit(ctx.arrayAccess()));

        s.addVariable(arrayAccessExpression.getArrayDeclaration().getIndex().toString(), arrayAccessExpression.getArrayDeclaration().getArrayName());
        return arrayAccessExpression;
    }

    @Override
    public MemberDotExpression visitMemberDotExpression(ReactjsParser.MemberDotExpressionContext ctx) {
        MemberDotExpression memberDotExpression = new MemberDotExpression();

        semanticCheck.setOneDeclaredVariable(ctx.expression(1).getText(), symbolTable.getScopeId(), "MemberDotExpression");
        //memberDotExpression.performSemanticChecks(semanticCheck, symbolTable.getScopeId(), ctx.start.getLine());

        Expression leftExpression = (Expression) visit(ctx.expression(0));
        Expression rightExpression = (Expression) visit(ctx.expression(1));
        boolean isOptionalChaining = ctx.QUESTION_MARK() != null;

        memberDotExpression.setLeftExpression(leftExpression);
        memberDotExpression.setRightExpression(rightExpression);
        memberDotExpression.setOptionalChaining(isOptionalChaining);

        return memberDotExpression;
    }

    //////////////////////////////////////////////////////////////////
    @Override
    public PostIncrementExpression visitPostIncrementExpression(ReactjsParser.PostIncrementExpressionContext ctx) {

        PostIncrementExpression postIncrementExpression = new PostIncrementExpression();

        Expression expression = (Expression) visit(ctx.expression());

        postIncrementExpression.setExpression(expression);

        return postIncrementExpression;
    }


    //////////////////////////////////////////////////////////////////


    @Override
    public PostDecreaseExpression visitPostDecreaseExpression(ReactjsParser.PostDecreaseExpressionContext ctx) {
        PostDecreaseExpression postDecreaseExpression = new PostDecreaseExpression();

        Expression expression = (Expression) visit(ctx.expression());

        postDecreaseExpression.setExpression(expression);

        return postDecreaseExpression;
    }

    //////////////////////////////////////////////////////////////////

    @Override
    public PreIncrementExpression visitPreIncrementExpression(ReactjsParser.PreIncrementExpressionContext ctx) {
        PreIncrementExpression preIncrementExpression = new PreIncrementExpression();

        Expression expression = (Expression) visit(ctx.expression());

        preIncrementExpression.setExpression(expression);

        return preIncrementExpression;
    }


    //////////////////////////////////////////////////////////////////


    @Override
    public PreDecreaseExpression visitPreDecreaseExpression(ReactjsParser.PreDecreaseExpressionContext ctx) {
        PreDecreaseExpression preDecreaseExpression = new PreDecreaseExpression();

        Expression expression = (Expression) visit(ctx.expression());

        preDecreaseExpression.setExpression(expression);

        return preDecreaseExpression;
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public NotExpression visitNotExpression(ReactjsParser.NotExpressionContext ctx) {

        Expression expression = (Expression) visit(ctx.expression());

        return new NotExpression(expression);
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public MultiplicativeExpression visitMultiplicativeExpression(ReactjsParser.MultiplicativeExpressionContext ctx) {
        Expression leftExpression = (Expression) visit(ctx.expression(0));
        Expression rightExpression = (Expression) visit(ctx.expression(1));
        String operator = null;
        if (ctx.DIV() != null) {
            operator = ctx.DIV().toString();
        } else if (ctx.MULTIPLY() != null) {
            operator = ctx.MULTIPLY().toString();
        } else if (ctx.DIV() != null) {
            operator = ctx.MODULUS().toString();
        }

        return new MultiplicativeExpression(leftExpression, rightExpression, operator);
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public AdditiveExpression visitAdditiveExpression(ReactjsParser.AdditiveExpressionContext ctx) {
        Expression leftExpression = (Expression) visit(ctx.expression(0));
        Expression rightExpression = (Expression) visit(ctx.expression(1));
        String operator = null;
        if (ctx.PLUS() != null) {
            operator = ctx.PLUS().toString();
        } else if (ctx.MINUS() != null) {
            operator = ctx.MINUS().toString();
        }

        return new AdditiveExpression(leftExpression, rightExpression, operator);
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public Object visitRelationalExpression(ReactjsParser.RelationalExpressionContext ctx) {
        Expression leftExpression = (Expression) visit(ctx.expression(0));
        Expression rightExpression = (Expression) visit(ctx.expression(1));

        String operator = null;
        if (ctx.LESS_THAN() != null) {
            operator = ctx.LESS_THAN().toString();
        } else if (ctx.GREATER_THAN() != null) {
            operator = ctx.GREATER_THAN().toString();
        } else if (ctx.LESS_THAN_EQUALS() != null) {
            operator = ctx.LESS_THAN_EQUALS().toString();
        } else if (ctx.GREATER_THAN_EQUALS() != null) {
            operator = ctx.GREATER_THAN_EQUALS().toString();
        }

        return new RelationalExpression(leftExpression, operator, rightExpression);
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public EqualityExpression visitEqualityExpression(ReactjsParser.EqualityExpressionContext ctx) {
        Expression leftExpression = (Expression) visit(ctx.expression(0));
        Expression rightExpression = (Expression) visit(ctx.expression(1));

        String operator = null;
        if (ctx.EQUALS() != null) {
            operator = ctx.EQUALS().toString();
        } else if (ctx.NOT_EQUALS() != null) {
            operator = ctx.NOT_EQUALS().toString();
        } else if (ctx.IDENTITY_EQUALS() != null) {
            operator = ctx.IDENTITY_EQUALS().toString();
        } else if (ctx.IDENTITY_NOT_EQUALS() != null) {
            operator = ctx.IDENTITY_NOT_EQUALS().toString();
        } else if (ctx.ASSING() != null) {
             semanticCheck.checkIfVariableIsConst(ctx.expression(0).getText(), ctx.start.getLine());
            //EqualityExpression equalityExpression = new EqualityExpression(leftExpression, operator, rightExpression);
            //equalityExpression.performSemanticCheck(semanticCheck, ctx.expression(0).getText() ,ctx.start.getLine());
            operator = ctx.ASSING().toString();
        }

        return new EqualityExpression(leftExpression, operator, rightExpression);
    }

    //////////////////////////////////////////////////////////////////
    @Override
    public LogicalAndExpression visitLogicalAndExpression(ReactjsParser.LogicalAndExpressionContext ctx) {
        Expression leftExpression = (Expression) visit(ctx.expression(0));
        Expression rightExpression = (Expression) visit(ctx.expression(1));

        return new LogicalAndExpression(leftExpression, rightExpression);
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public LogicalOrExpression visitLogicalOrExpression(ReactjsParser.LogicalOrExpressionContext ctx) {
        Expression leftExpression = (Expression) visit(ctx.expression(0));
        Expression rightExpression = (Expression) visit(ctx.expression(1));

        return new LogicalOrExpression(leftExpression, rightExpression);
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public TernaryExpression visitTernaryExpression(ReactjsParser.TernaryExpressionContext ctx) {
        Expression condition = (Expression) visit(ctx.expression(0));
        Expression trueExpression = (Expression) visit(ctx.expression(1));
        Expression falseExpression = (Expression) visit(ctx.expression(2));

        return new TernaryExpression(condition, trueExpression, falseExpression);
    }

    @Override
    public Object visitValueExpression(ReactjsParser.ValueExpressionContext ctx) {
        ValueExpression valueExpression = new ValueExpression();
        valueExpression.setValueDeclaration((Value) visitValue(ctx.value()));
        return valueExpression;
    }

    @Override
    public Object visitArrayExpression(ReactjsParser.ArrayExpressionContext ctx) {
        ArrayExpression arrayExpression = new ArrayExpression();
        arrayExpression.setArrayDeclaration((ArrayDeclaration) visit(ctx.arrayDeclaration()));
        return arrayExpression;
    }

    @Override
    public Object visitObjectExpression(ReactjsParser.ObjectExpressionContext ctx) {
        ObjectExpression objectExpression = new ObjectExpression();

        objectExpression.setObjectDeclaration((ObjectDeclaration) visit(ctx.objectDeclaration()));

        return objectExpression;

    }


    @Override
    public Object visitHookExpression(ReactjsParser.HookExpressionContext ctx) {
        semanticCheck.checkHooksTopLevel(symbolTable.getScopeId(), ctx.hook().getText(), ctx.start.getLine());
        return visit(ctx.hook());
    }

    @Override
    public Object visitUseStateHook_L(ReactjsParser.UseStateHook_LContext ctx) {
        return visitUseStateHook(ctx.useStateHook());
    }

    @Override
    public Object visitUseStateHook(ReactjsParser.UseStateHookContext ctx) {
        semanticCheck.checkIfHooksAreImported("UseState", ctx.start.getLine());
        UseStateHook useStateHook = new UseStateHook();
        List<Value> values = new ArrayList<>();
        for (ReactjsParser.ValueContext valueContext : ctx.value()) {
            values.add((Value) visitValue(valueContext));
        }
        useStateHook.setValues(values);
        return useStateHook;
    }


    @Override
    public Object visitUseEffectHook_L(ReactjsParser.UseEffectHook_LContext ctx) {
        return visitUseEffectHook(ctx.useEffectHook());
    }

    @Override
    public Object visitUseEffectHook(ReactjsParser.UseEffectHookContext ctx) {
        semanticCheck.checkIfHooksAreImported("UseEffect", ctx.start.getLine());

        UseEffectHook useEffectHook = new UseEffectHook();

        useEffectHook.setArrayDeclaration((ArrayDeclaration) visitArrayDeclaration(ctx.arrayDeclaration()));
        useEffectHook.setArrowFunction((ArrowFunction) visitArrowFunction(ctx.arrowFunction()));

        return useEffectHook;
    }


    @Override
    public Object visitUseRefHook_L(ReactjsParser.UseRefHook_LContext ctx) {
        return visit(ctx.useRefHook());
    }

    @Override
    public Object visitUseRefHook_value(ReactjsParser.UseRefHook_valueContext ctx) {
        semanticCheck.checkIfHooksAreImported("UseRef", ctx.start.getLine());

        UseRefHook useRefHook = new UseRefHook();
        List<Value> values = new ArrayList<>();
        for (ReactjsParser.ValueContext valueContext : ctx.value()) {
            values.add((Value) visitValue(valueContext));
        }
        useRefHook.setValues(values);
        return useRefHook;

    }

    @Override
    public Object visitUseRefHook_value_IDENTIFIER(ReactjsParser.UseRefHook_value_IDENTIFIERContext ctx) {
        UseRefHook useRefHook = new UseRefHook();
        useRefHook.setRefIdentifier(ctx.IDENTIFIER().toString());
        List<Value> values = new ArrayList<>();
        for (ReactjsParser.ValueContext valueContext : ctx.value()) {
            values.add((Value) visitValue(valueContext));
        }
        useRefHook.setValues(values);
        return useRefHook;
    }

    @Override
    public Object visitFunctionCreateElementExpression(ReactjsParser.FunctionCreateElementExpressionContext ctx) {
        semanticCheck.checkIfHooksAreImported("CreateElement", ctx.start.getLine());

        FunctionCreateElementExpression f = new FunctionCreateElementExpression();

        f.setFunctionCreateElement((FunctionCreateElement) visit(ctx.functionCreateElement()));

        return f;
    }


    @Override
    public Object visitVarHelpers(ReactjsParser.VarHelpersContext ctx) {
        VarHelper varHelper = new VarHelper();
        if (ctx.VAR() != null)
            varHelper.setType(ctx.VAR().toString());
        else if (ctx.LET() != null)
            varHelper.setType(ctx.LET().toString());
        return varHelper;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public Object visitValueArrow(ReactjsParser.ValueArrowContext ctx) {
        return visitValue(ctx.value());
    }

    @Override
    public Object visitExpressionArrow(ReactjsParser.ExpressionArrowContext ctx) {

        ExpressionPar expressionPar = new ExpressionPar();

        List<Expression> expressions = new ArrayList<>();
        for (ReactjsParser.ExpressionContext expressionContext : ctx.expression()) {
            semanticCheck.setOneDeclaredVariable(expressionContext.getText(), symbolTable.getScopeId(), "expression arrow");
            expressions.add((Expression) visit(expressionContext));
        }
        expressionPar.setExpression(expressions);

        return expressionPar;
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public Object visitHtmlBodyExpression(ReactjsParser.HtmlBodyExpressionContext ctx) {
        HtmlBodyExpression htmlBodyExpression = new HtmlBodyExpression();
        htmlBodyExpression.setHtmlBody((HtmlBody) visit(ctx.htmlBody()));
        return htmlBodyExpression;
    }

    @Override
    public Object visitHtmlBodyWithDiv_L(ReactjsParser.HtmlBodyWithDiv_LContext ctx) {
        return visitHtmlBodyWithDiv(ctx.htmlBodyWithDiv());
    }

    @Override
    public Object visitHtmlBodyWithDiv(ReactjsParser.HtmlBodyWithDivContext ctx) {
        HtmlBodyWithDiv htmlBodyWithDiv = new HtmlBodyWithDiv();

        if (ctx.IDENTIFIER(0) != null) {
            htmlBodyWithDiv.setOpenTagName(ctx.IDENTIFIER(0).toString());
        }
        List<JsxAttribute> jsxAttributes = new ArrayList<>();
        for (ReactjsParser.JsxAttributeContext jsxAttributeContext : ctx.jsxAttribute()) {
            if (jsxAttributeContext != null) {
                jsxAttributes.add((JsxAttribute) visit(jsxAttributeContext));
            }
        }
        htmlBodyWithDiv.setJsxAttributes(jsxAttributes);

        if (ctx.jsxContent() != null) {
            JsxContent jsxContent = (JsxContent) visitJsxContent(ctx.jsxContent());
            htmlBodyWithDiv.setJsxContent(jsxContent);
        }

        if (ctx.IDENTIFIER(1) != null) {
            htmlBodyWithDiv.setCloseTagName(ctx.IDENTIFIER(1).toString());
        }

        htmlBodyWithDiv.validateTags(semanticCheck, ctx.start.getLine());

        /*if (ctx.IDENTIFIER(0) == null && ctx.IDENTIFIER(1) == null) {
            htmlBodyWithDiv.checkIfTwoTagsAreNotEquals(semanticCheck, "", "", ctx.start.getLine());
            //semanticCheck.checkIfTwoTagsAreNotEquals("", "", ctx.start.getLine());
        } else if (ctx.IDENTIFIER(0) == null) {
            htmlBodyWithDiv.checkIfTwoTagsAreNotEquals(semanticCheck, "", ctx.IDENTIFIER(1).toString(), ctx.start.getLine());
            //semanticCheck.checkIfTwoTagsAreNotEquals("", ctx.IDENTIFIER(1).toString(), ctx.start.getLine());
        } else if (ctx.IDENTIFIER(1) == null) {
            htmlBodyWithDiv.checkIfTwoTagsAreNotEquals(semanticCheck, ctx.IDENTIFIER(0).toString(), "", ctx.start.getLine());
            // semanticCheck.checkIfTwoTagsAreNotEquals(ctx.IDENTIFIER(0).toString(), "", ctx.start.getLine());
        } else {
            htmlBodyWithDiv.checkIfTwoTagsAreNotEquals(semanticCheck, ctx.IDENTIFIER(0).toString(), ctx.IDENTIFIER(1).toString(), ctx.start.getLine());
            // semanticCheck.checkIfTwoTagsAreNotEquals(ctx.IDENTIFIER(0).toString(), ctx.IDENTIFIER(1).toString(), ctx.start.getLine());
        }*/
        return htmlBodyWithDiv;
    }

    @Override
    public Object visitHtmlBodyNestedDiv_L(ReactjsParser.HtmlBodyNestedDiv_LContext ctx) {
        return visitHtmlBodyNestedDiv(ctx.htmlBodyNestedDiv());
    }

    @Override
    public Object visitHtmlBodyNestedDiv(ReactjsParser.HtmlBodyNestedDivContext ctx) {

        HtmlBodyNestedDiv htmlBodyNestedDiv = new HtmlBodyNestedDiv();

        htmlBodyNestedDiv.setTagName(ctx.IDENTIFIER().toString());

        List<JsxAttribute> jsxAttributes = new ArrayList<>();
        for (ReactjsParser.JsxAttributeContext jsxAttributeContext : ctx.jsxAttribute()) {
            if (jsxAttributeContext != null) {
                jsxAttributes.add((JsxAttribute) visit(jsxAttributeContext));
            }
        }
        htmlBodyNestedDiv.setJsxAttributes(jsxAttributes);

        if (ctx.jsxContent() != null) {
            htmlBodyNestedDiv.setJsxContent((JsxContent) visitJsxContent(ctx.jsxContent()));
        }
        return htmlBodyNestedDiv;
    }

    @Override
    public Object visitHtmlBodyDivAlone_L(ReactjsParser.HtmlBodyDivAlone_LContext ctx) {
        return visitHtmlBodyDivAlone(ctx.htmlBodyDivAlone());
    }

    @Override
    public Object visitHtmlBodyDivAlone(ReactjsParser.HtmlBodyDivAloneContext ctx) {

        HtmlBodyDivAlone htmlBodyDivAlone = new HtmlBodyDivAlone();

        htmlBodyDivAlone.setTageName(ctx.IDENTIFIER().toString());

        List<JsxAttribute> jsxAttributes = new ArrayList<>();
        for (ReactjsParser.JsxAttributeContext jsxAttributeContext : ctx.jsxAttribute()) {
            jsxAttributes.add((JsxAttribute) visit(jsxAttributeContext));
        }
        htmlBodyDivAlone.setJsxAttributes(jsxAttributes);

        return htmlBodyDivAlone;
    }

    @Override
    public Object visitHtmlBodyNoDiv_L(ReactjsParser.HtmlBodyNoDiv_LContext ctx) {
        return visitHtmlBodyNoDiv(ctx.htmlBodyNoDiv());
    }

    @Override
    public Object visitHtmlBodyNoDiv(ReactjsParser.HtmlBodyNoDivContext ctx) {
        HtmlBodyNoDiv htmlBodyNoDiv = new HtmlBodyNoDiv();

        htmlBodyNoDiv.setTageName(ctx.IDENTIFIER().toString());


        List<JsxAttribute> jsxAttributes = new ArrayList<>();
        for (ReactjsParser.JsxAttributeContext jsxAttributeContext : ctx.jsxAttribute()) {
            jsxAttributes.add((JsxAttribute) visit(jsxAttributeContext));
        }
        htmlBodyNoDiv.setJsxAttributes(jsxAttributes);
        return htmlBodyNoDiv;
    }

    @Override
    public Object visitParenthesizedExpression(ReactjsParser.ParenthesizedExpressionContext ctx) {

        ParenthesizedExpression parenthesizedExpression = new ParenthesizedExpression();
        parenthesizedExpression.setExpression((Expression) visit(ctx.expression()));

        return parenthesizedExpression;
    }

    @Override
    public Object visitFunctionthirdParam(ReactjsParser.FunctionthirdParamContext ctx) {
        CreateFunctionParams createFunctionParams = new CreateFunctionParams();
        if (ctx.functionCreateElement() != null) {
            createFunctionParams.setFunctionCreateElement((FunctionCreateElement) visit(ctx.functionCreateElement()));
        } else if (ctx.value() != null) {
            createFunctionParams.setValue((Value) visitValue(ctx.value()));
        }
        return createFunctionParams;
    }

    @Override
    public Object visitJsxContent(ReactjsParser.JsxContentContext ctx) {
        JsxContent jsxContent = new JsxContent();

        List<JsxText> jsxTexts = new ArrayList<>();
        for (ReactjsParser.JsxTextContext jsxTextContext : ctx.jsxText()) {
            if (jsxTextContext != null) {
                jsxTexts.add((JsxText) visitJsxText(jsxTextContext));
            }
        }
        jsxContent.setTextElements(jsxTexts);

        List<HtmlBody> htmlBodies = new ArrayList<>();
        for (ReactjsParser.HtmlBodyContext htmlBodyContext : ctx.htmlBody()) {
            if (htmlBodyContext != null) {
                htmlBodies.add((HtmlBody) visit(htmlBodyContext));
            }
        }
        jsxContent.setHtmlBodies(htmlBodies);

        List<JsxExpression> jsxExpressions = new ArrayList<>();
        for (ReactjsParser.JsxExpressionContext jsxExpressionContext : ctx.jsxExpression()) {
            if (jsxExpressionContext != null) {
                jsxExpressions.add((JsxExpression) visit(jsxExpressionContext));
            }
        }
        jsxContent.setExpressions(jsxExpressions);

        return jsxContent;
    }

    @Override
    public Object visitJsxExpression(ReactjsParser.JsxExpressionContext ctx) {
        JsxExpression jsxExpression = new JsxExpression();

        List<Expression> expressions = new ArrayList<>();
        for (ReactjsParser.ExpressionContext expressionContext : ctx.expression()) {
            expressions.add((Expression) visit(expressionContext));
        }
        jsxExpression.setExpressions(expressions);

        return jsxExpression;
    }

    @Override
    public Object visitJsxText(ReactjsParser.JsxTextContext ctx) {

        JsxText jsxText = new JsxText();

        jsxText.setText(ctx.getText());

        return jsxText;
    }


    @Override
    public Object visitJsxAtteibute_Object(ReactjsParser.JsxAtteibute_ObjectContext ctx) {

        JsxAttribute jsxAttribute = new JsxAttribute();
        jsxAttribute.setJsxAttributeName(ctx.IDENTIFIER().toString());
        jsxAttribute.setObjectDeclaration((ObjectDeclaration) visitObjectDeclaration(ctx.objectDeclaration()));
        return jsxAttribute;

    }

    @Override
    public Object visitJsxAtteibute_String(ReactjsParser.JsxAtteibute_StringContext ctx) {
        JsxAttribute jsxAttribute = new JsxAttribute();
        jsxAttribute.setJsxAttributeName(ctx.IDENTIFIER().toString());
        jsxAttribute.setString(ctx.STRING().toString());
        return jsxAttribute;
    }

    @Override
    public Object visitJsxAtteibute_Identifier(ReactjsParser.JsxAtteibute_IdentifierContext ctx) {
        JsxAttribute jsxAttribute = new JsxAttribute();
        jsxAttribute.setJsxAttributeName(ctx.IDENTIFIER().toString());
        return jsxAttribute;
    }


    @Override
    public Object visitValue(ReactjsParser.ValueContext ctx) {

        Value value = new Value();
        if (ctx.STRING() != null) {
            value.setType("String");
            value.setValue(ctx.STRING().getText());
            //SymbolTable.value.add(ctx.STRING().toString());
        } else if (ctx.TEMPLATE_LITERAL() != null) {
            value.setType("Literal");
            value.setValue(ctx.TEMPLATE_LITERAL().getText());
        } else if (ctx.NUMBER() != null) {
            value.setType("Number");
            value.setValue(ctx.NUMBER().getText());
            //SymbolTable.value.add(ctx.NUMBER().toString());
        } else if (ctx.BOOLEAN() != null) {
            value.setType("Boolean");
            value.setValue(ctx.BOOLEAN().getText());
        } else if (ctx.NULL() != null) {
            value.setType("Null");
            value.setValue(ctx.NULL().getText());
        } else if (ctx.UNDEFINED() != null) {
            value.setType("Undefined");
            value.setValue(ctx.UNDEFINED().getText());
        } else if (ctx.IDENTIFIER() != null) {
            value.setType("Identifier");
            value.setValue(ctx.IDENTIFIER().getText());
            //semanticCheck.checkIfVariableUsedNotDefined(ctx.IDENTIFIER().getText(), symbolTable.getScopeId(), ctx.start.getLine());
        }

        value.validate(semanticCheck, symbolTable.getScopeId(), ctx.start.getLine());

        return value;

    }


    //-------------------- Test ------------------------
    /*@Override
    public Object visitTestSt(ReactjsParser.TestStContext ctx) {
        return visitTest(ctx.test());
    }


    @Override
    public Object visitTest(ReactjsParser.TestContext ctx)
    {
       Test test =new Test();

       test.setString(ctx.STRING().toString());

        List<Statement> st = new ArrayList<>();
        for (ReactjsParser.StatementContext stat : ctx.statement())
        {

            st.add((Statement) visit(stat));
        }
        test.setStatements(st);
        return test;
    }*/
}