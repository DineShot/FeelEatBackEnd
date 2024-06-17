package dine.dineshotbackend.store.service;

import dine.dineshotbackend.common.tools.Tool;
import dine.dineshotbackend.popularWord.entity.PopularWord;
import dine.dineshotbackend.popularWord.repository.PopularWordRepository;
import dine.dineshotbackend.store.dto.*;
import dine.dineshotbackend.store.entity.Menu;
import dine.dineshotbackend.store.entity.Restaurant;
import dine.dineshotbackend.store.entity.RestaurantImage;
import dine.dineshotbackend.store.repository.MenuRepository;
import dine.dineshotbackend.store.repository.RestaurantImageRepository;
import dine.dineshotbackend.store.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class StoreService {
    @Value("${file.upload-dir}")
    private String uploadDir;
    private final Tool tool;
    private final RestaurantImageRepository restaurantImageRepository;
    private final RestaurantRepository restaurantRepository;
    private final ModelMapper mapper;
    private final MenuRepository menuRepository;
    private final PopularWordRepository popularWordRepository;

    public StoreService(Tool tool, RestaurantImageRepository restaurantImageRepository, RestaurantRepository restaurantRepository, MenuRepository menuRepository, ModelMapper mapper, PopularWordRepository popularWordRepository) {
        this.tool = tool;
        this.restaurantImageRepository = restaurantImageRepository;
        this.restaurantRepository = restaurantRepository;
        this.mapper = mapper;
        this.menuRepository = menuRepository;
        this.popularWordRepository = popularWordRepository;
    }

    public List<RestaurantImageDTO> imgUpload(ArrayList<MultipartFile> files, Long restaurantCode) {
        List<RestaurantImageDTO> restaurantImageDTOList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file.getOriginalFilename() != null) {
                //StringUtils.cleanPath 는 파일 이름에 경로가 포함된 악성 파일일 경우 깔끔하게 정리해줌
                String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());  //파일 이름
                String changedFileName = UUID.randomUUID() + "_" + originalFileName;                 //변경된 파일 이름

                //C:\project-files\feeleat 에 파일 저장.
                //웹에서 http://localhost:8080/uploads/변경된파일이름 하면 열 수 있음.
                try {
                    String filePath = uploadDir + File.separator + changedFileName;
                    File dest = new File(filePath);
                    File directory = new File(dest.getParent());
                    if (!directory.exists()) {
                        if (directory.mkdirs()) {
                            System.out.println("경로가 존재하지 않아 생성하였습니다.");
                        } else {
                            throw new IOException("경로 생성에 실패했습니다." + directory.getAbsolutePath());
                        }
                    }
                    file.transferTo(dest);
                    RestaurantImageDTO restaurantImageDTO = new RestaurantImageDTO();
                    restaurantImageDTO.setRestaurant(restaurantCode);
                    restaurantImageDTO.setRestaurantImageChange(changedFileName);
                    restaurantImageDTO.setRestaurantImageIsDelete(false);
                    restaurantImageDTO.setRestaurantImageOriginal(originalFileName);
                    restaurantImageDTO.setRestaurantImageFilePath(filePath);
                    restaurantImageDTOList.add(restaurantImageDTO);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            }
        }
        return tool.convert(restaurantImageRepository.saveAll(tool.convert(restaurantImageDTOList, RestaurantImage.class)), RestaurantImageDTO.class);
    }

    // 가게 등록 메서드
    @Transactional
    public boolean insertRestaurant(RestaurantJoinDTO restaurantJoinDTO, Long userCode) {
        try {
            Restaurant restaurant = new Restaurant(); // Entity 하나 생성

            restaurant.setRestaurantUserCode(userCode); // JWT 에서 가져온 userCode
            restaurant.setRestaurantName(restaurantJoinDTO.getRestaurantName());
            restaurant.setRestaurantAddress(restaurantJoinDTO.getRestaurantAddress());
            restaurant.setRestaurantAddressDetail(restaurantJoinDTO.getRestaurantAddressDetail());
            restaurant.setRestaurantNumber(restaurantJoinDTO.getRestaurantNumber());
            restaurant.setRestaurantExplain(restaurantJoinDTO.getRestaurantExplain());
            restaurant.setRestaurantOpenDate(LocalDate.parse(restaurantJoinDTO.getRestaurantOpenDate()));
            restaurant.setRestaurantOpenTime(LocalTime.parse(restaurantJoinDTO.getRestaurantOpenTime()));
            restaurant.setRestaurantCloseTime(LocalTime.parse(restaurantJoinDTO.getRestaurantCloseTime()));

            restaurantRepository.save(restaurant); // 가게 정보 DB에 저장

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 메뉴 리스트 불러오는 메서드
     *
     */
    public List<MenuListDTO> getMenuList(Long restaurantCode) {
        List<Menu> menuList = menuRepository.getAllByRestaurant(restaurantCode);
        List<MenuListDTO> list = new ArrayList<>();
        for (Menu menu : menuList) {
            MenuListDTO dto = new MenuListDTO();
            dto.setMenuName(menu.getMenuName());
            dto.setMenuExplain(menu.getMenuExplain());
            dto.setMenuPrice(menu.getMenuPrice());
            dto.setMenuImgChangedName(menu.getMenuPhotoChange());
            list.add(dto);
        }
        return list;
    }

    /**
     * 메뉴 삭제하는 메서드
     *
     */
    public boolean deleteMenu(Long menuCode) {
        try {
            menuRepository.deleteByMenuCode(menuCode);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 가게 필터로 검색기능
     */
    public List<RestaurantSearchResponseDTO> findRestaurantWithFileter(@RequestBody RestaurantFindFilterDTO filterDTO) {

        return restaurantRepository.findRestaurantWithFilter(filterDTO).stream()
                .map(entity ->
                    RestaurantSearchResponseDTO.builder()
                            .restaurantName(entity.getRestaurantName())
                            .restaurantPhone(entity.getRestaurantNumber())
                            .restaurantAddress(entity.getRestaurantAddress())
                            .restaurantDetailAddress(entity.getRestaurantAddressDetail())
                            .Longitude(entity.getRestaurantLongitude())
                            .Latitude(entity.getRestaurantLatitude())
                            .build()
                ).toList();
    }

    /**
     * 가까운 가게 검색기능
     */
    public List<NearRestaurantResponseDTO> findNearRestaurantList(NearRestaurantFindDTO dto){
        return restaurantRepository.findNearRestaurantList(dto).stream()
                .map(entity ->
                        NearRestaurantResponseDTO.builder()
                                .restaurantCode(entity.getRestaurantCode())
                                .restaurantName(entity.getRestaurantName())
                                .restaurantExplain(entity.getRestaurantExplain())
                                .restaurantLatitude(entity.getRestaurantLatitude())
                                .restaurantLongitude(entity.getRestaurantLongitude())
                                .build()).toList();

    }

    /**
     * 이름으로 가게 찾기 기능 , 중간에 검색어는 DB에 저장됨
     */
    @Transactional
    public List<RestaurantSearchResponseDTO> findRestaurantWithName(String name) {
        popularWordRepository.save(PopularWord.createPopualrWord(name)); // 검색어 저장
        return restaurantRepository.findRestaurantByName(name).stream()
                .map(entity->
                        RestaurantSearchResponseDTO.builder()
                                .restaurantName(entity.getRestaurantName())
                                .restaurantPhone(entity.getRestaurantNumber())
                                .restaurantAddress(entity.getRestaurantAddress())
                                .restaurantDetailAddress(entity.getRestaurantAddressDetail())
                                .build()).toList();
    }

//    public RestaurantDTO insertRestaurant(RestaurantDTO restaurantDTO) {
//        return mapper.map(restaurantRepository.save(mapper.map(restaurantDTO, Restaurant.class)),RestaurantDTO.class);
//    }
//
//    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO, Long restaurantCode) {
//        restaurantDTO.setRestaurantCode(restaurantCode);
//        return mapper.map(restaurantRepository.save(mapper.map(restaurantDTO,Restaurant.class)),RestaurantDTO.class);
//    }
//    public List<RestaurantDTO> showRestaurantByReviewCount(){
//        restaurantRepository.showRestaurantByReviewCount();
//
//        return null;
//    }
}
