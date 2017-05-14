import java.util.Vector;

public class Game
{
	Place[] boardPlaces;
	Card[] communityChestCards;
	Card[] chanceCards;
	Player[] playerArray;
	int doublesCount = 0;
	int endTurn;
	int playerNum;
	Player currentPlayer;
	boolean buyPlace;
	boolean buyUtility;
	boolean buyRailway;
	boolean sellPlace;
	boolean endGame;
	int tellPlayer;
	String statusUpdate;
	
	public Game(int players)
	{
		boardPlaces = new Place[40];
		communityChestCards = new Card[13];
		chanceCards = new Card[13];
		playerArray = new Player[players];
		
		initBoard();
		initCommunityChestCards();
		initChanceCards();
		initPlayers();
		
		currentPlayer = playerArray[0];
		playerNum = 0;
		endTurn = 0;
	}
	
	public void initBoard()
	{
		boardPlaces[0] = new StartPlace("Main Gates");
		boardPlaces[1] = new PropertyPlace("1837", -60, -2, -50, -50, "purple");
		boardPlaces[2] = new CommunityCardPlace("Student Financial Services");
		boardPlaces[3] = new PropertyPlace("Buckland", -60, -4, -50, -50,"purple");
		boardPlaces[4] = new TaxPlace("Income Tax", -200);
		boardPlaces[5] = new RailwayPlace("Pegasus Railway");
		boardPlaces[6] = new PropertyPlace("MacGregor", -100, -6, -50, -50, "lightblue");
		boardPlaces[7] = new ChanceCardPlace("Registrar");
		boardPlaces[8] = new PropertyPlace("Ham", -100, -6, -50, -50, "lightblue");
		boardPlaces[9] = new PropertyPlace("Abbey", -120, -8, -50, -50, "lightblue");
		boardPlaces[10] = new JailPlace("CS Lab");
		boardPlaces[11] = new PropertyPlace("Rockefeller", -140, -10, -100, -100, "pink");
		boardPlaces[12] = new UtilityPlace("Auxiliary Services");
		boardPlaces[13] = new PropertyPlace("Prospect", -140, -10, -100, -100, "pink");
		boardPlaces[14] = new PropertyPlace("Mandelles", -160, -12, -100, -100, "pink");
		boardPlaces[15] = new RailwayPlace("Griffon Railway");
		boardPlaces[16] = new PropertyPlace("Wilder", -180, -14, -100, -100, "orange");
		boardPlaces[17] = new CommunityCardPlace("Student Financial Services");
		boardPlaces[18] = new PropertyPlace("Porter", -180, -14, -100, -100, "orange");
		boardPlaces[19] = new PropertyPlace("Mead", -200, -16, -100, -100, "orange");
		boardPlaces[20] = new FreeParkingPlace("Gorse Parking Lot");
		boardPlaces[21] = new PropertyPlace("Creighton", -220, -18, -150, -150, "red");
		boardPlaces[22] = new ChanceCardPlace("Registrar");
		boardPlaces[23] = new PropertyPlace("Safford", -220, -18, -150, -150, "red");
		boardPlaces[24] = new PropertyPlace("Library", -240, -20, -150, -150, "red");
		boardPlaces[25] = new RailwayPlace("Lion Railway");
		boardPlaces[26] = new PropertyPlace("Kendade Atrium", -260, -22, -150, -150, "yellow");
		boardPlaces[27] = new PropertyPlace("Art Building", -260, -22, -150, -150, "yellow");
		boardPlaces[28] = new UtilityPlace("Career Development Center");
		boardPlaces[29] = new PropertyPlace("Museum", -280, -22, -150, -150, "yellow");
		boardPlaces[30] = new GoToJailPlace("Campus Police");
		boardPlaces[31] = new PropertyPlace("Skinner Green", -300, -26, -200, -200, "green");
		boardPlaces[32] = new PropertyPlace("Chapin Hall", -300, -26, -200, -200, "green");
		boardPlaces[33] = new CommunityCardPlace("Student Financial Services");
		boardPlaces[34] = new PropertyPlace("Blanchard", -320, -28, -200, -200, "green");
		boardPlaces[35] = new RailwayPlace("Sphinx Railway");
		boardPlaces[36] = new ChanceCardPlace("Registrar");
		boardPlaces[37] = new PropertyPlace("Greenhouse", -350, -35, -200, -200, "darkblue");
		boardPlaces[38] = new TaxPlace("Luxury Tax", -100);
		boardPlaces[39] = new PropertyPlace("Jorge's Nest", -400, -50, -200, -200, "darkblue");
	}
	
