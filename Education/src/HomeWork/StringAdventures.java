package HomeWork;

public class StringAdventures {
    public static void main(String[] args) {
        StringBuilder sentence = new StringBuilder( String.join(" ", new String[]{"Indul","a","görög","aludni"}) );
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