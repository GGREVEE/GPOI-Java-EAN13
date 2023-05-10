import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;


public class TestEAN13 {
    private static EAN13 ean;

    @Before
    public void init(){
    ean = new EAN13();

    }  
    @Test
    public void testEanVerificaCodiceValido(){
        ean.setCodice("3614273613422");
        assertTrue(ean.verificaCodice());
        
    }
    @Test
    public void testEanVerificaCodiceVuoto(){
        ean.setCodice("");
        assertThrows(NullPointerException.class,()-> ean.verificaCodice());
    }
    @Test
    public void  testEanVerificaCodiceNonValido(){
        ean.setCodice("3614273613427");
        assertFalse(ean.verificaCodice());
    }
    @Test
    public void testEanVerificaCodiceLunghezzaNonValida(){
        ean.setCodice("3614273613427345667");
        assertFalse(ean.verificaCodice());
    }

}
