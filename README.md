appjangle-helloworld
====================

App Jangle - Hello World - Bob Danani

1. Hello - App Jange
Directory: hello-appjangle
Screenshot: appjangle_screenshot_1.png

Codes: 
	Session session = Nextweb.createSession();
	Query hello = session.seed().append("Hello, Java!");
	System.out.println("Created:\n"+hello.get());
	session.close().get();

2. Enhanced Hello - App Jange
Directory: enhancedhello-appjangle
Screenshot: appjangle_screenshot_2.png

Codes:
 	Query seed = session.seed();
        Query translations = seed.append("translations");
        
        //creating the types
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

3. Retrieval Hello - App Jange
Directory: Retrieval-AppJangle
Screenshot: appjangle_screenshot_3.png

Codes:
	Session session = Nextweb.createSession(); 
        final String LANG1 = "Portuguese";
        final String LANG2 = "German";
        
        final String translationsURL = "http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/transla1";
        Link aLanguage = session.node("http://slicnet.com/seed1/seed1/6/2/4/4/h/sd/aLanguage");
	ListQuery all = session.node(translationsURL).selectAll();
        
        for (int i = 0; i < all.get().size(); ++i){
        	Node n = all.get().get(i);
        	Query q = n.select(aLanguage);
        	String language = q.get().value().toString();
        	if (language.equals(LANG1))
        		System.out.println("Translation of Hello World in " 
			+ language +  " = " + n.value());
        	else if (language.equals(LANG2))
        		System.out.println("Translation of Hello World in " 
			+ language +  " = " + n.value());
        }
       
        session.close().get();


4. DATA MODEL
See the following files:
Data Model file: DataModel_Translations.png
Data Model Image Generator (using draw.io web application): DataModel_draw_io.xml

