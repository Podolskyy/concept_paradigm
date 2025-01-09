
public class HotLotto extends Game implements GameInterface {
	public HotLotto()
	{
		this.rangeSelect = 47;
		this.rangePowerSelect = 19;
		this.powerName = "orange HOT BALL";
		this.bonus = "Hot Lotto SIZZLER";
	}
	public int calculateEarnings()
	{
		multiplier = using_bonus ? 3 : 1;
		if ( num_matching == 5 )
			if ( power == 1)
				output = getRandom(30000, 300000);
			else
				output = 30000;
		else if ( num_matching == 4 )
			if ( power == 1 )
				output = 3000;
			else
				output = 100;
		else if ( num_matching == 3 )
			if ( power == 1 )
				output = 50;
			else
				output = 6;
		else if ( num_matching == 2 && power == 1)
			output = 6;
		else if ( num_matching == 1 && power == 1 )
			output = 3;
		else if ( power == 1 )
			output = 2;
		else
			output = 0;
		return output;
	}
}