	public void initCommunityChestCards()
	{
		communityChestCards[0] = new MoneyCard("Your family arrives on campus and you pester them for cash. Receive $20.", 20);
		communityChestCards[1] = new MoneyCard("You find $15 on the sidewalk!", 15);
		communityChestCards[2] = new MoneyCard("You get drunk at Strawberries and Champagne and lose your CASH SACK.", -40);
		communityChestCards[3] = new MoneyCard("As you dance around the maypole at Pangy Day, someone starts throwing money at you.  You pick up $80.", 80);
		communityChestCards[4] = new MoneyCard("You buy a print of a photo of yourself holding a bunny on Pangy Day for $10.", -10);
		communityChestCards[5] = new MoneyCard("Someone spills their drink on you during a Chapin party. You rob them in revenge.  Gain $100.", 100);
		communityChestCards[6] = new MoneyCard("You get sunburnt at convocation. Spend $20 on sunscreen.", -20);
		communityChestCards[7] = new MoneyCard("You've worn every article of clothing you own until they all smell and are crumpled and stained.  Give in and spend $200 to wash your all your clothes.", -200);
		communityChestCards[8] = new MoneyCard("You win a poetry contest.  Receive $50.", 50);
		communityChestCards[9] = new MoneyCard("Lose your OneCard. Pay $25 for a new one.", -25);
		communityChestCards[10] = new MovingCard("The Springies have arrived!  Go meet them at the Main Gates.", 0);
		communityChestCards[11] = new MovingCard("Eat at Blanchard every night for a week while avoiding doing your assignment.  Go to the CS Lab.", 10);
		communityChestCards[12] = new DOOMCard("You are in the midst of filing your W2s.  Pay $40 per house and $80 per hotel.", 40, 80);
	}
	
	public void initChanceCards()
	{
		chanceCards[0] = new MoneyCard("Take a study break at Rao's.  Spend $15.", -10);
		chanceCards[1] = new MoneyCard("Receive your paycheck from your on-campus job.  Earn $60.", 60);
		chanceCards[2] = new MoneyCard("The PVTA breaks down and traps you at Hampshire.  Spend $40 on a tent and food.", -40);
		chanceCards[3] = new MoneyCard("Receive $35 at Rings and Roses from your friends.", 35);
		chanceCards[4] = new MoneyCard("Change your major five times.  Miraculously spend only $150 extra to graduate.", -150 );
		chanceCards[5] = new MovingCard("Meet your friends for a study date in the Kendade Atrium.", 26);
		chanceCards[6] = new MovingCard("Mountain Day is declared, but you have to work on your next assignment.  Go to the CS Lab.", 10);
		chanceCards[7] = new MovingCard("Lose your voice before a choral concert.  Go cry to Jorge.", 39);
		chanceCards[8] = new MovingCard("Prospect has a dessert buffet.  Go to Prospect.", 13);
		chanceCards[9] = new MovingCard("The housing lottery has placed you in Mead.  Go check out your new room.", 19);
		chanceCards[10] = new MovingCard("Go check out the Flower Show at the greenhouse.", 37);
		chanceCards[11] = new MovingCard("The date of your assignment was moved a day earlier, and you haven't started it yet.  Go directly to the lab.", 10);
		chanceCards[12] = new DOOMCard("Student Financial Services call in your student loans. Pay $35 per house and $70 per hotel.", 35, 70);
	}
	
