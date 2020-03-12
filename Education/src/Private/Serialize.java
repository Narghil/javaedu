package Private;

import PG.Utils.IOUtils;

import java.io.Serializable;

class SerObj implements Serializable {
    private static final long serialVersionUID = -8388655430465083693L;
    private String someThing = "Empty";

    public String getSomeThing() {
        return someThing;
    }

    public void setSomeThing(String someThing) {
        this.someThing = someThing;
    }
}

public class Serialize {
    public static void main(String[] args) {
        SerObj thingOut = new SerObj();
        SerObj thingIn; // = new IOObject();
        IOUtils<SerObj, SerObj> iou = new IOUtils<>();
        int iErr = -1;

        thingOut.setSomeThing("I am an Serializable object");
        iou.SerOut(thingOut, "IOFile.ser");
        System.out.println("Output:" + thingOut.getSomeThing());

        thingIn = iou.SerInp("IOFile.ser");
        System.out.println("Input :" + thingIn.getSomeThing());
        System.out.println(iErr);

    }
}
