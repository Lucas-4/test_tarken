import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class App {

    public static void main(String[] args) throws Exception {

        File file = new File("./src/meteor_challenge_01.png");
        BufferedImage img = ImageIO.read(file);

        // total number of meteors
        int meteors = 0;
        // total number of stars
        int stars = 0;
        // number of meteors that will land on water
        int meteorsOnWater = 0;
        for (int x = 0; x < img.getWidth(); x++) {
            // variable used to count how many meteors are in a column
            int meteorsInColumn = 0;
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel, true);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                if (red == 255 && green == 0 && blue == 0) {
                    meteors++;
                    meteorsInColumn++;
                }

                if (red == 255 && green == 255 && blue == 255) {
                    stars++;
                }

                if (red == 0 && green == 0 && blue == 255) {
                    meteorsOnWater += meteorsInColumn;
                    break;
                }

            }

        }

        System.out.println("Number of meteors: " + meteors);
        System.out.println("Number of stars: " + stars);
        System.out.println("Number of meteors that will land on water: " +
                meteorsOnWater);

    }
}
