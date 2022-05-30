import java.io.*;

public class ReadDataUtil {

    // Reads the position and velocity vector on the specified 'day' from the file with the
    // specified 'path', and sets position and current velocity of 'b' accordingly. If
    // successful the method returns 'true'. If the specified 'day' was not found in the file,
    // 'b' is unchanged and the method returns 'false'.
    // The file format is validated before reading the state.
    // Lines before the line "$$SOE" and after the line "$$EOE" the are ignored. Each line of the
    // file between the line "$$SOE" and the line "$$EOE" is required to have the following format:
    // JDTDB, TIME, X, Y, Z, VX, VY, VZ
    // where JDTDB is interpretable as a 'double' value, TIME is a string and X, Y, Z, VX, VY and
    // VZ are interpretable as 'double' values. JDTDB can be ignored. The character ',' must only
    // be used as field separator. If the file is not found, an exception of the class
    // 'StateFileNotFoundException' is thrown. If it does not comply with the format described
    // above, the method throws an exception of the class 'StateFileFormatException'. Both
    // exceptions are subtypes of 'IOException'.
    // Precondition: b != null, path != null, day != null and has the format YYYY-MM-DD.
    public static boolean readConfiguration(NamedBody b, String path, String day)
            throws IOException {

            // TODO: implement this method.
            return false;
        }
    }

