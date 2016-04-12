package it.polito.tdp.model;


import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.ParolaDAO;


public class AnagrammiModel {

	//metodo in cui innesco il metodo ricorsivo
	public List<String> findAllAnagrams(String s) {
		// TODO Auto-generated method stub
		
		List<String> lista = new ArrayList<String>();
		
		anagrams("",s, lista);
		
		return lista;
	}
	
	
    public void anagrams(String prefix, String word, List<String> list) {
        if(word.length() <= 1) {
            list.add(prefix + word);
        } 
        else {
            for(int i = 0; i < word.length(); i++) {
                String current = word.substring(i, i + 1);//current letter
                String before = word.substring(0, i); // letters before the current
                String after = word.substring(i + 1); // letters after the current
                anagrams(prefix + current, before + after, list);
                
            }
       }
   }
    
    
    
     // versione iterativa
    
    /*
     * l'idea è la seguente:
     * -inizialmente memorizzo in lista una sola permutazione (in progress perchè non è completa)
     * 	e formata da una sola lettera (chars[0])della parola s
     * -ora prendo (grazie al primo ciclo) un'altra lettera non ancora usata, estraggo dalla lista
     *  la mia permutazione e inserisco la nuova lettera in tutti gli spazi tra lettere della mia
     *  permutazione (in questo caso 2: o prima o dopo chars[0]) grazie al secondo ciclo
     *  Così ora la lista contiene tutte le possibili permutazioni di char[0] e char[1]
     * -ora prendo una terza lettera, chat[2], e, per ogni permutazione delle due lettere precedenti,
     *  estraggo tale permutazione e inserisco la nuova lettera in ogni possibile spazio
     *  Così ora ho in lista tutte le possibili permutazioni di char[0], char[1] e char[2]
     * - e così via...
     */
    
 /*  public List<String> findAllAnagrams(String s) {
     	List<String> lista = new ArrayList<String>();
     
        char[] chars = s.toCharArray();
        lista.add(new String("" + chars[0]));
        for(int j=1; j<chars.length; j++) {
            char c = chars[j];
            int cur_size = lista.size();
            //create new permutations combing char 'c' with each of the existing permutations
            for(int i=cur_size-1; i>=0; i--) {
            	//remove restituisce la permutazione che ho tolto dalla lista.
            	//perciò rimuovo dalla lista l'ultima permutazione inserita
                String str = lista.remove(i);
                for(int l=0; l<=str.length(); l++) {
                    lista.add(str.substring(0,l) + c + str.substring(l));
                }
            }
        }
     
     	return lista;
      }
 */   
    
    

	public boolean isPresent(String word) {
		// TODO Auto-generated method stub
		ParolaDAO dao= new ParolaDAO();
		
		return dao.isPresent(word);
	}

}
