
public class Powerball extends Game implements GameInterface {

	public Powerball()
	{
		this.rangeSelect = 59;
		this.rangePowerSelect = 35;
		this.powerName = "red Powerball";
		this.bonus = "Power Play";
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
				output = 10000;
			else
				output = 100;
		else if ( num_matching == 3 )
			if ( power == 1 )
				output = 100;
			else
				output = 7;
		else if ( num_matching == 2 && power == 1)
			output = 7;
		else if ( power == 1 )
			output = 4;
		else
			output = 0;

		return output;
	}
}
