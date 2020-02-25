package HomeWork;

public class StringAdventures {
    public static void main(String[] args) {
        String[] sentences = {"Indul","a","görög","aludni"};
        StringBuilder sentence = new StringBuilder();

        for (String s:sentences) {
            sentence.append(s);
        }

        System.out.println(sentence.reverse());
    }
}

/*
 Ismerd meg a StringBuilder osztályt!
 A metódusainak használatával oldd meg a következő ferladatot! (StringAdventures.java)
 a./ Fűzd össze ennek a tömbnek a tartalmát egyetlen string-gé és mentsd el egy sentence nevű változóba:
   ["Indul", "a", "görög", aludni"]
 b./ A sentence tartalmát írasd ki visszafelé!
 */