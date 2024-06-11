package dine.dineshotbackend.common.tools;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class Tool {
    private final ModelMapper mapper;
    @Value("${file.upload-dir}")
    private static String uploadDir;

    public Tool(ModelMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * DTO,Entity List를 서로 변환해주는 메서드
     * @param list 변환할 리스트
     * @param targetClass 변환할 클래스.class
     * @return 변환된 List
     * @param <S> x
     * @param <T> x
     */
    public <S, T> List<T> convert(List<S> list, Class<T> targetClass) {
        return list.stream()
                .map(value -> mapper.map(value, targetClass))
                .collect(Collectors.toList());
    }

    /**
     * 경로에 이미지를 업로드하는 메서드
     * @param file 파일 하나
     * @return 저장된 바뀐 파일 이름
     */
    public static String imageUpload(MultipartFile file) {
        if(file.getOriginalFilename() != null) {
            String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());            //파일 이름
            String changedFileName = UUID.randomUUID() + "_" + originalFileName;                    //변경된 파일 이름
            try{
                String filePath = uploadDir + File.separator + changedFileName;
                File dest = new File(filePath);
                File directory = new File(dest.getParent());
                if(!directory.exists()){
                    if(directory.mkdirs()){
                        System.out.println("경로가 존재하지 않아 생성하였습니다.");
                    } else {
                        throw new IOException("경로가 존재하지 않아 생성하려고 했으나 실패했습니다. : " + directory.getAbsolutePath());
                    }
                }
                file.transferTo(dest);
                return changedFileName;
            } catch (IOException e) {
                System.out.println("File Input 중에 에러가 발생했습니다. from common/tools/Tool.class");
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }
}
