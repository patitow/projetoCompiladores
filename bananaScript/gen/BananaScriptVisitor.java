// Generated from BananaScript.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BananaScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BananaScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BananaScriptParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(BananaScriptParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(BananaScriptParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#paramOptional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamOptional(BananaScriptParser.ParamOptionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#paramRecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamRecursive(BananaScriptParser.ParamRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(BananaScriptParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BananaScriptParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#funType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunType(BananaScriptParser.FunTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(BananaScriptParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BananaScriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(BananaScriptParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(BananaScriptParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(BananaScriptParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(BananaScriptParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(BananaScriptParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#tryCatchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryCatchStatement(BananaScriptParser.TryCatchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(BananaScriptParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(BananaScriptParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(BananaScriptParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(BananaScriptParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(BananaScriptParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(BananaScriptParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#functionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(BananaScriptParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#functionExpressionRecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpressionRecursive(BananaScriptParser.FunctionExpressionRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link BananaScriptParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(BananaScriptParser.PrintContext ctx);
}
