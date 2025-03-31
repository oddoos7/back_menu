package kr.ac.kumoh.s20200081.menu01.controller;

import kr.ac.kumoh.s20200081.menu01.model.Menu;
import kr.ac.kumoh.s20200081.menu01.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 전체 메뉴 조회
    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    // 특정 메뉴 조회
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        Optional<Menu> menu = menuService.getMenuById(id);
        return menu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 메뉴 추가
    @PostMapping
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    // 메뉴 수정
    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody Menu menu) {
        try {
            Menu updatedMenu = menuService.updateMenu(id, menu);
            return ResponseEntity.ok(updatedMenu);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 메뉴 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}
