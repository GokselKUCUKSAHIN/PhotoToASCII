package com.jellybeanci;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class ImageProcessor
{

    public static PixelElement[][] getImageArray(Image img)
    {
        // row, colum
        // y  , x
        // img[y,x]
        PixelReader pixelReader = img.getPixelReader();
        PixelElement[][] pixElArr = new PixelElement[(int) img.getHeight()][(int) img.getWidth()];
        for (int y = 0; y < img.getHeight(); y++)
        {
            for (int x = 0; x < img.getWidth(); x++)
            {
                Color color = pixelReader.getColor(x, y);
                pixElArr[y][x] = new PixelElement(color.getRed(), color.getGreen(), color.getBlue());
            }
        }
        return pixElArr;
    }

}
