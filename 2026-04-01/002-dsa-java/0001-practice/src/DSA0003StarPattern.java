class Utils0003{
    public void drawSquarePatter(int num){
        // handling row
        for(int i = 0; i < num; i++){
            String row = "";

            // handling column
            for(int j = 0; j < num; j++){
                row = row + (row.isBlank() ? "*" : "  *");
            }

            System.out.println(row);
        }
    }

    public void drawRightAngleTriangle(int num){
        for(int i = 0; i < num; i++){
            String row = "";

            for(int j = 0; j <= i; j++){
                row = row + (row.isBlank() ? "*" : "  *");
            }

            System.out.println(row);
        }
    }

    public void printNumberInRightAngleFormat(int num){
        for(int i = 0; i < num; i++){
            String row = "";

            for(int j = 0; j <= i; j++){
                if(j > 0)
                    row = row + "  ";
                row = row + (j + 1);
            }

            System.out.println(row);
        }
    }
}

public class DSA0003StarPattern {
    public static void main(String[] args){
        Utils0003 utils = new Utils0003();

        /**
         * draw a pattern like 4*4 as below
         * 
         *  *  *  *  *
         *  *  *  *  *
         *  *  *  *  *
         *  *  *  *  *
         */
        utils.drawSquarePatter(4);


        
        /**
         * draw a pattern like right angle triangle as below
         * 
         *  *
         *  *  *
         *  *  *  *
         *  *  *  *  *
         */
        utils.drawRightAngleTriangle(4);



        /**
         * print number in right angle triangle as below
         * 
         *  1
         *  1  2
         *  1  2  3
         *  1  2  3  4
         */
        utils.printNumberInRightAngleFormat(4);
    }
}
