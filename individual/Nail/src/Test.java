import java.io.IOException;
import java.net.URISyntaxException;

public class Test {
    public static void main(String[] args) {
        try {
            TestServer.testAndOpenInBrowser("nail");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}