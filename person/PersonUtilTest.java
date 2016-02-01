package person;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.collection.IsIterableContainingInOrder;

import static java.util.Arrays.*;

import org.junit.Assert;
import org.junit.Test;

public class PersonUtilTest {

    private PersonUtil personUtil = new PersonUtil();

    @Test
    public void findsOldestPerson() {
        Person p1 = aPerson().withAge(32).build();
        Person p2 = aPerson().withAge(55).build();
        Person p3 = aPerson().withAge(21).build();

        assertThat(personUtil.getOldest(asList(p1, p2, p3)), is(p2));
    }

	@Test
    public void findsPersonsInLegalAge() {
    	Person p1 = aPerson().withAge(15).build();
    	Person p2 = aPerson().withAge(18).build();
    	Person p3 = aPerson().withAge(25).build();
    	
    	assertThat(personUtil.getPersonsInLegalAge(asList(p1, p2, p3)), CoreMatchers.hasItems(p2, p3));
    }

    @Test
    public void findsWomen() {
    	Person p1 = aPerson().withGender(Person.GENDER_FEMALE).build();
    	Person p2 = aPerson().withGender(Person.GENDER_MALE).build();
    	Person p3 = aPerson().withGender(Person.GENDER_FEMALE).build();
    	Person p4 = aPerson().withGender(Person.GENDER_MALE).build();
       
    	assertThat(personUtil.getWomen(asList(p1, p2, p3, p4)), CoreMatchers.hasItems(p1, p3));
    }

    @Test
    public void findsPersonsLivingInSpecifiedTown() {
    	Person p1 = aPerson().withAddress(new Address("Kadaka", "Tallinn")).build();
    	Person p2 = aPerson().withAddress(new Address("Õpilase tee", "Tartu")).build();
    	Person p3 = aPerson().withAddress(new Address("Kadaka", "Tallinn")).build();
    	
    	assertThat(personUtil.getPersonsWhoLiveIn("Tallinn", (asList(p1, p2, p3))), CoreMatchers.hasItems(p1, p3));
    }
    
	@Test(expected = IllegalArgumentException.class)
	public void dependingOnTheMethodArgumentsShouldNotBeNullOrEmptyOrBothTogether() throws IllegalArgumentException {
		personUtil.getPersonsWhoLiveIn(null, null);
		personUtil.getOldest(null);
		personUtil.getOldest(Collections.<Person>emptyList());
		personUtil.getPersonsInLegalAge(null);
		personUtil.getWomen(null);
	}

    private PersonBuilder aPerson() {
        return new PersonBuilder();
    }
}
