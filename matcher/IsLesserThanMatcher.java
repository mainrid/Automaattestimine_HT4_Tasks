package matcher;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;



public class IsLesserThanMatcher extends TypeSafeMatcher<Integer>{

		private Integer expected;

		public IsLesserThanMatcher(Integer expected) {
			// jätta meelde oodatav väärtus (andud näites 2)
			this.expected=expected;
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("expected number is less then actual parameter"); // kirjeldus selleks, kui võrdlus
											// ebaõnnestub
		}

		@Override
		protected boolean matchesSafely(Integer actual) {
		return expected > actual; 
 
	}
		

		
		
	
}