	public void initPlayers()
	{
		for(int i = 0; i<playerArray.length; ++i)
		{
			playerArray[i] = new Player("Player " + (i+1));
		}
	}
	
	public void rollDice()
	{
		statusUpdate = "";
		int die1 = (int)((Math.random()*6)+1);
		int die2 = (int)((Math.random()*6)+1);

		statusUpdate = currentPlayer.getName() + " has rolled a " + (die1+die2) +"!";
		
		if(die1 == die2)
		{
			++ doublesCount;
			statusUpdate += "  DOUBLES!!";
		}
		
		if(currentPlayer.inJail)
		{
			if(die1 == die2)
			{
				statusUpdate += "  You have escaped jail!";
				currentPlayer.setInJail(false);
				checkEnd();
			}
			
			else
				checkEnd();
		}
		
		else if(doublesCount == 3)
		{
			currentPlayer.setInJail(true);
			gotoPlace(10);
			statusUpdate += "  Oh no! 3 doubles in a row means jail!!";
			checkEnd();
		}
		
		else
			movePlayer(die1 + die2);
	}
	
	public void movePlayer(int numSpaces)
	{
		System.out.println("numSpaces: " + numSpaces);
		currentPlayer.setCurrentLocation((currentPlayer.getLocation()+numSpaces)%40);
		
		if(currentPlayer.getLocation()+numSpaces>=40 && currentPlayer.getLocation()!=30)
		{
			addOrSubtractMoney(200, currentPlayer);
		}
		
		System.out.println(currentPlayer.getLocation());
		tellPlayer = currentPlayer.getLocation()%40;
		
		placeType(tellPlayer, numSpaces);
	}
	
