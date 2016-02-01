package matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IsLesserThanTest {

	@Test
	public void isLesserThan() {
		assertThat(4, is(new IsLesserThanMatcher(5)));
	    assertThat(3, is(not(new IsLesserThanMatcher(2))));			
	}

}
