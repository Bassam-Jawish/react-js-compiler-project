// Generated from C:/Users/mahmoud/Desktop/CompilerReactJs/src/antlr/ReactjsParser.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ReactjsParser}.
 */
public interface ReactjsParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ReactjsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ReactjsParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockSt(ReactjsParser.BlockStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockSt(ReactjsParser.BlockStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatementSt(ReactjsParser.PrintStatementStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatementSt(ReactjsParser.PrintStatementStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAccessSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessSt(ReactjsParser.ArrayAccessStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAccessSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessSt(ReactjsParser.ArrayAccessStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatementSt(ReactjsParser.VariableStatementStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatementSt(ReactjsParser.VariableStatementStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatementSt(ReactjsParser.ImportStatementStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatementSt(ReactjsParser.ImportStatementStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExportStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExportStatementSt(ReactjsParser.ExportStatementStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExportStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExportStatementSt(ReactjsParser.ExportStatementStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassDeclarationSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclarationSt(ReactjsParser.ClassDeclarationStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassDeclarationSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclarationSt(ReactjsParser.ClassDeclarationStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatementSt(ReactjsParser.IfStatementStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatementSt(ReactjsParser.IfStatementStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IterationStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatementSt(ReactjsParser.IterationStatementStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IterationStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatementSt(ReactjsParser.IterationStatementStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStatmentSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatmentSt(ReactjsParser.ReturnStatmentStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStatmentSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatmentSt(ReactjsParser.ReturnStatmentStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclartionSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclartionSt(ReactjsParser.FunctionDeclartionStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclartionSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclartionSt(ReactjsParser.FunctionDeclartionStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCreateElementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCreateElementSt(ReactjsParser.FunctionCreateElementStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCreateElementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCreateElementSt(ReactjsParser.FunctionCreateElementStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallSt(ReactjsParser.FunctionCallStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallSt(ReactjsParser.FunctionCallStContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSt(ReactjsParser.ExpressionStContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSt(ReactjsParser.ExpressionStContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ReactjsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ReactjsParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(ReactjsParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(ReactjsParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(ReactjsParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(ReactjsParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(ReactjsParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(ReactjsParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportDefaultSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDefaultSpecifier_L(ReactjsParser.ImportDefaultSpecifier_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportDefaultSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDefaultSpecifier_L(ReactjsParser.ImportDefaultSpecifier_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportNamespaceSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportNamespaceSpecifier_L(ReactjsParser.ImportNamespaceSpecifier_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportNamespaceSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportNamespaceSpecifier_L(ReactjsParser.ImportNamespaceSpecifier_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportNamedSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportNamedSpecifier_L(ReactjsParser.ImportNamedSpecifier_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportNamedSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportNamedSpecifier_L(ReactjsParser.ImportNamedSpecifier_LContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#importDefaultSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterImportDefaultSpecifier(ReactjsParser.ImportDefaultSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#importDefaultSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitImportDefaultSpecifier(ReactjsParser.ImportDefaultSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#importNamespaceSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterImportNamespaceSpecifier(ReactjsParser.ImportNamespaceSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#importNamespaceSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitImportNamespaceSpecifier(ReactjsParser.ImportNamespaceSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#importNamedSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterImportNamedSpecifier(ReactjsParser.ImportNamedSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#importNamedSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitImportNamedSpecifier(ReactjsParser.ImportNamedSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterImportSpecifier(ReactjsParser.ImportSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitImportSpecifier(ReactjsParser.ImportSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExportDefaultDeclaration_L}
	 * labeled alternative in {@link ReactjsParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void enterExportDefaultDeclaration_L(ReactjsParser.ExportDefaultDeclaration_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExportDefaultDeclaration_L}
	 * labeled alternative in {@link ReactjsParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void exitExportDefaultDeclaration_L(ReactjsParser.ExportDefaultDeclaration_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExportDeclaration_L}
	 * labeled alternative in {@link ReactjsParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void enterExportDeclaration_L(ReactjsParser.ExportDeclaration_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExportDeclaration_L}
	 * labeled alternative in {@link ReactjsParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void exitExportDeclaration_L(ReactjsParser.ExportDeclaration_LContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#exportDefaultDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExportDefaultDeclaration(ReactjsParser.ExportDefaultDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#exportDefaultDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExportDefaultDeclaration(ReactjsParser.ExportDefaultDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#exportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExportDeclaration(ReactjsParser.ExportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#exportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExportDeclaration(ReactjsParser.ExportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(ReactjsParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(ReactjsParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclarationVr}
	 * labeled alternative in {@link ReactjsParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationVr(ReactjsParser.VariableDeclarationVrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclarationVr}
	 * labeled alternative in {@link ReactjsParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationVr(ReactjsParser.VariableDeclarationVrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclarationConstVr}
	 * labeled alternative in {@link ReactjsParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationConstVr(ReactjsParser.VariableDeclarationConstVrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclarationConstVr}
	 * labeled alternative in {@link ReactjsParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationConstVr(ReactjsParser.VariableDeclarationConstVrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#variableDeclarationConst}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationConst(ReactjsParser.VariableDeclarationConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#variableDeclarationConst}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationConst(ReactjsParser.VariableDeclarationConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ReactjsParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ReactjsParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentidierVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 */
	void enterIdentidierVt(ReactjsParser.IdentidierVtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentidierVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 */
	void exitIdentidierVt(ReactjsParser.IdentidierVtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayDeclarationVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclarationVt(ReactjsParser.ArrayDeclarationVtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayDeclarationVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclarationVt(ReactjsParser.ArrayDeclarationVtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectDeclarationVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 */
	void enterObjectDeclarationVt(ReactjsParser.ObjectDeclarationVtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectDeclarationVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 */
	void exitObjectDeclarationVt(ReactjsParser.ObjectDeclarationVtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#objectDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterObjectDeclaration(ReactjsParser.ObjectDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#objectDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitObjectDeclaration(ReactjsParser.ObjectDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionObjectProperty}
	 * labeled alternative in {@link ReactjsParser#objectProperty}.
	 * @param ctx the parse tree
	 */
	void enterExpressionObjectProperty(ReactjsParser.ExpressionObjectPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionObjectProperty}
	 * labeled alternative in {@link ReactjsParser#objectProperty}.
	 * @param ctx the parse tree
	 */
	void exitExpressionObjectProperty(ReactjsParser.ExpressionObjectPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionProperty}
	 * labeled alternative in {@link ReactjsParser#objectProperty}.
	 * @param ctx the parse tree
	 */
	void enterExpressionProperty(ReactjsParser.ExpressionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionProperty}
	 * labeled alternative in {@link ReactjsParser#objectProperty}.
	 * @param ctx the parse tree
	 */
	void exitExpressionProperty(ReactjsParser.ExpressionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(ReactjsParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(ReactjsParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HookExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHookExpression(ReactjsParser.HookExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HookExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHookExpression(ReactjsParser.HookExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(ReactjsParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(ReactjsParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(ReactjsParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(ReactjsParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(ReactjsParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(ReactjsParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(ReactjsParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(ReactjsParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(ReactjsParser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(ReactjsParser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAcessExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAcessExpression(ReactjsParser.ArrayAcessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAcessExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAcessExpression(ReactjsParser.ArrayAcessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(ReactjsParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(ReactjsParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(ReactjsParser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(ReactjsParser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(ReactjsParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(ReactjsParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberDotExpression(ReactjsParser.MemberDotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberDotExpression(ReactjsParser.MemberDotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(ReactjsParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(ReactjsParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecreaseExpression(ReactjsParser.PreDecreaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecreaseExpression(ReactjsParser.PreDecreaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(ReactjsParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(ReactjsParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlBodyExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyExpression(ReactjsParser.HtmlBodyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlBodyExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyExpression(ReactjsParser.HtmlBodyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(ReactjsParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(ReactjsParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCreateElementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCreateElementExpression(ReactjsParser.FunctionCreateElementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCreateElementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCreateElementExpression(ReactjsParser.FunctionCreateElementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecreaseExpression(ReactjsParser.PostDecreaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecreaseExpression(ReactjsParser.PostDecreaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpression(ReactjsParser.ValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpression(ReactjsParser.ValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(ReactjsParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(ReactjsParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(ReactjsParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(ReactjsParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjectExpression(ReactjsParser.ObjectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjectExpression(ReactjsParser.ObjectExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(ReactjsParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(ReactjsParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ReactjsParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ReactjsParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#elseIf}.
	 * @param ctx the parse tree
	 */
	void enterElseIf(ReactjsParser.ElseIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#elseIf}.
	 * @param ctx the parse tree
	 */
	void exitElseIf(ReactjsParser.ElseIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(ReactjsParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(ReactjsParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(ReactjsParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(ReactjsParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ReactjsParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ReactjsParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ReactjsParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ReactjsParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInStatement(ReactjsParser.ForInStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInStatement(ReactjsParser.ForInStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlBody_R}
	 * labeled alternative in {@link ReactjsParser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBody_R(ReactjsParser.HtmlBody_RContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlBody_R}
	 * labeled alternative in {@link ReactjsParser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBody_R(ReactjsParser.HtmlBody_RContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expression_R}
	 * labeled alternative in {@link ReactjsParser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void enterExpression_R(ReactjsParser.Expression_RContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expression_R}
	 * labeled alternative in {@link ReactjsParser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void exitExpression_R(ReactjsParser.Expression_RContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UseStateHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 */
	void enterUseStateHook_L(ReactjsParser.UseStateHook_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UseStateHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 */
	void exitUseStateHook_L(ReactjsParser.UseStateHook_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UseEffectHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 */
	void enterUseEffectHook_L(ReactjsParser.UseEffectHook_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UseEffectHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 */
	void exitUseEffectHook_L(ReactjsParser.UseEffectHook_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UseRefHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 */
	void enterUseRefHook_L(ReactjsParser.UseRefHook_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UseRefHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 */
	void exitUseRefHook_L(ReactjsParser.UseRefHook_LContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#useStateHook}.
	 * @param ctx the parse tree
	 */
	void enterUseStateHook(ReactjsParser.UseStateHookContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#useStateHook}.
	 * @param ctx the parse tree
	 */
	void exitUseStateHook(ReactjsParser.UseStateHookContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#useEffectHook}.
	 * @param ctx the parse tree
	 */
	void enterUseEffectHook(ReactjsParser.UseEffectHookContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#useEffectHook}.
	 * @param ctx the parse tree
	 */
	void exitUseEffectHook(ReactjsParser.UseEffectHookContext ctx);
	/**
	 * Enter a parse tree produced by the {@code useRefHook_value}
	 * labeled alternative in {@link ReactjsParser#useRefHook}.
	 * @param ctx the parse tree
	 */
	void enterUseRefHook_value(ReactjsParser.UseRefHook_valueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code useRefHook_value}
	 * labeled alternative in {@link ReactjsParser#useRefHook}.
	 * @param ctx the parse tree
	 */
	void exitUseRefHook_value(ReactjsParser.UseRefHook_valueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code useRefHook_value_IDENTIFIER}
	 * labeled alternative in {@link ReactjsParser#useRefHook}.
	 * @param ctx the parse tree
	 */
	void enterUseRefHook_value_IDENTIFIER(ReactjsParser.UseRefHook_value_IDENTIFIERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code useRefHook_value_IDENTIFIER}
	 * labeled alternative in {@link ReactjsParser#useRefHook}.
	 * @param ctx the parse tree
	 */
	void exitUseRefHook_value_IDENTIFIER(ReactjsParser.UseRefHook_value_IDENTIFIERContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ReactjsParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ReactjsParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#functionCreateElement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCreateElement(ReactjsParser.FunctionCreateElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#functionCreateElement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCreateElement(ReactjsParser.FunctionCreateElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#functionthirdParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionthirdParam(ReactjsParser.FunctionthirdParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#functionthirdParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionthirdParam(ReactjsParser.FunctionthirdParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 */
	void enterNormalFunction_L(ReactjsParser.NormalFunction_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 */
	void exitNormalFunction_L(ReactjsParser.NormalFunction_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnoymousFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 */
	void enterAnoymousFunction_L(ReactjsParser.AnoymousFunction_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnoymousFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 */
	void exitAnoymousFunction_L(ReactjsParser.AnoymousFunction_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrowFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunction_L(ReactjsParser.ArrowFunction_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrowFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunction_L(ReactjsParser.ArrowFunction_LContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#normalFunction}.
	 * @param ctx the parse tree
	 */
	void enterNormalFunction(ReactjsParser.NormalFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#normalFunction}.
	 * @param ctx the parse tree
	 */
	void exitNormalFunction(ReactjsParser.NormalFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#anoymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterAnoymousFunction(ReactjsParser.AnoymousFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#anoymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitAnoymousFunction(ReactjsParser.AnoymousFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#arrowFunction}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunction(ReactjsParser.ArrowFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#arrowFunction}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunction(ReactjsParser.ArrowFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueArrow}
	 * labeled alternative in {@link ReactjsParser#arrowParameters}.
	 * @param ctx the parse tree
	 */
	void enterValueArrow(ReactjsParser.ValueArrowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueArrow}
	 * labeled alternative in {@link ReactjsParser#arrowParameters}.
	 * @param ctx the parse tree
	 */
	void exitValueArrow(ReactjsParser.ValueArrowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionArrow}
	 * labeled alternative in {@link ReactjsParser#arrowParameters}.
	 * @param ctx the parse tree
	 */
	void enterExpressionArrow(ReactjsParser.ExpressionArrowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionArrow}
	 * labeled alternative in {@link ReactjsParser#arrowParameters}.
	 * @param ctx the parse tree
	 */
	void exitExpressionArrow(ReactjsParser.ExpressionArrowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlBodyWithDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyWithDiv_L(ReactjsParser.HtmlBodyWithDiv_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlBodyWithDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyWithDiv_L(ReactjsParser.HtmlBodyWithDiv_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlBodyNestedDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyNestedDiv_L(ReactjsParser.HtmlBodyNestedDiv_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlBodyNestedDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyNestedDiv_L(ReactjsParser.HtmlBodyNestedDiv_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlBodyDivAlone_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyDivAlone_L(ReactjsParser.HtmlBodyDivAlone_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlBodyDivAlone_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyDivAlone_L(ReactjsParser.HtmlBodyDivAlone_LContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlBodyNoDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyNoDiv_L(ReactjsParser.HtmlBodyNoDiv_LContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlBodyNoDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyNoDiv_L(ReactjsParser.HtmlBodyNoDiv_LContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#htmlBodyWithDiv}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyWithDiv(ReactjsParser.HtmlBodyWithDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#htmlBodyWithDiv}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyWithDiv(ReactjsParser.HtmlBodyWithDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#htmlBodyNestedDiv}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyNestedDiv(ReactjsParser.HtmlBodyNestedDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#htmlBodyNestedDiv}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyNestedDiv(ReactjsParser.HtmlBodyNestedDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#htmlBodyDivAlone}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyDivAlone(ReactjsParser.HtmlBodyDivAloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#htmlBodyDivAlone}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyDivAlone(ReactjsParser.HtmlBodyDivAloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#htmlBodyNoDiv}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBodyNoDiv(ReactjsParser.HtmlBodyNoDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#htmlBodyNoDiv}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBodyNoDiv(ReactjsParser.HtmlBodyNoDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#jsxContent}.
	 * @param ctx the parse tree
	 */
	void enterJsxContent(ReactjsParser.JsxContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#jsxContent}.
	 * @param ctx the parse tree
	 */
	void exitJsxContent(ReactjsParser.JsxContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#jsxExpression}.
	 * @param ctx the parse tree
	 */
	void enterJsxExpression(ReactjsParser.JsxExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#jsxExpression}.
	 * @param ctx the parse tree
	 */
	void exitJsxExpression(ReactjsParser.JsxExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#jsxText}.
	 * @param ctx the parse tree
	 */
	void enterJsxText(ReactjsParser.JsxTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#jsxText}.
	 * @param ctx the parse tree
	 */
	void exitJsxText(ReactjsParser.JsxTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JsxAtteibute_Object}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 */
	void enterJsxAtteibute_Object(ReactjsParser.JsxAtteibute_ObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JsxAtteibute_Object}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 */
	void exitJsxAtteibute_Object(ReactjsParser.JsxAtteibute_ObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JsxAtteibute_String}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 */
	void enterJsxAtteibute_String(ReactjsParser.JsxAtteibute_StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JsxAtteibute_String}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 */
	void exitJsxAtteibute_String(ReactjsParser.JsxAtteibute_StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JsxAtteibute_Identifier}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 */
	void enterJsxAtteibute_Identifier(ReactjsParser.JsxAtteibute_IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JsxAtteibute_Identifier}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 */
	void exitJsxAtteibute_Identifier(ReactjsParser.JsxAtteibute_IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#varHelpers}.
	 * @param ctx the parse tree
	 */
	void enterVarHelpers(ReactjsParser.VarHelpersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#varHelpers}.
	 * @param ctx the parse tree
	 */
	void exitVarHelpers(ReactjsParser.VarHelpersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactjsParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ReactjsParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactjsParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ReactjsParser.ValueContext ctx);
}