	public void placeType(int placeCell, int numSpaces)
	{
		int cost = 0;
		System.out.println("placeCell: " + placeCell);
		if(boardPlaces[placeCell] instanceof PropertyPlace)
		{
			System.out.println("It's a property");
			if(((PropertyPlace)boardPlaces[placeCell]).getIsBought() && !searchForPlace(placeCell, currentPlayer))
			{
				statusUpdate += "  You have landed on " + ((PropertyPlace)boardPlaces[placeCell]).getName() + ".";
				
				if(((PropertyPlace)boardPlaces[placeCell]).numHouses() == 0 && ((PropertyPlace)boardPlaces[placeCell]).numHotels() == 0)
				{
					System.out.println("nothing on the spot");
					cost = ((PropertyPlace)boardPlaces[placeCell]).getRent();
				}
				
				else if(((PropertyPlace)boardPlaces[placeCell]).numHotels()==1)
				{
					cost = ((PropertyPlace)boardPlaces[placeCell]).getRent()*55;
				}
				
				else if(((PropertyPlace)boardPlaces[placeCell]).numHouses() == 1)
				{
					cost = ((PropertyPlace)boardPlaces[placeCell]).getRent()*5;
				}
				
				else if(((PropertyPlace)boardPlaces[placeCell]).numHouses() == 2)
				{
					cost = ((PropertyPlace)boardPlaces[placeCell]).getRent()*15;
				}
				
				else if(((PropertyPlace)boardPlaces[placeCell]).numHouses() == 3)
				{
					cost = ((PropertyPlace)boardPlaces[placeCell]).getRent()*25;
				}
				
				else if(((PropertyPlace)boardPlaces[placeCell]).numHouses() == 4)
				{
					cost = ((PropertyPlace)boardPlaces[placeCell]).getRent()*35;
				}	
				
				if(allColor(((PropertyPlace)boardPlaces[placeCell]).getColor(), currentPlayer))
					cost *= 2;
				
				System.out.println("cost: " + cost);
				
				for(int i=0; i<playerArray.length; ++i)
				{
					System.out.println("searching");
					if(searchForPlace(placeCell, playerArray[i]))
					{
						statusUpdate += "  You owe Player " + (i+1) + " $" +Math.abs(cost) +"!";
						addOrSubtractMoney(cost, currentPlayer);
						addOrSubtractMoney(cost*-1, playerArray[i]);
						checkEnd();
						break;
					}
				}
			}
			
			else if(!((PropertyPlace)boardPlaces[placeCell]).getIsBought())
			{
				buyPlace = true;
			}
			
			else
			{
				statusUpdate += "  You own this place!";
				checkEnd();
			}
		}

		else if(boardPlaces[placeCell] instanceof FreeParkingPlace)
		{
			System.out.println("hi");
			statusUpdate += "  You have landed on Gorse Parking Lot.";
			checkEnd();
		}
		
		else if(boardPlaces[placeCell] instanceof ChanceCardPlace)
		{
			System.out.println("Chance");
			statusUpdate += "  You land on Chance and draw a card.  The card reads: ";
			drawCard(0);
		}
		
		else if(boardPlaces[placeCell] instanceof CommunityCardPlace)
		{
			System.out.println("CC");
			statusUpdate += "  You land on Community Chest and draw a card.  The card reads: ";
			drawCard(1);
		}
		
		else if(boardPlaces[placeCell] instanceof RailwayPlace)
		{
			int price = 0; 
			
			
			if(((RailwayPlace)boardPlaces[placeCell]).getIsBought() && !searchForPlace(placeCell, currentPlayer))
			{
				statusUpdate += "  You have landed on " + (boardPlaces[placeCell]).getName() + ".";
				for(int i = 0; i<playerArray.length; ++i)
				{
					boolean search = searchForPlace(placeCell, playerArray[i]);
					
					if(search)
					{
						int count = 0;
						
						if(searchForPlace(5, playerArray[i]))
						{
							++count;
						}
							
						if(searchForPlace(15, playerArray[i]))
						{
							++count;
						}
						
						if(searchForPlace(25, playerArray[i]))
						{
							++count;
						}
						
						if(searchForPlace(35, playerArray[i]))
						{
							++count;
						}
						
						if(count == 1)
							price = 25;

						else if(count == 2)
							price = 50;
						
						else if(count == 3)
							price = 100;
						
						else if(count == 4)
							price = 200;

						statusUpdate += "You owe Player " + (i+1) + " $" +price +"!";
						addOrSubtractMoney(price*-1, currentPlayer);
						addOrSubtractMoney(price, playerArray[i]);
						checkEnd();
						
					}
				}	
			}
			
			else if(!((RailwayPlace)boardPlaces[placeCell]).getIsBought())
			{
				buyRailway = true; 
			}
			
			else
			{
				statusUpdate += "  You own this railroad!";
				checkEnd();
			}
		}
		
		else if(boardPlaces[placeCell] instanceof StartPlace)
		{
			statusUpdate += "  You've made back to the Main Gates!";
			addOrSubtractMoney(200, currentPlayer);
		}
		
		else if(boardPlaces[placeCell] instanceof TaxPlace)
		{
			statusUpdate += "  You've landed on " + ((TaxPlace)boardPlaces[placeCell]).getName() + "!  You now owe $" + Math.abs(((TaxPlace)boardPlaces[placeCell]).takeTax()) + ".";
			addOrSubtractMoney(((TaxPlace)boardPlaces[placeCell]).takeTax(), currentPlayer);
			checkEnd();
		}
		
		else if(boardPlaces[placeCell] instanceof UtilityPlace)
		{
			int price = 0; 
			
			if(((UtilityPlace)boardPlaces[placeCell]).getIsBought() && !searchForPlace(placeCell, currentPlayer))
			{
				statusUpdate += "  You have landed on " + (boardPlaces[placeCell]).getName() + ".";
				for(int i = 0; i<playerArray.length; ++i)
				{
					searchForPlace(placeCell, playerArray[i]);
					
					if(searchForPlace(placeCell, playerArray[i]))
					{
						int count = 0;
						
						if(searchForPlace(12, playerArray[i]))
						{
							System.out.println("+1");
							++count;
						}
							
						if(searchForPlace(28, playerArray[i]))
						{
							System.out.println("+1");
							++count;
						}
						
						if(count == 1)
						{
							price = numSpaces*4;

						}
						
						else if(count == 2)
							price = numSpaces*10;

						statusUpdate += "  You owe Player " + (i+1) + " $" +price +"!";
						addOrSubtractMoney(price*-1, currentPlayer);
						addOrSubtractMoney(price, playerArray[i]);
						checkEnd();
					}
				}
				
			}
			
			else if(!((UtilityPlace)boardPlaces[placeCell]).getIsBought())
			{
				buyUtility = true;
			}
			
			else
			{
				statusUpdate += "You own this utility.";
				checkEnd();
			}
		}
		
		else if(boardPlaces[placeCell] instanceof GoToJailPlace)
		{
			statusUpdate += "  Oh no!  You've been sent to the lab!";
			currentPlayer.setInJail(true);
			gotoPlace(10);
			checkEnd();
		}
		
		else if(boardPlaces[placeCell] instanceof JailPlace)
		{
			// need snark here
			System.out.println("jailjailjail");
			statusUpdate += "  You are visiting the lab.  Lucky you.";
			checkEnd();
		}
	}
	
