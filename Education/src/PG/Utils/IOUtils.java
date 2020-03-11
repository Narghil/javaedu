package PG.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOUtils<S> {
    private FileOutputStream fso;
    private ObjectOutputStream oos;
    private FileInputStream fsi;
    private ObjectInputStream ois;

    public void SerOut(S s, String fname) {

        try {
            fso = new FileOutputStream(fname);
            oos = new ObjectOutputStream(fso);
            oos.writeObject(s);
            oos.close();
        } catch (Exception exp) {
            //nothing yet
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                //nothing yet
            }
        }
    }

    public S SerInp(String fname, S second, int iErr) {
        S res = null;

        try {
            fsi = new FileInputStream(fname);
            ois = new ObjectInputStream(fsi);
            second = (S)ois.readObject();
            res = second;
            iErr = 100;
        } catch (Exception exp) {
            //nothing yet
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
                //nothing yet
            }
        }
        return res;
    }
}
