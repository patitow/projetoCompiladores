// Generated from bananaScript.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link bananaScriptParser}.
 */
public interface bananaScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link bananaScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(bananaScriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link bananaScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(bananaScriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Group}
	 * labeled alternative in {@link bananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterGroup(bananaScriptParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link bananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitGroup(bananaScriptParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Op}
	 * labeled alternative in {@link bananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterOp(bananaScriptParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Op}
	 * labeled alternative in {@link bananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitOp(bananaScriptParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link bananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVar(bananaScriptParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link bananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVar(bananaScriptParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Const}
	 * labeled alternative in {@link bananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterConst(bananaScriptParser.ConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Const}
	 * labeled alternative in {@link bananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitConst(bananaScriptParser.ConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atrib}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterAtrib(bananaScriptParser.AtribContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atrib}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitAtrib(bananaScriptParser.AtribContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterPrint(bananaScriptParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitPrint(bananaScriptParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Seq}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterSeq(bananaScriptParser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Seq}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitSeq(bananaScriptParser.SeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterIf(bananaScriptParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitIf(bananaScriptParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterWhile(bananaScriptParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link bananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitWhile(bananaScriptParser.WhileContext ctx);
}