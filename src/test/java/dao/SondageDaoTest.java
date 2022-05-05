package dao;

import modele.Personne;
import modele.Sondage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cheick LANIKPEKOUN
 */
public class SondageDaoTest {
  
  @Test
  public void testGetByIdSondage() throws Exception {
    System.out.println("getByIdSondage");
    Personne createur = new Personne(1, "Tryphon", "Tournesole");
    Sondage expected = new Sondage(1, 1, 1, "Avez-vous fini ?", createur);
    Sondage result = SondageDao.getByIdSondage(1);
    System.out.println("expected " + expected);
    System.out.println("result " + result);
    assertEquals(expected, result);
  }
  
}