	public void addOrSubtractMoney(int money, Player player) 
	{
		player.setTotalCash(player.getTotalCash()+money);
	}
	
	public void gotoPlace(int placeCell)
	{
		if(placeCell == 10)
		{
			currentPlayer.setInJail(true);
		}
		
		else
		{
			if(currentPlayer.getLocation()+placeCell>=40)
			{
				addOrSubtractMoney(200, currentPlayer);
			}
		}
		currentPlayer.setCurrentLocation(placeCell);
	}
	
	public void sellThing(int cell)
	{
		System.out.println("we have arrived");
		System.out.println("cellNum " +cell);
		
		int placeNum = (int)currentPlayer.placesOwned.elementAt(cell);
		statusUpdate += "  You sold " + boardPlaces[placeNum].getName() + "!";
		
		if(boardPlaces[placeNum] instanceof PropertyPlace)
		{	
			int returns = 0;
			
			if(((PropertyPlace)(boardPlaces[placeNum])).numHouses() > 0)
			{
				returns += Math.abs(((PropertyPlace)(boardPlaces[placeNum])).numHouses()*((PropertyPlace)(boardPlaces[placeNum])).getHouseCost())/2;
			}
			
			if(((PropertyPlace)(boardPlaces[placeNum])).numHotels() > 0)
			{
				returns += Math.abs(((PropertyPlace)(boardPlaces[placeNum])).getHouseCost())/2;
			}
			
			returns += Math.abs(((PropertyPlace)boardPlaces[placeNum]).getPropertyCost())/2;
			
			System.out.println("yeeeeeeeeeeeeeees");
			
			addOrSubtractMoney(returns, currentPlayer);
			((PropertyPlace)boardPlaces[placeNum]).setIsBought(false);
			currentPlayer.removePlace(cell);
		}
		
		else if(boardPlaces[placeNum] instanceof UtilityPlace)
		{
			addOrSubtractMoney(Math.abs(((UtilityPlace)boardPlaces[placeNum]).getCost())/2, currentPlayer);
			((UtilityPlace)boardPlaces[placeNum]).setIsBought(false);
			currentPlayer.removePlace(cell);
		}
		
		else
		{
			addOrSubtractMoney((Math.abs(((RailwayPlace)boardPlaces[placeNum]).costToBuy()))/2, currentPlayer);
			((RailwayPlace)boardPlaces[placeNum]).setIsBought(false);
			currentPlayer.removePlace(cell);
		}
	}
	
