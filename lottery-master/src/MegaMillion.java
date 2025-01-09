
public class MegaMillion extends Game implements GameInterface {
	public MegaMillion()
	{
		this.rangeSelect = 75;
		this.rangePowerSelect = 15;
		this.powerName = "Mega ball";
		this.bonus = "Megaplier";
	}
	public int calculateEarnings()
	{
		multiplier = using_bonus ? 2 : 1;
		if ( num_matching == 5 )
			if ( power == 1)
				output = getRandom(1000000, 10000000);
			else
				output = 1000000;
		else if ( num_matching == 4 )
			if ( power == 1 )
				output = 5000;
			else
				output = 500;
		else if ( num_matching == 3 )
			if ( power == 1 )
				output = 50;
			else
				output = 5;
		else if ( num_matching == 2 && power == 1)
			output = 5;
		else if ( num_matching == 1 && power == 1 )
			output = 2;
		else if ( power == 1 )
			output = 1;
		else
			output = 0;
		return output;
	}
}
