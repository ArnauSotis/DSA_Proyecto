public class Rectangulo {
    public int x,y,w,h;
    //x, y, ancho, largo
    private int[] pixels;

    Rectangulo(int x, int y, int w, int h)
    {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }

    Rectangulo()
    {
        this(0,0,0,0);
    }

    public void generarGraphics(int color)
    {
        pixels = new int[w * h];
        for (int y = 0; y < h; y++)
        { for (int x=0; x<w;x++)
        {
            pixels[x+y*w] = color;
        }
        }
    }

    public int[] getPixels()
    {
        if (pixels != null) {
            return pixels;
        } else
            System.out.println("Probar");

        return null;
    }

    public void renderRectangulo(Rectangulo rectangulo, int xZoom, int yZoom)
    {


    }

}
