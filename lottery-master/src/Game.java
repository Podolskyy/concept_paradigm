import java.util.*;

// Smaller interfaces based on responsibilities
interface NumberPicker {
	void letUserPickNumbers(List<Integer> rangeChosen, int numNumsToGenerate, int sizeOfPool);
	void generateNumbers(List<Integer> putThemInHere, int numNumsToGenerate, int sizeOfPool);
}

interface NumberPrinter {
	String printNumbers(List<Integer> nums);
}

interface GameEvaluator {
	int calculateEarnings();
	int numMatchingNumbers(List<Integer> set1, List<Integer> set2);
}

// Abstract base class implementing the smaller interfaces
public abstract class Game implements NumberPicker, NumberPrinter, GameEvaluator {

	protected int rangeSelect, rangePowerSelect, multiplier, num_matching, power, output;
	protected String powerName, bonus;
	protected boolean using_bonus;

	protected List<Integer> chosenNumbers = new ArrayList<>();
	protected List<Integer> chosenPowerNumber = new ArrayList<>();
	protected List<Integer> winningNumbers = new ArrayList<>();
	protected List<Integer> winningPowerNumber = new ArrayList<>();

	public void play() {
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to pick the lucky numbers yourself, or " +
				"would you rather the computer generate them?" +
				"\n1. I'd rather pick them." +
				"\n2. Have the computer do it.");
		int num = input.nextInt();

		if (num == 1) {
			letUserPickNumbers(chosenNumbers, 5, rangeSelect);
			letUserPickNumbers(chosenPowerNumber, 1, rangePowerSelect);
		} else {
			generateNumbers(chosenNumbers, 5, rangeSelect);
			generateNumbers(chosenPowerNumber, 1, rangePowerSelect);
		}

		System.out.printf("To increase potential winnings, would you like to add %s for just $1?\n", bonus);
		System.out.println("1. Yes \n2. No");
		using_bonus = input.nextInt() == 1;

		generateNumbers(winningNumbers, 5, rangeSelect);
		generateNumbers(winningPowerNumber, 1, rangePowerSelect);

		System.out.printf("You chose the numbers %s. Your %s was %s.\n",
				printNumbers(chosenNumbers), powerName, printNumbers(chosenPowerNumber));

		System.out.printf("The winning numbers are %s and the %s is %s.\n",
				printNumbers(winningNumbers), powerName, printNumbers(winningPowerNumber));

		num_matching = numMatchingNumbers(chosenNumbers, winningNumbers);
		power = numMatchingNumbers(chosenPowerNumber, winningPowerNumber);

		int earnings = calculateEarnings() * multiplier;

		if (earnings > 0) {
			System.out.printf("Congratulations! You win %d.\n", earnings);
		} else {
			System.out.println("Alas, you lost all your money on that one.");
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("This thread is having a hard time getting to sleep!");
		}

		chosenNumbers.clear();
		chosenPowerNumber.clear();
	}

	@Override
	public void letUserPickNumbers(List<Integer> rangeChosen, int numNumsToGenerate, int sizeOfPool) {
		Scanner input = new Scanner(System.in);
		while (rangeChosen.size() < numNumsToGenerate) {
			System.out.printf("Select a number between 1 and %d for the %s: ", sizeOfPool, powerName);
			int num = input.nextInt();
			if (num >= 1 && num <= sizeOfPool && !rangeChosen.contains(num)) {
				rangeChosen.add(num);
			} else {
				System.out.println("Invalid or duplicate number. Try again.");
			}
		}
	}

	@Override
	public void generateNumbers(List<Integer> putThemInHere, int numNumsToGenerate, int sizeOfPool) {
		List<Integer> pool = new ArrayList<>();
		for (int i = 1; i <= sizeOfPool; i++) {
			pool.add(i);
		}
		Random random = new Random();
		while (putThemInHere.size() < numNumsToGenerate) {
			putThemInHere.add(pool.remove(random.nextInt(pool.size())));
		}
	}

	@Override
	public String printNumbers(List<Integer> nums) {
		return String.join(", ", nums.stream().map(String::valueOf).toList());
	}

	@Override
	public int numMatchingNumbers(List<Integer> set1, List<Integer> set2) {
		int count = 0;
		for (int num : set1) {
			if (set2.contains(num)) {
				count++;
			}
		}
		return count;
	}

	public int getRandom(int start, int finish) {
		// Generates a random number between start and finish, inclusive
		return new Random().nextInt(finish - start + 1) + start;
	}
	// Abstract method to be implemented by subclasses
	@Override
	public abstract int calculateEarnings();
}
