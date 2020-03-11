package Private;

import PG.Utils.IOUtils;

import java.io.Serializable;

class IOObject implements Serializable {
    private static long SerialVersionUID = -1L;
    private String someThing = "Empty";

    public String getSomeThing() {
        return someThing;
    }

    public void setSomeThing(String someThing) {
        this.someThing = someThing;
    }
}

public class IO {
    public static void main(String[] args) {
        IOObject thingOut = new IOObject();
        IOObject thingIn; // = new IOObject();
        IOObject tIn2 = new IOObject();
        IOUtils iou = new IOUtils();
        int iErr = -1;

        thingOut.setSomeThing("Serializable object I am");
        iou.SerOut(thingOut, "IOFile.ser");
        System.out.println(thingOut.getSomeThing());

        thingOut.setSomeThing("I am an Serializable object");
        iou.SerOut(thingOut, "IOFile.ser");
        System.out.println(thingOut.getSomeThing());

        thingIn = (IOObject) iou.SerInp("IOFile.ser", tIn2, iErr);
        System.out.println(thingIn.getSomeThing());
        System.out.println(tIn2.getSomeThing());
        System.out.println(iErr);

    }
}
