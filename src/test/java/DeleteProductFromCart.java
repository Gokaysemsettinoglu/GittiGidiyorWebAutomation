import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DeleteProductFromCart extends BaseTest{
    HomePage homePage ;
    SelectPage selectPage;
    ProductsPage productsPage ;
    ProductDetailPage productDetailPage ;

    @Test
    @Order(1)
    public void searchProduct(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBar().search("bilgisayar");
        Assertions.assertTrue(homePage.isOnProductPage(),"Ürün Sayfada Bulunamadı");
    }

    @Test
    @Order(2)
    public void selectPage(){
        selectPage = new SelectPage(driver);
        selectPage.selectOnPage();
        Assertions.assertTrue(selectPage.isOnSelectPage(),"Sayfa Bulunamadı");

    }

    @Test
    @Order(3)
    public void addProduct() throws InterruptedException, IOException {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectOnProduct(1);
        productDetailPage.isOnProductPage();
        productDetailPage.addCart();
    }

    @Test
    @Order(4)
    public void checkCart() throws InterruptedException {
        homePage.goToCart();
        productDetailPage.addProductBasket();
        Assertions.assertTrue(productDetailPage.basketCountControl(), "Ürün Sayısı Arttırılamadı");
    }
}
