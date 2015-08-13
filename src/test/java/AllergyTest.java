import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class AllergyTest {

  @Test
  public void getScore_ReturnsErrorIfNumGreaterThan256_ArrayList() {
      Allergy testAllergy = new Allergy();
      ArrayList<String> answer = new ArrayList<>();
      assertEquals(answer, testAllergy.allergyName(300));
  }

@Test
public void getScore_ReturnsCorrectAllergyName_ArrayList(){
  Allergy testAllergy = new Allergy();
  ArrayList<String> answer = new ArrayList<>();
  answer.add("eggs");
  assertEquals(answer, testAllergy.allergyName(1));
}

@Test
public void getScore_ReturnsCorrectAllergyNameList_ArrayList(){
  Allergy testAllergy = new Allergy();
  ArrayList<String> answer = new ArrayList<>();
  answer.add("chocolate");
  answer.add("eggs");
  assertEquals(answer, testAllergy.allergyName(123));
}

// @Test
// public void whoWins_ReturnsValueForKeyThatEqualsPlayerTwoGuess_String_3(){
//   RockPaper testRockPaper = new RockPaper();
//   assertEquals("It's a tie.", testRockPaper.whoWins("rock", "rock"));
// }
//
// @Test
// public void whoWins_ChangesCaseToLowerCase_String(){
//   RockPaper testRockPaper = new RockPaper();
//   assertEquals("It's a tie.", testRockPaper.whoWins("ROCK", "roCk"));
// }

}
