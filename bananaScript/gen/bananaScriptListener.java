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
	 * Enter a parse tree produced by the {@code Group}
	 * labeled alternative in {@link BananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterGroup(BananaScriptParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link BananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitGroup(BananaScriptParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Op}
	 * labeled alternative in {@link BananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterOp(BananaScriptParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Op}
	 * labeled alternative in {@link BananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitOp(BananaScriptParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link BananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVar(BananaScriptParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link BananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVar(BananaScriptParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Const}
	 * labeled alternative in {@link BananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterConst(BananaScriptParser.ConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Const}
	 * labeled alternative in {@link BananaScriptParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitConst(BananaScriptParser.ConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atrib}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterAtrib(BananaScriptParser.AtribContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atrib}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitAtrib(BananaScriptParser.AtribContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterPrint(BananaScriptParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitPrint(BananaScriptParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Seq}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterSeq(BananaScriptParser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Seq}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitSeq(BananaScriptParser.SeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterIf(BananaScriptParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitIf(BananaScriptParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void enterWhile(BananaScriptParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link BananaScriptParser#com}.
	 * @param ctx the parse tree
	 */
	void exitWhile(BananaScriptParser.WhileContext ctx);
}