// Generated from C:/compiler/react-js-compiler-project/src/antlr/ReactjsParser.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ReactjsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ReactjsParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ReactjsParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSt(ReactjsParser.BlockStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatementSt(ReactjsParser.PrintStatementStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAccessSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessSt(ReactjsParser.ArrayAccessStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatementSt(ReactjsParser.VariableStatementStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatementSt(ReactjsParser.ImportStatementStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportStatementSt(ReactjsParser.ExportStatementStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassDeclarationSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclarationSt(ReactjsParser.ClassDeclarationStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatementSt(ReactjsParser.IfStatementStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IterationStatementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatementSt(ReactjsParser.IterationStatementStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclartionSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclartionSt(ReactjsParser.FunctionDeclartionStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCreateElementSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCreateElementSt(ReactjsParser.FunctionCreateElementStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallSt(ReactjsParser.FunctionCallStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionSt}
	 * labeled alternative in {@link ReactjsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSt(ReactjsParser.ExpressionStContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ReactjsParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(ReactjsParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(ReactjsParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(ReactjsParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportDefaultSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDefaultSpecifier_L(ReactjsParser.ImportDefaultSpecifier_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportNamespaceSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportNamespaceSpecifier_L(ReactjsParser.ImportNamespaceSpecifier_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportNamedSpecifier_L}
	 * labeled alternative in {@link ReactjsParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportNamedSpecifier_L(ReactjsParser.ImportNamedSpecifier_LContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#importDefaultSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDefaultSpecifier(ReactjsParser.ImportDefaultSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#importNamespaceSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportNamespaceSpecifier(ReactjsParser.ImportNamespaceSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#importNamedSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportNamedSpecifier(ReactjsParser.ImportNamedSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#importSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpecifier(ReactjsParser.ImportSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportDefaultDeclaration_L}
	 * labeled alternative in {@link ReactjsParser#exportStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDefaultDeclaration_L(ReactjsParser.ExportDefaultDeclaration_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportDeclaration_L}
	 * labeled alternative in {@link ReactjsParser#exportStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDeclaration_L(ReactjsParser.ExportDeclaration_LContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#exportDefaultDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDefaultDeclaration(ReactjsParser.ExportDefaultDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#exportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDeclaration(ReactjsParser.ExportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(ReactjsParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclarationVr}
	 * labeled alternative in {@link ReactjsParser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationVr(ReactjsParser.VariableDeclarationVrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclarationConstVr}
	 * labeled alternative in {@link ReactjsParser#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationConstVr(ReactjsParser.VariableDeclarationConstVrContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#variableDeclarationConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationConst(ReactjsParser.VariableDeclarationConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(ReactjsParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentidierVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentidierVt(ReactjsParser.IdentidierVtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayDeclarationVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclarationVt(ReactjsParser.ArrayDeclarationVtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectDeclarationVt}
	 * labeled alternative in {@link ReactjsParser#variableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDeclarationVt(ReactjsParser.ObjectDeclarationVtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#objectDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDeclaration(ReactjsParser.ObjectDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionObjectProperty}
	 * labeled alternative in {@link ReactjsParser#objectProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionObjectProperty(ReactjsParser.ExpressionObjectPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionProperty}
	 * labeled alternative in {@link ReactjsParser#objectProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionProperty(ReactjsParser.ExpressionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(ReactjsParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HookExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHookExpression(ReactjsParser.HookExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(ReactjsParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(ReactjsParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(ReactjsParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(ReactjsParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(ReactjsParser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayAcessExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAcessExpression(ReactjsParser.ArrayAcessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(ReactjsParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(ReactjsParser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(ReactjsParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDotExpression(ReactjsParser.MemberDotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(ReactjsParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecreaseExpression(ReactjsParser.PreDecreaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(ReactjsParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlBodyExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyExpression(ReactjsParser.HtmlBodyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(ReactjsParser.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(ReactjsParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCreateElementExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCreateElementExpression(ReactjsParser.FunctionCreateElementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecreaseExpression(ReactjsParser.PostDecreaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(ReactjsParser.ValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(ReactjsParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(ReactjsParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpression(ReactjsParser.ObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link ReactjsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(ReactjsParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ReactjsParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#elseIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIf(ReactjsParser.ElseIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(ReactjsParser.ElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(ReactjsParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(ReactjsParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(ReactjsParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link ReactjsParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInStatement(ReactjsParser.ForInStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlBody_R}
	 * labeled alternative in {@link ReactjsParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBody_R(ReactjsParser.HtmlBody_RContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression_R}
	 * labeled alternative in {@link ReactjsParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_R(ReactjsParser.Expression_RContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UseStateHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseStateHook_L(ReactjsParser.UseStateHook_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UseEffectHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseEffectHook_L(ReactjsParser.UseEffectHook_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UseRefHook_L}
	 * labeled alternative in {@link ReactjsParser#hook}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseRefHook_L(ReactjsParser.UseRefHook_LContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#useStateHook}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseStateHook(ReactjsParser.UseStateHookContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#useEffectHook}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseEffectHook(ReactjsParser.UseEffectHookContext ctx);
	/**
	 * Visit a parse tree produced by the {@code useRefHook_value}
	 * labeled alternative in {@link ReactjsParser#useRefHook}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseRefHook_value(ReactjsParser.UseRefHook_valueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code useRefHook_value_IDENTIFIER}
	 * labeled alternative in {@link ReactjsParser#useRefHook}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseRefHook_value_IDENTIFIER(ReactjsParser.UseRefHook_value_IDENTIFIERContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(ReactjsParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#functionCreateElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCreateElement(ReactjsParser.FunctionCreateElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#functionthirdParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionthirdParam(ReactjsParser.FunctionthirdParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFunction_L(ReactjsParser.NormalFunction_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnoymousFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnoymousFunction_L(ReactjsParser.AnoymousFunction_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrowFunction_L}
	 * labeled alternative in {@link ReactjsParser#functionDeclartion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunction_L(ReactjsParser.ArrowFunction_LContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#normalFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFunction(ReactjsParser.NormalFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#anoymousFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnoymousFunction(ReactjsParser.AnoymousFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#arrowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunction(ReactjsParser.ArrowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueArrow}
	 * labeled alternative in {@link ReactjsParser#arrowParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueArrow(ReactjsParser.ValueArrowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionArrow}
	 * labeled alternative in {@link ReactjsParser#arrowParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionArrow(ReactjsParser.ExpressionArrowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlBodyWithDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyWithDiv_L(ReactjsParser.HtmlBodyWithDiv_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlBodyNestedDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyNestedDiv_L(ReactjsParser.HtmlBodyNestedDiv_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlBodyDivAlone_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyDivAlone_L(ReactjsParser.HtmlBodyDivAlone_LContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlBodyNoDiv_L}
	 * labeled alternative in {@link ReactjsParser#htmlBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyNoDiv_L(ReactjsParser.HtmlBodyNoDiv_LContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#htmlBodyWithDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyWithDiv(ReactjsParser.HtmlBodyWithDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#htmlBodyNestedDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyNestedDiv(ReactjsParser.HtmlBodyNestedDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#htmlBodyDivAlone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyDivAlone(ReactjsParser.HtmlBodyDivAloneContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#htmlBodyNoDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlBodyNoDiv(ReactjsParser.HtmlBodyNoDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#jsxContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxContent(ReactjsParser.JsxContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#jsxExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxExpression(ReactjsParser.JsxExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#jsxText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxText(ReactjsParser.JsxTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JsxAtteibute_Object}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxAtteibute_Object(ReactjsParser.JsxAtteibute_ObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JsxAtteibute_String}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxAtteibute_String(ReactjsParser.JsxAtteibute_StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JsxAtteibute_Identifier}
	 * labeled alternative in {@link ReactjsParser#jsxAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxAtteibute_Identifier(ReactjsParser.JsxAtteibute_IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#varHelpers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarHelpers(ReactjsParser.VarHelpersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ReactjsParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ReactjsParser.ValueContext ctx);
}