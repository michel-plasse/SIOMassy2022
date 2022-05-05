package dao;

import modele.EFG;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import dao.EFGDao;
import java.util.List;
/**
 *
 * @author ak
 */
public class EFGDaoTest {
    
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        EFG result = EFGDao.getById(1);
        assertEquals(2, result.getGroupes().size());
        assertEquals(3, result.getGroupes().get(0).getMembres().size());
        
        
    }

    
}
