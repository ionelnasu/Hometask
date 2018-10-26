import static org.junit.Assert.assertEquals;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.Ignore;
import org.junit.Test;

public class TransformTest {

	@Test

	public void test() {

		String sentence = "aAb bbb aDaD ccc DDDD";
		Function<String, String> f1 = s -> s.toUpperCase();
		Predicate<String> p1 = t -> t.length() == 3;

		String result = Main.transform(sentence, f1, p1);

		String expected = "AAB BBB aDaD CCC DDDD";

		assertEquals(expected, result);

	}

	@Test

	public void testSingleNumber() {
		String input = "2";
		Integer expected = 2;
		
		Integer actual = Main.sum(input);
		assertEquals(expected, actual);

	}
	
	@Test

	public void testTwoNumbers() {
		String input = "2,3";
		Integer expected = 5;
		
		Integer actual = Main.sum(input);
		assertEquals(expected, actual);

	}
	
	@Test

	public void test3Numbers() {
		String input = "2,3,4";
		Integer expected = 9;
		
		
		Integer actual = Main.sum(input);
		assertEquals(expected, actual);

	}
	
	@Test // (expected = NumberFormatException.class)

	public void testnotNumbers() {
		String input = "2,a,4";
		Integer expected = 6;

		Integer actual = Main.sum(input);
		assertEquals(expected, actual);

	}
	
	@Ignore("Test is ignored since we dont know what to do!?!")
	@Test
	public void testNull(){
		String input = null;
		Integer actual =Main.sum(input);
		
	}
	
}
