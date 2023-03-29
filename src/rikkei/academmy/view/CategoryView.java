package rikkei.academmy.view;

import rikkei.academmy.config.Config;
import rikkei.academmy.controller.CategoryController;
import rikkei.academmy.model.Category;

import java.util.List;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void showListCategory() {
        for (Category c : categoryList) {


            System.out.println(c);
        }
        System.out.println("Enter any key to continue or BACK to return Menu!");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new NavBar();
        }
    }

    public void formCreateCategory() {
        while (true) {
            int id = 0;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.println("Enter the name Category: ");
            String name = Config.scanner().nextLine();
            Category category = new Category(id, name);
            categoryController.createCategory(category);
            System.out.println("Creare Success !!! Mau me vao cho dep");
            System.out.println("Enter any key to continue or BACK to return Menu!");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new NavBar();
                break;
            }
        }
    }

    public void updateCategory() {
        while (true) {
            System.out.println("Enter the ID to update:  ");
            int id = Config.scanner().nextInt();
            if (categoryController.detailCategory(id) == null) {
                System.err.println("ID khong hop le! ");
            } else {
                System.out.println("Enter the new name Catagory: ");
                String name = Config.scanner().nextLine();
                Category category = new Category(id, name);
                categoryController.updateCategory(category);
            }
            System.out.println("Enter any key to continue or BACK to return Menu!");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new NavBar();
                break;
            }
        }
    }

    public void deleteCategory() {
        while (true) {
            System.out.println("Nhập Id của sản phẩm bạn muốn xóa");
            int targetId = Config.scanner().nextInt();
            if (categoryController.detailCategory(targetId) == null) {
                System.err.println("Id khong ton tai trong danh sach!");
            } else {
                categoryController.deleteCategory(targetId);
                System.out.println("Đã xóa sản phẩm!");
            }
            System.out.println("Enter any key to continue or BACK to return Menu!");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new NavBar();
                break;
            }
        }
    }
}
