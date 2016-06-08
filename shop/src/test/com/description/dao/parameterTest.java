package test.com.description.dao;

import com.description.dao.UserDao;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by 10113513 on 2016/06/06.
 */
@RunWith(Parameterized.class)
public class parameterTest {
    int expected = 0;
    int input1 = 0;
    int input2 = 0;

    @Parameters
    public static Collection<Object[]> t() {
        return Arrays.asList(new Object[][]{
                {3,1,2},
                {5,2,3}
        });
    }

    public parameterTest(int expected,int input1,int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd() {
        assertEquals(expected, UserDao.add(input1,input2));
    }

}
