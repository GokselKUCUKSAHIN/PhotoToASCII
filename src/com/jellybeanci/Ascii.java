package com.jellybeanci;

public class Ascii
{

    public static boolean isRevered = false;
    public static int scaler = 80;
    public static final Character[] SHADE = {' ', '.', '-', '+', '*', 'w', 'G', 'H', 'M', '#', '&', '$'};
    public static final Character[] PIXEL = {' ', '░', '▒', '▓', '█'};

    public static String convert(PixelElement[][] image)
    {
        int h = image.length;
        int w = image[0].length;
        int scale = w / scaler;
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < h; y += scale)
        {
            for (int x = 0; x < w; x += scale)
            {
                double val = image[y][x].getBrightness();
                sb.append(dither(val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String dither(double val)
    {
        // val between in 0 - 1
        // TR
        // Dither Patterni için her bir aralığın arasında birer daha
        // ara shade eklemek gerekiyor.
        // Eğer başlangıç dizisi X ise yeni dizi 2X - 1 adet elemana sahip
        // Yeni diziye göre index;
        // çift ise: aynı shadeden 2 tane.
        // tek ise: kendisi ve +1'i.
        int index = (int) Math.round(val * (SHADE.length * 2 - 1));
        int rindex = (index + 1) / 2;
        if ((index & 0x1) == 0)
        {
            // Even
            return "" + SHADE[rindex] + SHADE[rindex];
        } else
        {
            // Odd
            return "" + SHADE[rindex] + SHADE[rindex + 1];
        }
    }
}
