import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

	public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
		// Count apples that fall on Sam's house
		long applesOnHouse = apples.stream().map(apple -> a + apple) // Calculate landing position of each apple
				.filter(position -> position >= s && position <= t) // Check if it lands on the house
				.count();

		// Count oranges that fall on Sam's house
		long orangesOnHouse = oranges.stream().map(orange -> b + orange) // Calculate landing position of each orange
				.filter(position -> position >= s && position <= t) // Check if it lands on the house
				.count();

		// Print the results
		System.out.println(applesOnHouse);
		System.out.println(orangesOnHouse);

	}

}

public class Resolution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int s = Integer.parseInt(firstMultipleInput[0]);

		int t = Integer.parseInt(firstMultipleInput[1]);

		String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int a = Integer.parseInt(secondMultipleInput[0]);

		int b = Integer.parseInt(secondMultipleInput[1]);

		String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int m = Integer.parseInt(thirdMultipleInput[0]);

		int n = Integer.parseInt(thirdMultipleInput[1]);

		List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result.countApplesAndOranges(s, t, a, b, apples, oranges);

		bufferedReader.close();
	}
}
