package Basics;

public class PassMeSomething {

    public static void main(String[] args) {
        byte b = 17;
        System.out.println("b in main() BEFORE method call: " + b);
        passMePrimitive(b);
        System.out.println("b in main() AFTER method call: " + b);

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("sb in main() BEFORE method call: " + sb);
        passMeObject1(sb);
        System.out.println("sb in main() AFTER method call: " + sb);

        System.out.println("sb in main() BEFORE method call: " + sb);
        passMeObject2(sb);
        System.out.println("sb in main() AFTER method call: " + sb);

        String str = new String("Hello");
        System.out.println("str in main() BEFORE method call: " + str);
        passMeString(str);
        System.out.println("str in main() AFTER method call: " + str);

    }

    static void passMePrimitive(byte b) {
        b = Byte.MAX_VALUE;
        System.out.println("b in method: " + b);
    }

    // Ebben a metodusban az atvett objektum referencianak uj erteket adunk, tehat "atmutatunk" vele egy uj StringBuilder peldanyra.
    // Ennek ertelemszeruen a main()-ben levo, eredeti StringBuilder peldanyra semmi hatasa nem lesz.
    static void passMeObject1(StringBuilder refCopy) {
        refCopy = new StringBuilder("Java is so easy.");
        System.out.println("sb in method: " + refCopy);
    }

    // Ebben a metodusban az atvett objektum referencia altal mutataott StringBuilder peldany belso allapotat piszkaljuk el.
    // Uj peldany nem jon letre, az a peldany, aminek modositjuk az allapotat ugyanaz, mint a main()-beli peldany.

    //DE EZ CLASSON BELÜL VAN!!! MI A HELYZET CLASSOK KÖZÖTT?! (STATIC ÉS NEM STATIC IS!)

    static void passMeObject2(StringBuilder refCopy) {
        refCopy.append(" George");
        System.out.println("sb in method: " + refCopy);
    }

    static void passMeString(String refCopy) {
        refCopy = refCopy + " passed ";
        System.out.println("str in method: " + refCopy);
    }

}