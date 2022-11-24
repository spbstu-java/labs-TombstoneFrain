import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        int _size = readSize();

        try
        {
            float[][] baseArray = new float[_size][_size];

            fillArray(baseArray, _size);
            printArray(baseArray, _size);

            float[][] rotArray = rotateArray(baseArray, _size);
            writeArrayToFile(divArray(rotArray, _size), _size);

            rotArray = rotateArray(rotArray, _size);
            writeArrayToFile(divArray(rotArray, _size), _size);

            rotArray = rotateArray(rotArray, _size);
            writeArrayToFile(divArray(rotArray, _size), _size);
        }
        catch (OutOfMemoryError e)
        {
            LogManager lgmngr = LogManager.getLogManager();
            Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            log.log(Level.INFO, "Unexpected error: ", e);
        }
    }

    static int readSize () {
        try
        {
            File f = new File("size.txt");
            if (!f.canRead()) throw new FileAccessException();

            try(BufferedReader br = new BufferedReader(new FileReader(f))) {

                String s;
                if ((s = br.readLine()) != null) {
                    try {
                        int c = Integer.parseInt(s);

                        if (c > 1000000) throw new LargeValueException();
                        return c;
                    } catch (NumberFormatException | LargeValueException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        catch(FileAccessException | IOException ex){
            System.out.println(ex.getMessage());
        }
        return 1; //Возвращаем дефолтное значение
    }

    static void printArray (float[][] array, int size) {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(" " + array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    static void fillArray (float[][] array, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                array[i][j] = rand.nextInt(size * -1,size + 1);
            }
        }
    }

    static float[][] rotateArray(float[][] array, int size) {
        float[][] rotated = new float[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                rotated[j][i] = array[size - i - 1][j];
            }
        }
        return rotated;
    }

    static float[][] divArray (float[][] array, int size) {
        float[][] divided = new float[size][size];

        int div;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                try {
                    div = 0;
                    if (i > 0) div += array[i - 1][j];
                    if (i < size - 1) div += array[i + 1][j];
                    if (j > 0) div += array[i][j - 1];
                    if (j < size - 1) div += array[i][j + 1];

                    if (div == 0) throw new NullDividedException();

                    divided[i][j] = array[i][j] / div;
                }
                catch (NullDividedException ex)
                {
                    System.out.println(ex.getMessage());
                    divided[i][j] = 0;
                }
            }
        }
        return divided;
    }

    static void writeArrayToFile (float[][] array, int size) {
        try(FileWriter writer = new FileWriter("output.txt", true))
        {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    writer.write(String.format("%.6f", array[i][j]) + "\t");
                }
                writer.write("\n");
            }
            writer.write("\n");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}