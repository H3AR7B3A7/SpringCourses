package be.dog.d.steven.xmlconfiguration.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BeanConfigTest {
    @Autowired
    private BeanConfig beanConfig;

    @Test
    public void testGetEmpRecord2() {
        // TODO: This test is incomplete.

        this.beanConfig.getEmpRecord2();
    }

    @Test
    public void testGetDept3() {
        // TODO: This test is incomplete.

        this.beanConfig.getDept3();
    }

    @Test
    public void testGetEmpRecord4() {
        // TODO: This test is incomplete.

        this.beanConfig.getEmpRecord4();
    }

    @Test
    public void testGetDept4() {
        // TODO: This test is incomplete.

        this.beanConfig.getDept4();
    }
}

