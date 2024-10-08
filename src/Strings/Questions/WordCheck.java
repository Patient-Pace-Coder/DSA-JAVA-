package Strings.Questions;

public class WordCheck {


//    Write a program to check if the word 'orange' is present in the "This is orange juice".

    private static boolean isWordPresent(String word, String target){

        for( int i=0; i< word.length(); i++){

            if( word.toLowerCase().charAt(i) != 'o'){
                continue;
            }
            else if ( word.toLowerCase().charAt(i) == 'o'){

                boolean isEqual = true;
                int k = 1;
                for ( int j = i + 1; j < word.length(); j++){

                    if ( k < target.length() ) {
                        if (word.charAt(j) == target.charAt(k)) {
                            k++;
                        } else {
                            isEqual = false;
                            break;
                        }
                    }
                }

                if ( isEqual ){
                    return isEqual;
                }

            }
        }

        return false;

    }

    public static void main(String[] args) {

        System.out.println(isWordPresent("This is orange juice" , "orange"));
    }
}
