/*
Joseph Rosw-Provey
Data Structures
Professor Douglass
12/3/2024
 */
public class Alphabet {


    //returns the index number that corisponds with the letter provided
    public static int getAlphaValue(Character character){
        Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        //loops through alphabet, once it finds something it equals to, it returns the index + 1
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] == Character.toLowerCase(character)){
                return(i); //letter found
            }
        }
        return -1; //letter not found
    }
}