/**
 * Класс для шифрования входящих сообщений
 *
 * @author    Денис Гончаренко
 */
public class Cryptographer {
    /**
     * метод входящие сообщения в особый формат,
     * содержащий в себе только нули и пробелы.
     *
     * @param input входящие сообщения
     */
    public String specialCipher(String input){
        if(input.length() > 100 || input.length() < 0){
            System.out.println("Incoming data does not pass restrictions");
            return null;
        }

        StringBuffer outputSB = new StringBuffer();

        for(int i = 0; i < input.length(); i++){
            int[] symbolBytes = charToIntArr(input.charAt(i), 7);

            int count = 1;
            int symbolByte = symbolBytes[0];

            for(int j = 1; j < symbolBytes.length; j++){
                if(symbolBytes[j] == symbolByte){
                    count++;
                }else {
                    writeSequenceOfNumbers(symbolByte, count, outputSB);
                    count = 1;
                    symbolByte = symbolBytes[j];
                }
            }
            writeSequenceOfNumbers(symbolByte, count, outputSB);
        }
        return outputSB.toString().trim();
    }

    /**
     * метод для преобразования символа ASCII в двоичный масив
     *
     * @param c символ для преобразования
     * @param countBytes длина масива
     */
    private int[] charToIntArr(char c, int countBytes){
        int[] symbolBytes = new int[countBytes];
        String stringBytes = Integer.toBinaryString(c);

        int index = stringBytes.length()-1;
        for(int j = stringBytes.length()-1; j >= 0; j--){
            symbolBytes[index--] = Character.getNumericValue(stringBytes.charAt(j));
        }
        return symbolBytes;
    }

    /**
     * метод для записи последовательости одиныковых битов в особом формате.
     *
     * @param symbol общий символ полследовательности
     * @param count длинна последовательности
     * @param outputSB строка для записи
     */
    private void writeSequenceOfNumbers(int symbol, int count, StringBuffer outputSB){
        if(symbol == 0){
            outputSB.append("00 ");
        }else {
            outputSB.append("0 ");
        }

        for(int k = 0; k < count; k++){
            outputSB.append("0");
        }
        outputSB.append(" ");
    }
}
