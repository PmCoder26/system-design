package composite_design_pattern.solution_1_file_structure;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************************** Composite Design Pattern ******************************");

        // create directory folder.
        Directory movies = new Directory("movies", new ArrayList<>());

        // create directories for bollywood and hollywood movies.
        Directory hollywood = new Directory("hollywood", new ArrayList<>());
        Directory bollywood = new Directory("bollywood", new ArrayList<>());

        // add both to the movies' directory.
        movies.add(hollywood);
        movies.add(bollywood);

        // add files to bollywood.
        FileSystemComponent b1 = new File("Sultan");
        FileSystemComponent b2 = new File("3 idiots");
        FileSystemComponent b3 = new File("Narsimha");
        FileSystemComponent b4 = new File("Student of the year");
        bollywood.add(b1);
        bollywood.add(b2);
        bollywood.add(b3);
        bollywood.add(b4);

        // add files to hollywood.
        FileSystemComponent h1 = new File("Avengers");
        FileSystemComponent h2 = new File("Star Wars");
        FileSystemComponent h3 = new File("Spiderman");
        FileSystemComponent h4 = new File("Batman");
        hollywood.add(h1);
        hollywood.add(h2);
        hollywood.add(h3);
        hollywood.add(h4);

        // printing all the contents of movies directory.
        movies.ls();

    }

}
