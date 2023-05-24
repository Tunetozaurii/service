package ro.unibuc.hello.data;

import org.junit.Assert;
import org.junit.Test;
import ro.unibuc.hello.data.ReviewEntity;

public class ReviewEntityTest {

    @Test
    public void testReviewEntity() {
        // Creare obiect ReviewEntity
        long id = 1L;
        String name = "John";
        int mark = 4;
        String description = "Great product!";
        ReviewEntity reviewEntity = new ReviewEntity(id, name, mark, description);

        // Verificare valorile atributelor
        Assert.assertEquals(id, reviewEntity.getId());
        Assert.assertEquals(name, reviewEntity.getName());
        Assert.assertEquals(mark, reviewEntity.getMark());
        Assert.assertEquals(description, reviewEntity.getDescription());
    }
}
