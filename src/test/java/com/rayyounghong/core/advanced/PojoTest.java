package com.rayyounghong.core.advanced;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import java.beans.PropertyDescriptor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class PojoTest {

    @Test
    void testReflectionWithPojoAndBean() {
        List<String> list = new ArrayList<>();

        for (PropertyDescriptor pd : PropertyUtils.getPropertyDescriptors(EmployeePojo.class)) {
            list.add(pd.getDisplayName());
        }
        // see getStart method in EmployPojo class
        assertEquals("[start]", list.toString());

        list.clear();

        for (PropertyDescriptor pd : PropertyUtils.getPropertyDescriptors(EmployeeBean.class)) {
            list.add(pd.getDisplayName());
        }
        assertEquals("[firstName, lastName, startDate]", list.toString());
    }
}
