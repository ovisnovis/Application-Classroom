import FileHandling.Reader;
import alumni.Hobos;
import alumni.Student;

import java.util.ArrayList;
import java.util.List;

public class ApplicationLauncher {
    public static void main(String[] args) {
        for (Hobos hobos :
                Reader.displayHobo()) {
            System.out.println("this is the " + hobos.name + " number: " + hobos.averageHobo());
        }
    }

}