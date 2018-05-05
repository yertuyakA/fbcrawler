import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TimelinePosts {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("/home/aibek/Документы/token");
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);

        String text = new String(data);
        String[] lines = text.split("\n");


        String accesToken = lines[0];
        FacebookClient fbClient = new DefaultFacebookClient(accesToken);
        int counter = 0;

        Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
        for (List<Post> page : result){
            for (Post aPost: page) {
                System.out.println(aPost.getMessage());
                System.out.println("fb.com/"+aPost.getId());
                counter++;
            }
        }

        System.out.println(counter);
    }
}
