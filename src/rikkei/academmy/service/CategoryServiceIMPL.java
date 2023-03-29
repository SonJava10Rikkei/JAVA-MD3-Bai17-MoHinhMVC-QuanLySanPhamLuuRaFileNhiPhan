package rikkei.academmy.service;

import rikkei.academmy.config.Config;
import rikkei.academmy.model.Category;

import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {
    // tao file luu tru tai pac
    List<Category> categoryList = new Config<Category>().readFromFile(Config.PATH_CATEGORY);

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public void save(Category category) {
        if (findbyId(category.getId()) == null) {
            categoryList.add(category);
        } else {
//            Category category1 = findbyId(category.getId());
//            category1.setName(category.getName());
            int index = categoryList.indexOf(findbyId(category.getId()));
            categoryList.set(index, category);

        }
//        categoryList.add(category);
        new Config<Category>().writeToFile(Config.PATH_CATEGORY, categoryList);
    }

    @Override
    public Category findbyId(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId() == id) {
                return categoryList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId() == id) {
                categoryList.remove(i);
            }
        }
        new Config<Category>().writeToFile(Config.PATH_CATEGORY, categoryList);
    }
}