	public void completeAction()
	{
		System.out.println("here");
		if(boardPlaces[tellPlayer] instanceof PropertyPlace)
		{
			buyPlace = false;
			statusUpdate += "  You have purchased " + ((PropertyPlace)boardPlaces[tellPlayer]).getName() + "!";
			addOrSubtractMoney(((PropertyPlace)boardPlaces[tellPlayer]).getPropertyCost(), currentPlayer);
			((PropertyPlace)boardPlaces[tellPlayer]).setIsBought(true);
			currentPlayer.addPlace(tellPlayer);
		}
		
		else if(boardPlaces[tellPlayer] instanceof UtilityPlace)
		{
			statusUpdate += "  You have purchased " + ((UtilityPlace)boardPlaces[tellPlayer]).getName() + "!";
			addOrSubtractMoney(((UtilityPlace)boardPlaces[tellPlayer]).getCost(), currentPlayer);
			((UtilityPlace)boardPlaces[tellPlayer]).setIsBought(true);
			currentPlayer.addPlace(tellPlayer);
		}
		
		else
		{
			statusUpdate += "  You have purchased " + ((RailwayPlace)boardPlaces[tellPlayer]).getName() + "!";
			addOrSubtractMoney(((RailwayPlace)boardPlaces[tellPlayer]).costToBuy(), currentPlayer);
			((RailwayPlace)boardPlaces[tellPlayer]).setIsBought(true);
			currentPlayer.addPlace(tellPlayer);
		}
		
		checkEnd();
	}

	public void drawCard(int cardArray)
	{
		Card chosenCard;
		
		int randCard=(int)(Math.random()*13);
		
		if(cardArray == 0)
		{
			System.out.println("got card");
			chosenCard = chanceCards[randCard];
			statusUpdate += chanceCards[randCard].getText();
		}
		
		else
		{
			chosenCard = communityChestCards[randCard];
			statusUpdate += communityChestCards[randCard].getText();
		}
		
		if(chosenCard instanceof MoneyCard)
		{
			addOrSubtractMoney(((MoneyCard)chosenCard).getCash(), currentPlayer);
		}
		
		else if(chosenCard instanceof MovingCard)
		{
			gotoPlace(((MovingCard)chosenCard).getPlace());
		}
		
		else
		{
			totalWorth(((DOOMCard)chosenCard).getHouseLossRate(), ((DOOMCard)chosenCard).getHotelLossRate());
		}
		
		checkEnd();
	}
	
	public void totalWorth(int houseMultiplier, int hotelMultiplier)
	{
		int total = 0;
		
		for(int i = 0; i<playerArray.length; ++i)
		{
			for(int j = 0; j<playerArray[i].getAllPlaces().size(); ++j)
			{
				if(boardPlaces[(int) playerArray[i].getAllPlaces().elementAt(j)] instanceof PropertyPlace)
				{
					total += ((PropertyPlace)boardPlaces[(int) playerArray[i].getAllPlaces().elementAt(j)]).numHouses()*houseMultiplier + ((PropertyPlace)boardPlaces[(int) playerArray[i].getAllPlaces().elementAt(j)]).numHotels()*hotelMultiplier;
				}
			}
		}
	}
	
	/**
	 * This method searches for a particular value in the placesOwned vector of a player.  If the value is found, it returns true.  If not, it returns false.
	 * @param cellNum
	 * @param checkPlayer
	 * @return
	 */
	public boolean searchForPlace(int cellNum, Player checkPlayer)
	{
		System.out.println(checkPlayer.placesOwned.toString());
		System.out.println(cellNum);
		Vector placesOwned = checkPlayer.getAllPlaces();
		int bluh = checkPlayer.placesOwned.indexOf(cellNum);

		if( bluh == -1)
			return false;	
		
		else
			return true;
	}
	
