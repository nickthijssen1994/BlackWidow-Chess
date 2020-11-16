package tests;

import com.chess.engine.classic.board.*;
import com.chess.pgn.*;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class TestPGNParser {

	private static void doTest(final String testFilePath) throws IOException {
		final URL url = Resources.getResource(testFilePath);
		final File testPGNFile = new File(url.getFile());
		PGNUtilities.persistPGNFile(testPGNFile);
	}

	@Test
	public void test1() throws IOException {
		doTest("tests/pgn/t1.pgn");
	}

	@Test
	public void test2() throws IOException {
		doTest("tests/pgn/t2.pgn");
	}

	@Test
	public void test3() throws IOException {
		doTest("tests/pgn/t3.pgn");
	}

	@Test
	public void test4() throws IOException {
		doTest("tests/pgn/t4.pgn");
	}

	@Test
	public void test5() throws IOException {
		doTest("tests/pgn/smallerTest.pgn");
	}

	@Test
	public void test6() throws IOException {
		doTest("tests/pgn/t6.pgn");
	}

	@Test
	public void test8() throws IOException {
		doTest("tests/pgn/t8.pgn");
	}

	@Test
	public void test9() throws IOException {
		doTest("tests/pgn/t9.pgn");
	}

	@Test
	public void testPawnPromotion() throws IOException {
		doTest("tests/pgn/queenPromotion.pgn");
	}

	@Test
	public void test10() throws IOException {
		doTest("tests/pgn/t10.pgn");
	}

	@Test
	public void test11() throws IOException {
		doTest("tests/pgn/bigTest.pgn");
	}

	@Test
	public void test12() throws IOException {
		doTest("tests/pgn/twic1047.pgn");
	}

	@Test
	public void test13() throws IOException {
		doTest("tests/pgn/twic1046.pgn");
	}

	@Test
	public void test14() throws IOException {
		doTest("tests/pgn/combined.pgn");
	}

	@Test
	public void test15() throws IOException {
		doTest("tests/pgn/c2012.pgn");
	}

	@Test
	public void testMax() throws IOException {
		int maxId = MySqlGamePersistence.get().getMaxGameRow();
		System.out.println("max id = " + maxId);
	}

	@Test
	public void testParens() throws ParsePGNException {

		final String gameText = "(+)-(-) (+)-(-) 1. e4 e6";
		final List<String> moves = PGNUtilities.processMoveText(gameText);
		assert (moves.size() == 2);

	}

	@Test
	public void testWithErol() throws IOException {
		final Board board = Board.createStandardBoard();
		final Move move = MySqlGamePersistence.get().getNextBestMove(board, board.currentPlayer(), "");
		final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
		final Move move2 = MySqlGamePersistence.get().getNextBestMove(moveTransition.getToBoard(),
				moveTransition.getToBoard().currentPlayer(), "e4");
		System.out.println("move 2 = " + move2);
	}
}
