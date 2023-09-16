// Generated from BananaScript.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BananaScriptParser}.
 */
public interface BananaScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BananaScriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BananaScriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(BananaScriptParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(BananaScriptParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(BananaScriptParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(BananaScriptParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#paramOptional}.
	 * @param ctx the parse tree
	 */
	void enterParamOptional(BananaScriptParser.ParamOptionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#paramOptional}.
	 * @param ctx the parse tree
	 */
	void exitParamOptional(BananaScriptParser.ParamOptionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#paramRecursive}.
	 * @param ctx the parse tree
	 */
	void enterParamRecursive(BananaScriptParser.ParamRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#paramRecursive}.
	 * @param ctx the parse tree
	 */
	void exitParamRecursive(BananaScriptParser.ParamRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(BananaScriptParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(BananaScriptParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BananaScriptParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BananaScriptParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#funType}.
	 * @param ctx the parse tree
	 */
	void enterFunType(BananaScriptParser.FunTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#funType}.
	 * @param ctx the parse tree
	 */
	void exitFunType(BananaScriptParser.FunTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(BananaScriptParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(BananaScriptParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BananaScriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BananaScriptParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(BananaScriptParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(BananaScriptParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(BananaScriptParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(BananaScriptParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(BananaScriptParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(BananaScriptParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#elsifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElsifStatement(BananaScriptParser.ElsifStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#elsifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElsifStatement(BananaScriptParser.ElsifStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(BananaScriptParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(BananaScriptParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(BananaScriptParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(BananaScriptParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchStatement(BananaScriptParser.TryCatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchStatement(BananaScriptParser.TryCatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(BananaScriptParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(BananaScriptParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(BananaScriptParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(BananaScriptParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(BananaScriptParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(BananaScriptParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(BananaScriptParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(BananaScriptParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(BananaScriptParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(BananaScriptParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#booleans}.
	 * @param ctx the parse tree
	 */
	void enterBooleans(BananaScriptParser.BooleansContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#booleans}.
	 * @param ctx the parse tree
	 */
	void exitBooleans(BananaScriptParser.BooleansContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(BananaScriptParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(BananaScriptParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(BananaScriptParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(BananaScriptParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(BananaScriptParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#functionExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(BananaScriptParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#functionExpressionRecursive}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpressionRecursive(BananaScriptParser.FunctionExpressionRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#functionExpressionRecursive}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpressionRecursive(BananaScriptParser.FunctionExpressionRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BananaScriptParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(BananaScriptParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link BananaScriptParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(BananaScriptParser.PrintContext ctx);
}