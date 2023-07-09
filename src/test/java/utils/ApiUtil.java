package utils;

import api_utils.ApiUtils;
import consts.Config;
import consts.Endpoints;
import consts.ResponseAnswer;
import io.restassured.http.ContentType;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;
import models.Book;
import org.testng.Assert;
import java.util.List;

public class ApiUtil {

    public static List<Book> getAllBooks(Endpoints endpoints, int status, ContentType contentType) {
        String path = JsonUtil.getValueFromJson(Config.CONFIG_DATA_PATH.label,Config.BASE_URI.label)+ endpoints.label;
        Response response = ApiUtils.getResponse(path);
        Assert.assertEquals(response.statusCode(), status, "Статус код не равен " + status);
        Assert.assertTrue(response.contentType().contains(contentType.toString()),"Тело ответа не равно " + contentType);

        NodeChildrenImpl books = response
                .path(ResponseAnswer.GET_BOOKS.label);

        List<Book> allBooks = response
                .xmlPath()
                .getList(ResponseAnswer.GET_BOOKS.label, Book.class);

        for (int i = 0; i < allBooks.size(); i++) {
            allBooks.get(i).setId(books.get(i).getAttribute(ResponseAnswer.GET_ID.label));
        }

        return allBooks;
    }
}
