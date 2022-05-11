package streamapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNoOfOccurance {

	public static void main(String args[]) {
		String str = "this is string this string";
		Map<String, Long> result = Arrays.stream(str.split(" "))
				// .map(String::toLowerCase)
				.collect(Collectors.groupingBy(s -> s, HashMap::new, Collectors.counting()));
		System.out.println(result);

		Map<String, String> map = new HashMap<>();

		map.put("1", "1");
		map.put("3", "3");
		map.put("2", "2");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println("");

	}
}
