public class MineField {
	private int rows;
	private int cols;
	private Cell[][] mineSet;
	boolean inProgress = true;
	private int totalNumOfMines;
//constructor for custom minefield with user specified mines rows and columns
	public MineField(int row, int col, int mines) {
		rows = row;
		cols = col;
		totalNumOfMines = mines;
		mineSet = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mineSet[i][j] = new Cell();
			}
		}
		Cell.count = totalNumOfMines;
		while (Cell.getCount() > 0) {
			int randRow = (int) (Math.random() * rows);
			int randCol = (int) (Math.random() * cols);
			if (!mineSet[randRow][randCol].getMine())
				mineSet[randRow][randCol].setMine();
		}
		assignCells();
	}
//standard minefield for beginner intermediate and expert
	public MineField(String difficulty) {
		if (difficulty.equalsIgnoreCase("b")) {
			rows = 9;
			cols = 9;
			totalNumOfMines = 10;
		} else if (difficulty.equalsIgnoreCase("i")) {
			rows = 16;
			cols = 16;
			totalNumOfMines = 40;
		} else if (difficulty.equalsIgnoreCase("e")) {
			rows = 16;
			cols = 30;
			totalNumOfMines = 99;
		} else if (difficulty.equalsIgnoreCase("c")) {

		}
		mineSet = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mineSet[i][j] = new Cell();
			}
		}
		Cell.count = totalNumOfMines;
		while (Cell.getCount() > 0) {
			int randRow = (int) (Math.random() * rows);
			int randCol = (int) (Math.random() * cols);
			if (!mineSet[randRow][randCol].getMine())
				mineSet[randRow][randCol].setMine();
		}
		assignCells();
	}

	public void setRows(int r) {
		rows = r;
	}

	public int getRows() {
		return rows;
	}

	public void setCols(int c) {
		cols = c;
	}

	public int getCols() {
		return cols;
	}

	public Cell getCell(int r, int c) {
		return mineSet[r][c];
	}

	public void isWin() {
		int numOfRevealed = 0;
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				if (mineSet[x][y].isRevealed()) {
					numOfRevealed++;
				}
			}
		}
		if (numOfRevealed >= ((rows * cols) - totalNumOfMines)) {
			inProgress = false;
			System.out.println(
//					"        `                                                                                  `        \n          `                                                                               `         \n           ` -sssso     /++++-            /++++++++++++/           +ssss/       :ssss+  `           \n             +MMMMm     mMMMMo         `++mMMhhhhhhhhMMm++.        dMMMMy       sMMMMm              \n             +MNMMm     mMMMMo         .MMMMM.      `NMMMM:        dMMMMy       sMMMMd              \n             +MMNMm`````mMMMMo         .MMMMM.      `NMMMM:        dMMMMy       sMMMNd              \n             ./:mMNmmmmmMMN::.         .MMMMM.      `NMMMM:        dMMMMy       sMMNMm              \n                :/+NMMMM+//            .MMMMM.      `NMMMM:        dMMMMy       sNMMMm              \n                  `MMNMM.              .MMMMM.      `NMMMM:        dMMMMy      `sMMMMm              \n                  `MMMMN.              .MMMMM.      `NMMMM:        dMMMMy       sMMMMm              \n                  `MMMMN.              `++mMMyyyyyyyyMMm++.        /oyMMmyyyyyyymMMoo+              \n                  `ossso``                +ssssssssssss+             .ossssoossssso                 \n                                                                                                    \n                            `                                          `                            \n                                                                                                    \n                              ......                           `.....`                              \n                              mmmmmm.                          ymmmmm/                              \n                              MMMMMM.                          dMMMMM+                              \n                   ://///`    NNNNNN/-----                :::::dNNNNN+    ://///`                   \n                   hMMMMM`    -----+MNNMMm               `NMMMMN:----`    hMMMMM.                   \n                   hMMMMM`         :MMMNMm               `NMMNMM.         hMMMMM.                   \n                   hMMMMM`    :ooooyMMMMMNooooooooooooooosMMMMMMsoooo-    hMMMMM.                   \n                   hMMMMM`    oMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM+    hMMMMM.                   \n                   hMMMMM.````oMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMo````hMMMMM.                   \n                   hMMMMMmddddmMMMm++++++oMMMMMMMMMMMMMMMMo+++++hMMMMNmmmdNMMMMM.                   \n                   hMMMMNNNmNNmNMMd      -MMMMMMMMMMMMMMMM.     oMMMMMMMMMNNMMMM.                   \n                   hMNNNmmmNNmmmNNh  .-..:MMMMMMMMMMMNNmmm. ``  oMMMMMMMMMmmMMMM.                   \n                   hNNNmNNNMNNNNNNmhyhhhhdNmmmmmNmmmmmNmNNhyhhyydmmNNmmmmmmmNNmN.                   \n                   hNNNmNNMMMNmNmNmMNNmMMMNNmmNmNmNNmMNNNNmNmmMmNNmNmmmMMNmmNmNM.                   \n                   ydddhmNNNNNNmNNmMMNNmmmmNmmmmNmNmmNmmmNNMmNmNNmmNNNNmmmmddhhd.                   \n                        mMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM-                        \n                        mMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM-                        \n                        syyyyyMMMMMMyssssssssssssssssssssssssssmMMMMMdyyyyy.                        \n                              MMMMMM.                          yMMMMMo                              \n                              MMMMMM.  `                    `  yMMMMMo                              \n                        +ddddddyyyyy.                          +yyyyhmddddh                         \n                        sMMMMMs     `                          `    :MMMMMm                         \n                        sMMMMMs                                     :MMMMMm                         \n                        -/////-  `                                ` ./////:                         \n                                                                                                    \n                              `                                      `                              \n                                                                                                    \n           -----`       ---::.           `:::::::::::::::-            `....`       `....`           \n          .NMMMN:       dNNNNo           .ddddmMMMMMNddddy            hmmmm+```    hmmmm/           \n          .NMMMM:       dMMMMo            ````:MMMMMd`````            dMMMMNdd/    mMMMM+           \n          .NMMMM:       mMMMMo                -MMMMMd                 dMMMMMMMy+/  mMMMM+           \n          .NMMMM: `::-  mMMMMo                -MMMMMd                 dMMMMMMMMNN::mMMMM+           \n          .NMMMM/ .MNy  mMMMMo                -MMMMMd                 dMMMMMMMMMNNMMMMMM+           \n          .NMMMMdhhMMNhhNMMMMo                -MMMMMd                 dMMMMy:/NMMMNMMMMM+           \n          .NMMMMMNN+/sMMMMMMMo                -MMMMMd                 dMMMMo  ++oMMMMMMM+           \n          .NMMMNyss` -ssNMMMMo           `::::+MMMMMm::::-            dMMMMo    .yyNMNMM+           \n          `dmmmm:       hmmmmo           -mmmmmmmmmmmmmmmy            ymmmm+       hmmmm/           \n           `````        `````             ````````````````            `````        ``````           \n");
					"Yess!!! \n");
			displayWin();

		}
	}

	public void displayBoard() {
		System.out.println("          Columns");
		System.out.print("        ");
		for (int i = 1; i <= cols; i++) {
			System.out.printf("%4d", i);
		}
		System.out.printf("\n    Rows ╔");

		for (int o = 0; o < cols - 1; o++) {
			System.out.printf("═══╦");
		}
		System.out.println("═══╗");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (j == 0) {
					if (mineSet[i][j].isRevealed()) {
						System.out.printf("%9d" + "║" + mineSet[i][j].getCellState() + "║", (i + 1));
					} else if (mineSet[i][j].isMarked()) {
						System.out.printf("%9d" + "║" + " ? " + "║", (i + 1));
					} else {
						System.out.printf("%9d" + "║" + " □ " + "║", (i + 1));
					}
				} else if (j == getCols() - 1) {
					if (mineSet[i][j].isRevealed()) {
						System.out.print(mineSet[i][j].getCellState() + "║\n");
					} else if (mineSet[i][j].isMarked()) {
						System.out.print(" ? " + "║\n");
					} else
						System.out.print(" □ " + "║\n");
				} else if (mineSet[i][j].isRevealed()) {
					System.out.print(mineSet[i][j].getCellState() + "║");
				} else if (mineSet[i][j].isMarked()) {
					System.out.print(" ? " + "║");
				} else {
					System.out.print(" □ " + "║");

				}

			}
			if (i == getRows() - 1) {
				System.out.printf(" \t ╚");

				for (int o = 0; o < cols - 1; o++) {
					System.out.printf("═══╩");
				}
				System.out.println("═══╝");
			} else {
				System.out.printf(" \t ╠");

				for (int o = 0; o < cols - 1; o++) {
					System.out.printf("═══╬");
				}
				System.out.println("═══╣");
			}

		}
	}
