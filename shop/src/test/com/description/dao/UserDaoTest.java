package test.com.description.dao;

import com.description.model.User;
import org.junit.Test;
import com.description.dao.UserDao;

import static org.junit.Assert.assertEquals;

/**
 * UserDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>6 6, 2016</pre>
 */
public class UserDaoTest {

    /**
     * Method: query(Object obj)
     */
    @Test
    public void testAdd() {
        assertEquals(2, new UserDao().add(1, 1));
    }
    @Test
    public void testQuery() {
        String sql = "select * from user where 1=1  and user_name = '刘宝'";
        User user = new User();
        user.setUserName("刘宝华");
        assertEquals(sql,UserDao.query(user));
    }

} 
