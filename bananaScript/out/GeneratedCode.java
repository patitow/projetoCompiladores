public class GeneratedCode {
    public static void main(String[] args) {
        main();
}

    public static int soma(float a , double b ) {
        int d = 1;
        for (int c= 0; c <= 10 ; c++) {
            a = c + b;
        }
        if (a != b ) {
            a = a + 1;
        } else {
            if (b == c ) {
                a = a - 1;
            } else {
                a = a + 1;
            }
        }
        if (a == b || b <= a ) {
            a = a + 1;
        } else if (b != a ) {
            a = a * a;
        } else {
            throw new IOException("testando o throw");
        }
        while (b > 0 ) {
            b = b - 1;
        } 
        try {
            a = b + c;
        } catch (Exception e) {
            a = b - c;
        }
        int y = a + b;
        return a + b;
    }
    public static void main() {
        int a = 10;
        int b = 5;
        int c = soma(a, b);
        System.out.println("Testando o print");
    }
}

