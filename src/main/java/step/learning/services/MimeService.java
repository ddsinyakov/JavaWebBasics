package step.learning.services;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class MimeService {
    private final Map<String, String> imageTypes;

    public MimeService() {
        imageTypes = new HashMap<>();
        imageTypes.put(".bmp", "image/bmp");
        imageTypes.put(".gif", "image/gif");
        imageTypes.put(".png", "image/png");
        imageTypes.put(".jpg", "image/jpg");
        imageTypes.put(".jpeg", "image/jpeg");
    }

    public boolean isImage(String extension) {
        return imageTypes.containsKey(extension);
    }

    public String getMimeByExtension(String extension){
        if(imageTypes.containsKey(extension))
            return imageTypes.get(extension);

        return null;
    }
}
