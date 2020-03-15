package PG.Utils.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize<S> {
    //Szerializálás:
    public void SerOut(S s, String fname) {
        FileOutputStream fso;
        ObjectOutputStream oos = null;

        try {
            fso = new FileOutputStream(fname);
            oos = new ObjectOutputStream(fso);
            oos.writeObject(s);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Deszerializálás:
    public S SerInp(String fname) {
        FileInputStream fsi;
        ObjectInputStream ois = null;
        S res = null;
        Object o;

        try {
            fsi = new FileInputStream(fname);
            ois = new ObjectInputStream(fsi);
            o = ois.readObject();
            //if (o instanceof G) {
            res = (S) o;
            //}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

}
