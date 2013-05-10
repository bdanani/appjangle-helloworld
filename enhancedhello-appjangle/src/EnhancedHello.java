import io.nextweb.Query;
import io.nextweb.Session;
import io.nextweb.jre.Nextweb;

public class EnhancedHello {

    public static void main(String[] args) {
        Session session = Nextweb.createSession();
        Query seed = session.seed();
        Query translations = seed.append("translations");
        
        //creating the types
        //not sure if I should append the aLanguageName on seed variable, 
        //or whether I should append them on the translation object itself
        Query aTranslation  = seed.append("A translation of hello in a unique language", "./aTranslation");
        Query aLanguageName = seed.append("Language name for the translation", "./aLanguage");
        
        //creating translation nodes (t1, t2, t3, t4, t5)
        Query t1 = translations.append("Hello World");
        Query t2 = translations.append("Halo Dunia");
        Query t3 = translations.append("Ola Mundo");
        Query t4 = translations.append("Bonjour tout le monde");
        Query t5 = translations.append("Hallo Welt");
        t1.append(aTranslation);
        t2.append(aTranslation);
        t3.append(aTranslation);
        t4.append(aTranslation);
        t5.append(aTranslation);
        
        //initialising the language attribute for each translation object
        t1.append("English").append(aLanguageName);
        t2.append("Indonesian").append(aLanguageName);
        t3.append("Portuguese").append(aLanguageName);
        t4.append("French").append(aLanguageName);
        t5.append("German").append(aLanguageName);
   
        session.commit().get();
        
        System.out.println("Link for translations object:\t"+translations.get());
        System.out.println("Link for a translation type:\t"+aTranslation.get());
        System.out.println("Link for a language type:\t"+aLanguageName.get());
        System.out.println("Link for t1 :\t"+t1.get());
        System.out.println("Link for t2 :\t"+t2.get());
        System.out.println("Link for t3 :\t"+t3.get());
        System.out.println("Link for t4 :\t"+t4.get());
        System.out.println("Link for t5 :\t"+t5.get());
        
        session.close().get();
    }

}