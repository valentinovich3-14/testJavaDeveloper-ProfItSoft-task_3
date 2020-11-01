/**
 * Тестовый класс класса Cryptographer.
 *
 * @author    Денис Гончаренко
 */
import org.junit.Assert;
import org.junit.Test;

public class TestCryptographer {
    /**
     * тестовый метод метода specialCipherPositive
     * позитывный сценарий
     */
    @Test
    public void testSpecialCipherPositive(){
        String input = "g";
        Cryptographer cryptographer = new Cryptographer();
        String actual = cryptographer.specialCipher(input);
        String expected = "0 00 00 00 0 000";
        Assert.assertEquals(expected, actual);
    }

    /**
     * тестовый метод метода specialCipherPositive
     * позитывный сценарий, граничное значение (пустая строка)
     */
    @Test
    public void testSpecialCipherWithZeroLengthLine(){
        String input = "";
        Cryptographer cryptographer = new Cryptographer();
        String actual = cryptographer.specialCipher(input);
        String expected = "";
        Assert.assertEquals(expected, actual);
    }

    /**
     * тестовый метод метода specialCipherPositive
     * позитывный сценарий, граничное значение (99 символов)
     */
    @Test
    public void testSpecialCipherWithMaxLengthLine(){
        StringBuffer input = new StringBuffer();
        while (input.length() < 100 ){
            input.append("Q");
        }
        Cryptographer cryptographer = new Cryptographer();
        String actual = cryptographer.specialCipher(input.toString());
        StringBuffer expected = new StringBuffer();
        for(int i = 0; i < 100; i++){
            expected.append("0 0 00 0 0 0 00 000 0 0 ");
        }
        Assert.assertEquals(expected.toString().trim(), actual);
    }

    /**
     * тестовый метод метода specialCipherPositive
     * негативный сценарий, граничное значение (100 символов)
     */
    @Test
    public void testSpecialCipherWithLengthLineOutOfBounds(){
        StringBuffer input = new StringBuffer();
        while (input.length() < 101 ){
            input.append("Q");
        }
        Cryptographer cryptographer = new Cryptographer();
        String actual = cryptographer.specialCipher(input.toString());
        StringBuffer expected = new StringBuffer();
        for(int i = 0; i < 101; i++){
            expected.append("0 0 00 0 0 0 00 000 0 0 ");
        }
        Assert.assertNotEquals(expected.toString().trim(), actual);
    }
}
