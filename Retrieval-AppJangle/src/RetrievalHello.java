import java.util.TreeMap;

import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Query;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;

public class RetrievalHello {

    public static void main(String[] args) {
        Session session = Nextweb.createSession();
        final String LANG1 = "Portuguese";
        final String LANG2 = "German";
        
        final String translationsURL = "http://slicnet.com/seed1/seed1/6/2/2/6/h/sd/transla1";
        //Link aTranslation = session.node("http://slicnet.com/seed1/seed1/6/2/2/0/h/sd/aTranslation");
        //Link aLanguage = session.node("http://slicnet.com/seed1/seed1/6/2/2/1/h/sd/aLanguage");
        
        TreeMap <String, String> linkmaps = new TreeMap <String, String>();
        linkmaps.put("English", "http://slicnet.com/seed1/seed1/6/2/2/6/h/sd/transla1/Hello_W1");
        linkmaps.put("Indonesian", "http://slicnet.com/seed1/seed1/6/2/2/6/h/sd/transla1/Halo_Du2");
        linkmaps.put("Portuguese", "http://slicnet.com/seed1/seed1/6/2/2/6/h/sd/transla1/Ola_Mun3");
        linkmaps.put("French", "http://slicnet.com/seed1/seed1/6/2/2/6/h/sd/transla1/Bonjour4");
        linkmaps.put("German", "http://slicnet.com/seed1/seed1/6/2/2/6/h/sd/transla1/Hallo_W5");
        
        //I can get the values by fetching it manually from the given link
        //but this is not efficient
        /*
        System.out.println("ATTEMPT 1 \n GETTING THE VALUE MANUALLY - this works, but I guess it is not efficient");
        System.out.println("String val1 = session.node(linkmaps.get(LANG1)).get().value().toString();");
        System.out.println("String val2 = session.node(linkmaps.get(LANG2)).get().value().toString();");
        System.out.println("System.out.println(LANG1 + \" = \" + val1);");
        System.out.println("System.out.println(LANG2 + \" = \" + val2);\n");
        
        String val1 = session.node(linkmaps.get(LANG1)).get().value().toString();
        String val2 = session.node(linkmaps.get(LANG2)).get().value().toString();
        
        System.out.println(LANG1 + " = " + val1);
        System.out.println(LANG2 + " = " + val2);
        
        */
        
        System.out.println("\nATTEMPT 2 ");
        System.out.println("GETTING ALL TRANSLATIONS USING selectAll \n" + 
        		"But do we really to fetch all the translations records just to select the one that we are interested?");
        System.out.println("ListQuery all = session.node(translationsURL).selectAll();");
        System.out.println("System.out.println(all.get().values().toString());\n");
        ListQuery all = session.node(translationsURL).selectAll();
        System.out.println(all.get().values().toString());
       
        System.out.println("For some reason the above line will only work and print out all the translation values if I uncomment all the codes in the ATTEMPT1 section - not sure why");
        
        System.out.println("\nATTEMPT 3 ");
        //I am thinking of using select to select the one the value that I am interested, but how
        //Using the approach in method 1, I can directly get the values without using select
        //But I believe that the first 2 approach are not efficient, as in most cases we would like to do something like:
        //getPost.select("LANGUAGE1");  - but how to do something like this? Please advise
        

        session.close().get();
    }

}