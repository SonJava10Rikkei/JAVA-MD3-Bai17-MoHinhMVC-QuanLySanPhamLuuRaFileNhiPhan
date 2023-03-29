package rikkei.academmy.view;

import rikkei.academmy.config.Config;

public class NavBar {
    public NavBar() {
        while (true) {
            System.out.println("*************** CATEGORY MANAGE *************");
            System.out.println("1. Show List Category");
            System.out.println("2. Create Category");
            System.out.println("3. Update Category");
            System.out.println("4. Delete Category");
            int chooseMenu = Config.scanner().nextInt();
            switch (chooseMenu) {
                case 1:
                    new CategoryView().showListCategory();
                    break;
                case 2:
                    new CategoryView().formCreateCategory();
                    break;
                case 3:
                    new CategoryView().updateCategory();
                    break;
                case 4:
                    new CategoryView().deleteCategory();
                    break;
                case 5:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Hay nhap lai ");
            }
        }
    }

    public static void main(String[] args) {
        new NavBar();
    }
}