public class BitWiseComplement1009 {

    public int bitwiseComplement(int number) {

        String bin = convertDecToBinary(number);


    }
    
    private String convertDecToBinary(int number) {

        String result = "";
        while (number >= 1) {
            result += Integer.toString(number % 2);
            number /= 2;
        }

    }
}
