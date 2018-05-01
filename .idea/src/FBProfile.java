import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

import java.io.FileInputStream;
import java.io.IOException;

public class FBProfile {
    public static void main(String[] args) throws IOException {

        //Чтение токена из файла
        FileInputStream stream = new FileInputStream("/home/aibek/Документы/token");
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);

        String text = new String(data);
        String[] lines = text.split("\n");


        String accesToken = lines[0];

        FacebookClient fbClient = new DefaultFacebookClient(accesToken);
        User me = fbClient.fetchObject("me", User.class);
        System.out.println(me.getName());

    }
}
