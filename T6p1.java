import java.io.*;
import java.util.*;
import java.util.regex.*;
public class T6p1 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Falta el nombre de archivo");
            System.exit(0);
        }
        FileReader fi = null;
        try {
            fi = new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
        //Usar para leer linea x linea el archivo
        String textLine = null;
        BufferedReader inputFile = new BufferedReader(fi);
        int lineCount = 0;
        int wordCount = 0;
        int numberCount = 0;
        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";
        //Pattern pat = stopWords[0-9];
        Pattern pat = Pattern.compile("[0–9]*");

        //hashsetstring stopwords=loadstopwords
        HashSet<String> loadstopwords;
        HashSet<String> stopwords = loadstopwords;


        // Lista con todas las palabras diferentes
        ArrayList<String> list = new ArrayList<String>();
        // Tiempo inicial
        long startTime = System.currentTimeMillis();
        try {
            while ((textLine = inputFile.readLine()) != null) {
                lineCount++;

                if (textLine.trim().length() == 0) {
                    continue; // la linea esta vacia, continuar
                }
                // separar las palabras en cada linea
                String words[] = textLine.split(delimiters, pat.flags());
                wordCount += words.length;

                for (String word : words) {
                    word = word.toLowerCase();
                }
                Matcher mat  = Pattern.matcher(inputFile);
                if(!mat.matches()  && !stopwords.contains(words) {
                    System.out.print(word);
                    System.out.print(" ");
                }
                    System.out.println();
                    wordCount++;

                in.close();
                fi.close();


                for (String theWord : words) {
                    theWord = theWord.toLowerCase().trim();
                    boolean isNumeric = true;
                    // verificar si el token es un numero
                    try {
                        Double num = Double.parseDouble(theWord);
                    } catch (NumberFormatException e) {
                        isNumeric = false;
                    }
                    // Si el token es un numero, pasar al siguiente
                    if (isNumeric) {
                        numberCount++;
                        continue;
                    }
                    // si la palabra no esta en la lista, agregar a la lista
                    if (!list.contains(theWord)) {
                        list.add(theWord);
                    }
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static HashSet<String> deletStopWord(Set stopWords) {

        try {
            FileReader fi = null;
            fi = new FileReader("texto.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
        //String textLine = null;
        //Reader aaa = null;
        BufferedReader fi = new BufferedReader((Reader) stopWords);
        HashSet<String> ford = new HashSet<String>();
        ford.add(String.valueOf(fi));
        Iterator<String> itr = ford.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        return ford;
    }
}

