//import javax.swing.*;
public class alphaBetaChess {
	static String chessBoard[][] = {
			{ "r", "k", "b", "q", "a", "b", "k", "r" },
			{ "p", "p", "p", "p", "p", "p", "p", "p" },
			{ " ", " ", " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " ", " ", " " },
			{ "r", "k", " ", " ", " ", " ", " ", " " },
			{ "A", "p", " ", " ", " ", " ", " ", " " },
			{ "P", "P", "P", "P", "P", "P", "P", "P" },
			{ "R", "K", "B", "Q", "A", "B", "K", "R" } };
	static int kingPositionC, kingPositionL;

	public static void main(String[] args) {
		/*
		 * PIECE=WHITE/black pawn=P/p knight (horse)=K/k bishop=B/b rook
		 * (castle)=R/r Queen=Q/q King=A/a
		 * 
		 * My strategy is to create an alpha-beta tree diagram which returns the
		 * best outcome
		 * 
		 * (1234b represents row1,column2 moves to row3, column4 which captured
		 * b (a space represents no capture))
		 */
		/*
		 * JFrame f=new JFrame("Chess Tutorial");
		 * f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); UserInterface
		 * ui=new UserInterface(); f.add(ui); f.setSize(500, 500);
		 * f.setVisible(true);
		 */
		System.out.println(posibleMoves());
	}

	public static String posibleMoves() {
		String list = "";
		for (int i = 0; i < 64; i++) {
			switch (chessBoard[i / 8][i % 8]) {
			case "P":
				list += posibleP(i);
				break;
			case "R":
				list += posibleR(i);
				break;
			case "K":
				list += posibleK(i);
				break;
			case "B":
				list += posibleB(i);
				break;
			case "Q":
				list += posibleQ(i);
				break;
			case "A":
				list += posibleA(i);
				break;
			}
		}
		return list;// x1,y1,x2,y2,captured piece
	}

	public static String posibleP(int i) {
		String list = "";
		return list;
	}

	public static String posibleR(int i) {
		String list = "";
		return list;
	}

	public static String posibleK(int i) {
		String list = "";
		return list;
	}

	public static String posibleB(int i) {
		String list = "";
		return list;
	}

	public static String posibleQ(int i) {
		String list = "";
		return list;
	}

	public static String posibleA(int i) {
		String list = "", oldPiece;
		int r = i / 8, c = i % 8;
		for (int j = 0; j < 9; j++) {
			if (j != 4) {
				try {
					if (Character.isLowerCase(chessBoard[r - 1 + j / 3][c - 1
							+ j % 3].charAt(0))
							|| " ".equals(chessBoard[r - 1 + j / 3][c - 1 + j
									% 3])) {
						oldPiece = chessBoard[r - 1 + j / 3][c - 1 + j % 3];
						chessBoard[r][c] = " ";
						chessBoard[r - 1 + j / 3][c - 1 + j % 3] = "A";
						int kingTemp = kingPositionC;
						kingPositionC = i + (j / 3) * 8 + j % 3 - 9;
						if (kingSafe()) {
							list = list + r + c + (r - 1 + j / 3)
									+ (c - 1 + j % 3) + oldPiece;
						}
						chessBoard[r][c] = "A";
						chessBoard[r - 1 + j / 3][c - 1 + j % 3] = oldPiece;
						kingPositionC = kingTemp;
					}
				} catch (Exception e) {
				}
			}
		}
		// need to add casting later
		return list;
	}

	public static boolean kingSafe() {
		return true;
	}
}