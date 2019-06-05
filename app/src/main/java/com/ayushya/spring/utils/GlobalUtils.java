package com.ayushya.spring.utils;


import com.ayushya.spring.helper.GlobalConstants;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Transactional
@Component
public class GlobalUtils {

    public static boolean uploadFile(String filePath, MultipartFile file) throws IOException {
        boolean uploaded = false;
        byte[] bytes = file.getBytes();
        Path path = Paths.get(filePath + GlobalConstants.DIR_PATH_SEPERATOR + file.getOriginalFilename());
        try {
            Files.write(path, bytes);
            uploaded = true;
        } catch (IOException e) {
            throw e;
        }
        return uploaded;
    }
}