// checks for how many mines are around a given cell then assigns the values to all the cells.
	private void assignCells() {
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				int count = 0;
				
				for (int i = x - 1; i <= x + 1; i++) {

					for (int j = y - 1; j <= y + 1; j++) {
						if (j < 0 || j > cols-1 || i < 0 || i > rows-1){
							continue;
						}
						if (mineSet[i][j].getMine()) {
							count++;

						}
					}
				}

				mineSet[x][y].setCellState(count);

			}
		}

	}

	private void whiteSpaceFlipper(int r, int c) {
		if (!mineSet[r][c].getCellState().equals("   ")){
			 return;
			}
		//takes the value of the row and column passed in and checks all around it for whitespaces and calls itself until it can't anymore
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j++) {
				if (j < 0 || j > cols-1 || i < 0 || i > rows-1 || (i == r && c == j)) {
					continue;
				} else {
					if (!mineSet[i][j].isRevealed() && !mineSet[i][j].isMarked() && !mineSet[i][j].getMine()) {
						mineSet[i][j].setRevealed(true);
						if (mineSet[i][j].getCellState().equals("   "))
							whiteSpaceFlipper(i, j);
					}

				}
			}
		}
	}

	public void probeCell(String m, int r, int c) {
		if(r>rows || c >cols){
			System.out.println();
		}
		if (m.equals("y") && mineSet[r][c].isMarked()) {
			mineSet[r][c].setRevealed(false);
			mineSet[r][c].setMarked(false);
		} else if (m.equals("y") && !mineSet[r][c].isRevealed()) {
			mineSet[r][c].setMarked(true);
		} else if (m.equals("y") && mineSet[r][c].isRevealed()) {
			System.out.println("that cell is already revealed, please make another selection");
		} else if (!m.equals("y") && mineSet[r][c].isMarked()) {
			System.out.println("that place is already marked, so you cannot select it. please unmark it to select");
		} else if (mineSet[r][c].getMine()) {
			displayBoom();
		} else {
			mineSet[r][c].setRevealed(true);
			// if (mineSet[r][c].getCellState().equals(" ")){
			whiteSpaceFlipper(r, c);
			// }

			isWin();
		}
		if (inProgress) {
			displayBoard();
		}
	}

	public void displayBoom() {
		System.out.println(
//				"Yysssssssssssssssssssssssssssssssssssssssssssssssssssssssyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy\no+++++o+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\no+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\no+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\no+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\no+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\no+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\no+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\no++++++++++++++++++++++++++++++++++++++++oooooooooosssso++++++++++++++++++++++++++++++++++++++++++++\no+++++++++++++++++++++++++++++++++++oosyhhddddhhddhhhhyyyyyo+oo+++++++++++++++++++++++++++++++++++++\no++++++++++++++++++++++++++++++++oyhhhhhddmNNmmmddmmmmmhdmddhhhhyo++++++++++++++++++++++++++++++++++\no+++++++++++++++++++++++++++++++sdhmhdddddmNNmmmmmmmmNNdmmmmdmdddds+++++++++++++++++++++++++++++++++\no++++++++++++++++++++++++++++++oydmmmmdddddmmmdymmmmmmmmmmmmmmdmdddho+++++++++++++++++++++++++++++++\no++++++++++++++++++++++++++oyhhhhmmmmdhddmmmdhdddmmmmmmmdmmdmmmdmmmddyo+++++++++++++++++++++++++++++\no++++++++++++++++++++++++ohddhhdddhmdhdmNmmNmdmmmdmddmmdddmdmmmddmmddddyo+++++++++++++++++++++++++++\no+++++++++++++++++++++++shdhyhdddhhhyydmNmNNNmdmmdhyhyhdmmdhdmmdhmmhymmmhhyo++++++++++++++++++++++++\no++++++++++++++++++++++sddmdhdmmdhhhyhmmmmNNNmdmmmdhddddmmdhddddhdmddmmmdyhh++++++++++++++++++++++++\n++++++++++++++++++++++ydmmmdmmdddhdmmmmNNNmmmhdmNmmdmmmmdmmddmmmhdmmmhdmhhhdyo++++++++++++++++++++++\no++++++++++++++++++++shdhmddmddmmmmmmmmmmmmmdhdmmmmddmmmmmmdmmdhddmmhmdhyhhdhy++++++++++++++++++++++\n+++++++++++++++++++oyhhhhdydmyddhhhyhhddmdmmmmmmmmmmmmmmmmmmmmmdhhdddmmdhhyyhhs+++++++++++++++++++++\n++++++++++++++++++ooyymdhsoydyyhyhddddhyhhhdhmdmmmdmmmmmmmmmmmmmdhhdddddhyddyys+++++++++++++++++++++\no+++++++++++++++++ssyshhysssyossoymhhhdhhhsyhmmmmmdmmmmdddhhmmmmdhhhddddhshyhys+++++++++++++++++++++\n++++++++++++++++++syhysdyyssssyosyhsydhyyhyhdmmmmmmmmmdshhyhhdhhdhdydddhyshhhyyo++++++++++++++++++++\no++++++++++++++++osyhhyyhyyyyyyyhysssyysyssyhhddddmddyhddyyyhyyhdddhhhhsyyydhsyy++++++++++++++++++++\n++++++++++++++++ossyhdddhyyyhhhhhyysyyyyyssssssossyyyyyhhsssyyyhhhyyyhhshhydhsoo++++++++++++++++++++\n++++++++++++++++oyhhhddddmdhhyyssoooooooooo++///++++oooooooooossyysyhhhhhhyyysss++++++++++++++++++++\n++++++++++++++++syhhddddmmmdhyyso+////////:::::+ooooo+++///++oooosssyhhhhhysyyso++++++++++++++++++++\n++++++++++++++++oyhdddddmmmmdhsso+/////:::::---:++o+++/////+++ooooosyhhhhhhsssys++++++++++++++++++++\no+++++++++++++++oyyyddhyhddddhyso+/////:::::::--:::::://///++++ooooossyddddysyyo++++++++++++++++++++\n++++++++++++++++ossyhdhyhhdddhyo+///////:::::--:::::::::////++++++oo+++ydddhyys+++++++++++++++++++++\n++++++++++++++++oyyyyhhhyyhhhys+////////:::::::::::::::::////++++++o+:/odmdhys++++++++++++++++++++++\n++++++++++++++++sydhhysyyyhyyo/::://////:::---:::::::::::////+++ooso+::/hddys+++++++++++++++++++++++\n+++++++++++++++osymmdo/+oosss/:--://+++++//::::::::::::////+ossyssysso/:ydys++++++++++++++++++++++++\n+++++++++++++++++ydmms:/+/+ss/--:/++++oooooooo++//://///+osyyhyssyysss+:hhsoso++++++++++++++++++++++\n+++++++++++++++++ydddy/://oso/-:////+os+ooso/++//////++oss+/+so++osooo+/yhooy+++++++++++++++++++++++\n+++++++++++++++++ohmmdy/::+yo/-://///////+++/+/:///::/oso+://+++oo+++++/yy+o++++++++++++++++++++++++\n++++++++++++++++++ydmddy/:/os/::://:::::::////::://::/oso+//////////++//so++++++++++++++++++++++++++\n++++++++++++++++++oyddddh+/:/:::::/::::////:::::////:/oso+/////////++//+++//++++++++++++++++++++++++\n++++++++++++++++++++oyhddhs+/::::::/:::::///:::////::/osoo+///////+++//+////++++++++++++++++++++++++\n++++++++++++++++++++++ymd+/++::::-:/::::::/:::::////:/+sso++//////+++//+++++++++++++++++++++++++++++\n+++++++++++++++++++++smmms::o/::::://::://////////////+osssso+////++++++++++++++++++++++++++++++++++\n+++++++++++++++++++++hmmmd+-/o///////////++////////:://+oyyysoo++++oooso+++++++++++++++///++++++++++\n++++++++++++++++++++ohmmmmh//+//////+++++//////////////oyhyyssso++/+osso++++++++++++++//::///+++++++\n++++++++++++++++++++odhmmmm+yoo/////////++++////////++++ooosyys+///osso++++++++++++++/:::://++++++++\n++++++++++++++++++o/+ydhmmmyydho++/////////o+/:::////////+syso////osso++++++++++++++///:://+++++++++\n++++++++++++++++oyh++yyyhmmdsmmhy+++//////://+/::---:--:/+ooo+/++oyyo+++++++++++++++/////+++++++++++\n+++++++++++++++sdmdsysyhmmmmdmmmmho++/////::///+///////++ooso+++osyhsso++++++++++++//////+++++++++++\n+++++++++++++ohmNNmhsmhmmmmmmmmmmmdyo+////:::////////++++ooo+++oosdmdmmh+++++++++++/////+o++++++++++\n++++++++++++sdNNNNNmmNNNNmhyhmmmmmmmdyo+////::://////++++++++++o+ymmmddy+++++++o+++//://++++++++++++\n++++++++++oymNNNNNNNNNNNNNdyhhdmNmmmdmdyo+//////:::////++++++oo+/hmmmmdhhhhhddddds//::/++ossso++++++\n+++++++++ohNNmmNNNNNNNNNNNNmdmhdmNNmmmmmmhs+//////::////+++oooss/hmmmmmmmmmmmysos/::::/+/shhyo++++oo\n++++++++sdNmdmNNNNNNNNNNNNNNNNmmmmNNNNmmmmmho+///::::///++osyyhs+mmmmmmmmmmmmo++/:::://++ossso++++++\n+++++++smNmddNNNNNNNNNNNNNNNmNNNNmNNNNNmmNNmmhyo++++++++osyyyyyosmmmmmdmmmmmmdh+//:://++o++oosoo++++\n+++++oymNNddNNNNNNNNNNNNNNNmNmmNNNNNNNNNmmNNNmmmdhhyyyyhhyyssssohmmmdddmmmmmmh+/:::://+++++++ooooooo\no+++oymNNdhmNNNNNNNNNNNNNNNNNNmmNmmNNNNNNNmNNmmNNmmmmmmddhysssyymNmmdddmNmmmdo/:::::///////++ossoooo\no++ohmNNdhdNNNNNNNNNNNNNNNNNNNNmmNddmNNNNNNmNNmmmNmmmmmmddhyyyhmNNmddhhdNmmmy/::::::///////+oooooooo\nooohmNNdhhmNNNNNNNNNNNNNNNNNNNNNmmNNddNNNNNNmmNNmmNNmmmmmmddhhdNNmmdhhhdNmmh/:::::::://///++++++ooos\nooyhmmdhhdNNNNNNNNNNNNNNNNNNNNNNNNNNNmmNNNmNNmmNNNmNNNmmmNNmmdmNNNmmddhdNNms/::::::::////++++++oooos\noyyhdhhyhdNNNNNNNNNNNNNNNNNNNNNNNNNNNNNmmNmNNNmmNNNNNNNNNmNmmmmmmNNmmmmmNNmy/::::::::/++//+++oooooso\nssoyssysydmNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNmmNmNNNNNNNmddmmmddNNNNNNNNNdo/:::::::/++++++ooooooso\no+++/o+oydmmNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNmmmmmNNmhNNmdNNNNmNNNNNNNNNmd+::://///++++++ososssoo\n+::-/:/oydmNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNmdmdmNNmNNNmmNNNdNNNNNNNNNNmo:://////+o++ooooososss\n/-.-::/osdNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNmmmNNNNNNdmNNNNNNNNNNNNNNmyssyysssssssssoooosssss\n:--://+sdNNNNNNmmmmmmNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNmdNNNNNNNNNmNNNNNNNNNNNNNNNNNNNNmmdhhyssssyysss\n:--///+smmNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNdmNNNNNNNNNNNNNNNNNNNNNNmmdhysyyssoo\n/::+::/sdmmmmmdhddddNNNNNNNNmmNNNNNNNNNNNNmmNmNNNNNNNNNNNNNNNNNNmNNNNNNmNNNNNNNNNNNNNNNNNNNmdhysoooo\no++:-:oosdmdddmhyyydmmNNNNNNNNNNNNNNNNNNNdmoyhdmNmhNNNNNNNNNNNNNNNNNNNNmNNNNNNNNNNNNNNNNNNNNNNmhsooo\nso:-+o::yymNNmddddddmdhNdmNNNNNNNNNNNNNNNNNdsohhmNmhNNNNNNNNNNNNNNNNNNNNNNNNNNNNmNNNNNNNNNNNmdmmNmso\ny+:sd::ymmNNNNmmmNNNNNNNNmmNNNNNNNNNNNNNNNNNysohymNmyNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNo//+ymoo\nh+yNd/smmNNNNNNNmdmmNNNNNNNNNNNNNmNNNNNNNdmmNhsodsmNhoymmNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNy/+sdyoo\nhsNNdommmNNNNNNNNNNNNNNNNNNNNNNNNNmNNNNNNmhsyddood+dNh/ooohNNNNNNNNmNNNNNNNNNNNNNNNNNNNNNNNNNNmNNNNm\nydNNddNmNNNNmdhdmNNmNNNNNNNNNmmmmmNNNNNNNNNddhhh/yd+dNy/+/-+dNNNNNNNmNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN\nhNNNmdNNNNNNNNNNmmmmmNNNNmNNNNNNmmdhdNNNNNNNmshdy+hh/dms::o::yNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN\ndNMNmmNNNNNNNNNNNNNNNNNNNNNNNNNNNNNmmmmmNNNNNmsymh+do/mmo-+y+:sNNNNNNNNNNNNNNNNNNNNmdNNNNNNNNNNNNNNN\ndNMMmNNNNNNNNNNNdyyyhyyhhddmmmmmmmNNNNNNNNNNNNNdyms+d:/mm+:ydo:oNNNNNNNNNNNNNNNNNNNNNNNNNmNNNNNNNMMM\n");
				"Boom!!!");
		System.out.print("        ");
		for (int i = 1; i <= cols; i++)
			System.out.printf("%4d", i);
		System.out.printf("\n \t ╔");
		for (int o = 0; o < cols - 1; o++) {
			System.out.printf("═══╦");
		}
		System.out.println("═══╗");
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				if (j == 0) {
					if (mineSet[i][j].getMine())
						System.out.printf("%9d" + "║ ☼ ║", (i + 1));
					else
						System.out.printf("%9d" + "║" + mineSet[i][j].getCellState() + "║", (i + 1));
				} else if (j == getCols() - 1) {
					if (mineSet[i][j].getMine())
						System.out.print(" ☼ ║\n");
					else
						System.out.print(mineSet[i][j].getCellState() + "║\n");
				} else if (mineSet[i][j].getMine())
					System.out.print(" ☼ ║");
				else
					System.out.print(mineSet[i][j].getCellState() + "║");
			}
			if (i == getRows() - 1) {
				System.out.printf(" \t ╚");

				for (int o = 0; o < cols - 1; o++) {
					System.out.printf("═══╩");
				}
				System.out.println("═══╝");

				System.out.println("You hit a mine! You have lost!");

			} else {
				System.out.printf(" \t ╠");

				for (int o = 0; o < cols - 1; o++) {
					System.out.printf("═══╬");
				}
				System.out.println("═══╣");
			}
			inProgress = false;
		}
	}

	public void displayWin() {
		System.out.print("        ");
		for (int i = 1; i <= cols; i++)
			System.out.printf("%4d", i);
		System.out.printf("\n \t ╔");
		for (int o = 0; o < cols - 1; o++) {
			System.out.printf("═══╦");
		}
		System.out.println("═══╗");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (j == 0) {
					if (mineSet[i][j].getMine())
						System.out.format("%9d" + "║ ☼ ║", (i + 1));
					else
						System.out.format("%9d" + "║" + mineSet[i][j].getCellState() + "║", (i + 1));
				} else if (j == getCols() - 1) {
					if (mineSet[i][j].getMine())
						System.out.print(" ☼ ║\n");
					else
						System.out.print(mineSet[i][j].getCellState() + "║\n");
				} else if (mineSet[i][j].getMine())
					System.out.print(" ☼ ║");
				else
					System.out.print(mineSet[i][j].getCellState() + "║");
			}
			if (i == getRows() - 1) {
				System.out.printf(" \t ╚");

				for (int o = 0; o < cols - 1; o++) {
					System.out.printf("═══╩");
				}
				System.out.println("═══╝");

				System.out.println(" You won! way to go!");

			} else {
				System.out.printf(" \t ╠");

				for (int o = 0; o < cols - 1; o++) {
					System.out.printf("═══╬");
				}
				System.out.println("═══╣");
			}

		}
		inProgress = false;
	}
}