appjangle-helloworld
====================

App Jangle - Hello World - Bob Danani

Task 1 - 3 = DONE

Task 4: Had some issues
Using the Link created in task 3 (EnhancedHello-appJangle project),
I then tried to retrieve the corresponding translation values based on the language input.
These are my attempt for the task 4:

System.out.println("ATTEMPT 1 \n GETTING THE VALUE MANUALLY - this works, but I guess it is not efficient");
System.out.println("String val1 = session.node(linkmaps.get(LANG1)).get().value().toString();");
System.out.println("String val2 = session.node(linkmaps.get(LANG2)).get().value().toString();");
System.out.println("System.out.println(LANG1 + \" = \" + val1);");
System.out.println("System.out.println(LANG2 + \" = \" + val2);\n");
        
String val1 = session.node(linkmaps.get(LANG1)).get().value().toString();
String val2 = session.node(linkmaps.get(LANG2)).get().value().toString();
System.out.println(LANG1 + " = " + val1);
System.out.println(LANG2 + " = " + val2);
        
        
        
System.out.println("\nATTEMPT 2 ");
System.out.println("GETTING ALL TRANSLATIONS USING selectAll \n" + 
     "But do we really to fetch all the translations records just to select the one that we are interested?");
System.out.println("ListQuery all = session.node(translationsURL).selectAll();");
System.out.println("System.out.println(all.get().values().toString());\n");
ListQuery all = session.node(translationsURL).selectAll();
System.out.println(all.get().values().toString());
System.out.println("For some reason the above line will only work and print out all the translation values if I uncomment all the codes in the ATTEMPT1 section - not sure why");
        