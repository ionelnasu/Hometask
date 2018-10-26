import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		String sentence = "aAb bbb aDaD ccc DDDD";

		// length == 3 -> toUpperCase
		// AAB BBB CCC DDDD

		// length ==4 -> toLowerCase
		// aAb bbb ccc dddd

		Function<String, String> f1 = s -> s.toUpperCase();

		Function<String, String> f2 = s -> s.toLowerCase();

		Predicate<String> p1 = t -> t.length() == 3;

		Predicate<String> p2 = t -> t.length() == 4;

		System.out.println(transform(sentence, f1, p1));
		System.out.println(transform(sentence, f2, p2));
		System.out.println("****************************");
		System.out.println(sum("10,15,10"));

	}
		
	public static String transform(String sentence, 
			Function<String, String> f,
			Predicate<String> p) {
		String [] words = sentence.split(" ");
		for(int i=0;i<words.length;i++) {
			String word = words[i];
			if(p.test(word)) {
				words[i] = f.apply(word);
			}
		}
		return String.join(" ", words);
	}
	
//	public static Integer sum(String s){
//		String[] num = s.split(",");
//		Integer res = 0; 
//		for (String str:num){
//			res += Integer.parseInt(str);// res = res + int
//		}
//			return res;	
//		}
	
//	public static Integer sum2(String s) {
//		return Integer.parseInt(s);
//	}
	
//	public static Integer sum(String s) {
//		String[] numbers = s.split(",");
//		
//		if(numbers.length == 1){
//			return Integer.parseInt(numbers[0]);
//		}
//		return Integer.parseInt(numbers[0])
//				+Integer.parseInt(numbers[1]);
//	}
	
	public static Integer sum(String s) {
		if(s == null){
		return 0;
		}
		List<String> numbers = Arrays.asList(s.split(","));
		Integer ret = 0;
		ret = numbers.stream().filter(x ->isDigit(x)).map(x -> Integer.parseInt(x)).mapToInt(x -> x).sum();
		
		return ret;
	}

	
	public static boolean isDigit(String s) {
		try {
			Integer i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
}