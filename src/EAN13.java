/**
 * Classe volta al controllo della validità di un codice EAN
 * @author Andrea Gulfo
 * @version 1.0
 * @since 10/05/2023
 */
public class EAN13 {
    
    private String codice;
    /**
     * Metodo volto alla creazione di nuove instanze
     * @param c parametro volto al passaggio di una stringa contente il valore del codice EAN da controllare
     */
    
    public void setCodice(String c){
        codice = c;
    }

    /**
     * Metodo volto al ritorno in output del codice inserito per il controllo 
     * */ 
    public String getCodice(){
        return codice;
    }

     /**
     * Metodo volto al controllo del codice inserito in precedenza 
     * @return vero se il codice è corretto falso se invece il codice non rispetta le caratteristiche del codice EAN
     * */ 
    public boolean verificaCodice(){

        // Verifica se l'attributo codice è vuoto o nullo
        if (codice.equals(null) || codice == ""){
            throw new NullPointerException("Il codice EAN-13 risulta vuoto o nullo");
        }

        // Verifica se la lunghezza dell'attributo codice è di 13
        if(codice.length() != 13) {
            return false;
        }
        
        // Implementazione dell'algoritmo di calcolo della cifra di controllo
        int somma = 0;
        int cifra;
        
        for(int i = 0; i < codice.length() - 1; i++) {   
            cifra = Character.getNumericValue(codice.charAt(i));
            
            if(i % 2 == 0) {
                somma += cifra * 1;  
            } else {
                somma += cifra * 3; 
            }
        }
        
        // Calcola la cifra di controllo
        int cifraDiControllo = (10 - (somma % 10));

        // Confronta la cifra di controllo con quella contenuta nel codice EAN13 (ultima cifra)
        return cifraDiControllo == Character.getNumericValue(codice.charAt(12)); 
    }


}
