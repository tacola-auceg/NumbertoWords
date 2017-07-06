

public class EnglishNumberToWords {

    private static final String[] tensNames = {"", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};
    private static final String[] numNames = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};

    private String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) {
            return soFar;
        }
        return numNames[number] + " hundred" + soFar;
    }

    public String convert(String number) {
        // 0 to999 999 999 999 999 999
        if (number .equals("0")) {
            return "zero";
        }


        // pad with "0"
        String snumber="000000000000000000";
        int end=number.length();
        snumber=snumber.substring(end,snumber.length());
        snumber=snumber+number;

        //XXXnnnnnnnnnnnnnnn
        int zillions=Integer.parseInt(snumber.substring(0,3));
        // nnnXXXnnnnnnnnnnnn
        int trillions=Integer.parseInt(snumber.substring(3,6));
        // nnnnnnXXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(9, 12));
        // nnnnnnnnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(12, 15));
        // nnnnnnnnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(15, 18));

        String tradZillions;
        switch (zillions) {
            case 0:
                tradZillions = "";
                break;
            case 1:
                tradZillions = convertLessThanOneThousand(zillions)
                        + " zillion ";
                break;
            default:
                tradZillions = convertLessThanOneThousand(zillions)
                        + " zillion ";
        }
        String result = tradZillions;


        String tradTrillions;
        switch (trillions) {
            case 0:
                tradTrillions = "";
                break;
            case 1:
                tradTrillions = convertLessThanOneThousand(trillions)
                        + " trillion ";
                break;
            default:
                tradTrillions = convertLessThanOneThousand(trillions)
                        + " trillion ";
        }
        result =result+ tradTrillions;


        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions)
                        + " billion ";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions)
                        + " billion ";
        }
        result =result+ tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions)
                        + " million ";
                break;
            default:
                tradMillions = convertLessThanOneThousand(millions)
                        + " million ";
        }
        result = result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "one thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                        + " thousand ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    /**
     * testing
     * @param args
     */
    public static void main(String[] args) {
        EnglishNumberToWords englishNumberToWords=new EnglishNumberToWords();
        System.out.println("*** " + englishNumberToWords.convert("1987654321"));

    }
}

