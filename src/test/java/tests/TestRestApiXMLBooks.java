package tests;

import consts.Endpoints;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import models.Book;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Steps;
import utils.ApiUtil;
import utils.TestUtil;
import java.util.List;

@Slf4j
public class TestRestApiXMLBooks {
    @Test
    public void GetGoodPostsWithAscendingOrder() {
        log.info("Получение всех книжек и проверка сортировки по возрастанию");
        List<Book> allBooks = ApiUtil.getAllBooks(Endpoints.GET_ALL_BOOKS, HttpStatus.SC_OK, ContentType.XML);
        Book maxPriceBook = Steps.getBookWithMaxPrice(allBooks);
        Book minPriceBook = Steps.getBookWithMinPrice(allBooks);

        Assert.assertTrue(Steps.isAscendingOrder(TestUtil.getNumbersFromStringList(Steps.getIdsBooks(allBooks))),
                "Книги отсортированы не по возрастанию (по id)");
        Assert.assertNotEquals(maxPriceBook.getTitle(), minPriceBook.getTitle(),
                "Название самой дорогой и самой дешевой книги совпадают");
        Assert.assertNotEquals(maxPriceBook.getDescription(), minPriceBook.getDescription(),
                "Описание самой дорогой и самой дешевой книги совпадают");
    }
}
