import java.util.TreeMap;

import io.nextweb.Link;
import io.nextweb.ListQuery;
import io.nextweb.Node;
import io.nextweb.Query;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;

public class RetrievalHello {

    public static void main(String[] args) {
        Session session = Nextweb.createSession();
        final String LANG1 = "Portuguese";
        final String LANG2 = "German";
        
        final String translationsURL = "http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/transla1";
        Link aLanguage = session.node("http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/aLanguage");
        
        //ATTEMPT 1
        /*
        TreeMap <String, String> linkmaps = new TreeMap <String, String>();
        linkmaps.put("English", "http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/transla1/Hello_W1");
        linkmaps.put("Indonesian", "http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/transla1/Halo_Du2");
        linkmaps.put("Portuguese", "http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/transla1/Ola_Mun3");
        linkmaps.put("French", "http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/transla1/Bonjour4");
        linkmaps.put("German", "http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/transla1/Hallo_W5");
        
        String val1 = session.node(linkmaps.get(LANG1)).get().value().toString();
        String val2 = session.node(linkmaps.get(LANG2)).get().value().toString();
        
        System.out.println(LANG1 + " = " + val1);
        System.out.println(LANG2 + " = " + val2);
        */
        
        
        //ATTEMPT 2
        ListQuery all = session.node(translationsURL).selectAll();
        
        for (int i = 0; i < all.get().size(); ++i){
        	Node n = all.get().get(i);
        	Query q = n.select(aLanguage);
        	String language = q.get().value().toString();
        	if (language.equals(LANG1))
        		System.out.println("Translation of Hello World in " + language +  " = " + n.value());
        	else if (language.equals(LANG2))
        		System.out.println("Translation of Hello World in " + language +  " = " + n.value());
        }
       

        session.close().get();
    }

}