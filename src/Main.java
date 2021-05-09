import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\IdeaProjects\\Polynominal approximation\\test.txt");
        Scanner sc = new Scanner(file);

        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(System.in));
        //System.out.print("Podaj wartość x: ");
        //int polynominalDegree = Integer.parseInt(buffer.readLine());

        int n = 4;
        int tmp = 0;
        int tmp2 = 0;
        float values[] = new float[n];
        float matrix[][] = new float[n][n];

        while (sc.hasNextFloat()) {
            matrix[tmp][1]  = sc.nextFloat();
            tmp++;
            if (!sc.hasNextFloat() && sc.hasNextLine()) {
                break;
            }
        }

        while (sc.hasNext()) {
                values[tmp2]= Float.parseFloat(sc.next());
                tmp2++;
        }
        sc.close();
        System.out.println(Arrays.toString(values));
    for (int i=0; i<tmp; i++)
    {
        for (int j=0; j<tmp; j++)
        {
                matrix[i][j]= (float) Math.pow(matrix[i][1],j);
        }
    }
        String result = Arrays
                .stream(matrix)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(result);


     /*       PrintWriter zapis = new PrintWriter("Newton Wynik.txt");
        zapis.println("Wartość w " + df.format(value) + " wynosi " + df.format(applyFormula(value, x, y, n)));
        zapis.println(result2);
        zapis.close();*/
    }
}
