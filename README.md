# Automaattestimine_HT4_Tasks

Harjutstund 4

Projekti tooriku import: Eclipse-ist File -> Import... -> Projects from Git
ja kirjutage https://bitbucket.org/mkalmo/atex.git URI-ks.

Ülesanne 1

  Kirjutage Hamcrest matcher, mis võimaldab "on väiksem" võrdlust.
  
    assertThat(1, isLesserThan(2));
  
  Matcher-i näide:
  
      public class IsGreaterThanMatcher
            extends TypeSafeMatcher<Integer> {
  
        private Integer expected;
  
        public IsGreaterThanMatcher(Integer expected) {
            // jätta meelde oodatav väärtus (andud näites 2)
        }
  
        @Override
        public void describeTo(Description description) {
            description.appendText("..."); // kirjeldus selleks, kui võrdlus ebaõnnestub
        }
  
        @Override
        protected boolean matchesSafely(Integer actual) {
            return ...; // tõene, kui actual on väiksem oodatavast (antud näites 1 < 2)
        }
    }
  
    assertThat(2, is(new IsGreaterThanMatcher(1)));
    assertThat(1, is(not(new IsGreaterThanMatcher(2))));

Ülesanne 2

  Ülesande eesmärk on kasutada testimise mustrit, mis teisendab tulemusd stringiks.
  
  Pange tööle esimesed kaks testi klassis string.OrderServiceTest.
  Selleks peate kirjutama testide abimeetodid ja testitavad OrderService klassi meetodid.
  
  Testitavate meetodite kirjeldused:
  
    List<Order> getFilledOrders()
        - tagastab täidetud (filled) tellimused.
  
    List<Order> getOrdersOver(double amount)
        - tagastab tellimused, mis ületavad argumendina etteandud summat.

Ülesanne 3

  Kirjutge lõpuni klassid person.PersonUtilTest ja person.PersonBuilder.

  Testitav klass on person.PersonUtil meetoditega:

    getOldest(List<Person> persons) - tagastab vanima isiku.
    getPersonsInLegalAge(List<Person> persons) - tagastab isikud kes on 18+ aastat vanad.
    getWomen(List<Person> persons) - tagastab naissoost isikud.
    getPersonsWhoLiveIn(String town, List<Person> persons) - tagastab isikud, kes elavad määratud linnas.

  Testige ka tühja listi ja null-iga.
