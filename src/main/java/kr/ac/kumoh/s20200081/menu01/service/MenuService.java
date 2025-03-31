package kr.ac.kumoh.s20200081.menu01.service;

import kr.ac.kumoh.s20200081.menu01.model.Menu;
import kr.ac.kumoh.s20200081.menu01.repository.MenuRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu updatedMenu) {
        return menuRepository.findById(id).map(menu -> {
            menu.setName(updatedMenu.getName());
            menu.setDescription(updatedMenu.getDescription());
            menu.setPrice(updatedMenu.getPrice());
            menu.setImageUrl(updatedMenu.getImageUrl());
            return menuRepository.save(menu);
        }).orElseThrow(() -> new RuntimeException("메뉴를 찾을 수 없습니다."));
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