	public int playerWorth()
	{
		int total = 0;
		
		for(int i = 0; i<currentPlayer.placesOwned.size(); ++i)
		{
			if(boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)] instanceof PropertyPlace)
			{	
				if(((PropertyPlace)(boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)])).numHouses() > 0)
				{
					total += Math.abs(((PropertyPlace)(boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)])).numHouses()*((PropertyPlace)(boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)])).getHouseCost())/2;
				}
				
				if(((PropertyPlace)(boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)])).numHotels() > 0)
				{
					total += Math.abs(((PropertyPlace)(boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)])).getHouseCost())/2;
				}
				
				total += Math.abs(((PropertyPlace)boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)]).getPropertyCost())/2;
			}
			
			else if(boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)] instanceof UtilityPlace)
			{
				total += Math.abs(((UtilityPlace)boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)]).getCost())/2;
			}
			
			else
			{
				total += Math.abs(((RailwayPlace)boardPlaces[(int) currentPlayer.placesOwned.elementAt(i)]).costToBuy())/2;
			}
		}
		return total;
	}
	
	public void checkEnd()
	{
		
		if(currentPlayer.getTotalCash()<0)
		{
			System.out.println(currentPlayer.getAllPlaces().toString());
			if(!(currentPlayer.getAllPlaces().isEmpty()) || playerWorth() > Math.abs(currentPlayer.getTotalCash()))
			{
				sellPlace = true;
				statusUpdate += "  Player " +(playerNum+1) +", you have to sell enough properties off to pay your debts.";
			}
			
			else
			{
				currentPlayer.setInGame(false);
				statusUpdate += "  Player " + (playerNum+1) + " is out of the game!";
			}
		}
		
		if(!currentPlayer.inGame || currentPlayer.getTotalCash()>=0)
		{
			if(doublesCount > endTurn && !currentPlayer.inJail)
			{
				endTurn = doublesCount;
				statusUpdate += "\n" + currentPlayer.getName() + " has rolled doubles!  Roll again!";
			}
		
			else
			{
				System.out.println("why");
				int pastPlayer = playerNum;
			
				doublesCount = 0;
				endTurn = 0;
			
				++ playerNum;
				playerNum = (playerNum) % (playerArray.length);
				currentPlayer = playerArray[playerNum];
				
				if(!playerArray[(playerNum+1)%(playerArray.length)].inGame)
					endGame();
			
				else
					statusUpdate += "\n" + currentPlayer.getName() + ", it's your turn!";
			}
		}
	}
	
	public boolean allColor(String color, Player checkPlayer)
	{
		int checkPlaces = 0;
		
		for(int i = 0; i< checkPlayer.getAllPlaces().size(); ++i)
		{
			if(checkPlayer.getAllPlaces().elementAt(i).equals(color))
				++checkPlaces;
		}
		
		if(color.equals("purple") || color.equals("darkblue"))
		{
			if(checkPlaces == 2)
				return true;
		}
		
		else
		{
			if(checkPlaces == 3)
				return true;
		}
		
		return false;
	}
	
	public String getStatusUpdate()
	{
		return statusUpdate;
	}
	
	public void setBuyPlace(boolean set)
	{
		buyPlace = set;
	}
	
	public boolean getBuyPlace()
	{
		return buyPlace;
	}
	
	public void setBuyRailway(boolean set)
	{
		buyRailway = set;
	}
	
	public boolean getBuyRailway()
	{
		return buyRailway;
	}
	
	public void setBuyUtility(boolean set)
	{
		buyUtility = set;
	}
	
	public boolean getBuyUtility()
	{
		return buyUtility;
	}
	
	public void endGame()
	{
		statusUpdate += "  Player " +(playerNum+1) +" wins!";
		endGame = true;
	}
}