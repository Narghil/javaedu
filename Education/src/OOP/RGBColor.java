package OOP;

public class RGBColor {
    private int red, green, blue;

    private boolean validRGB( int i ){
        return (i >= 0 && i <= 255);
    }

    private boolean setRGB(int red, int green, int blue) {
        if (!(validRGB(red) && validRGB(green) && validRGB(blue))) {
            throw new IllegalArgumentException("Hibás paraméter");
        } else {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
        return true;
    }

    private String toHex(int number) {
        String hex;

        hex = Integer.toHexString(number);
        if (hex.length() < 2) {
            hex = "0".concat(hex);
        }

        return hex;
    }

    public String toString() {
        return "#" + toHex(this.red) + toHex(this.green) + toHex(this.blue);
    }

    public RGBColor(int red, int green, int blue) {
        setRGB(red, green, blue);
    }

    public static void main(String[] args) {
        RGBColor color = new RGBColor(1, 12, 123);

        System.out.println("Hexa color code:" + color.toString());
    }
}
