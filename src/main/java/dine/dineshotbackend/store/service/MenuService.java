package dine.dineshotbackend.store.service;

import dine.dineshotbackend.common.tools.Tool;
import dine.dineshotbackend.store.dto.MenuUploadDTO;
import dine.dineshotbackend.store.entity.Menu;
import dine.dineshotbackend.store.repository.MenuRepository;
import dine.dineshotbackend.store.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final Tool tool;

    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository, Tool tool) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.tool = tool;
    }

    //메뉴 추가하는 메서드
    @Transactional
    public boolean addMenu(Long restaurantCode, MenuUploadDTO menuUploadDTO, MultipartFile file){
        try {
            Menu menuEntity = new Menu();
            String newFileName = tool.imageUpload(file);

            menuEntity.setMenuName(menuUploadDTO.getMenuName());
            menuEntity.setMenuExplain(menuUploadDTO.getMenuExplain());
            menuEntity.setMenuIsAdult(menuUploadDTO.isMenuIsAdult());
            menuEntity.setMenuIsSell(menuUploadDTO.isMenuIsSell());
            menuEntity.setMenuPhotoChange(newFileName);
            menuEntity.setMenuDiscountRate(menuUploadDTO.getMenuDiscountRate());
//            menuEntity.setRestaurant(restaurantCode);
            menuEntity.setMenuPrice(menuUploadDTO.getMenuPrice());
            System.out.println("menuUploadDTO = " + menuUploadDTO);

            menuRepository.save(menuEntity);

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
