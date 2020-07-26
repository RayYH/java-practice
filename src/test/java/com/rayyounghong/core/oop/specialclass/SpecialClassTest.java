package com.rayyounghong.core.oop.specialclass;

import com.rayyounghong.core.oop.concretclass.Driveable;
import com.rayyounghong.core.oop.specialclass.SpecialClass.StaticClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class SpecialClassTest {

    @Test
    void testSpecialClass() {
        SpecialClass specialClass = new SpecialClass();
        assertEquals("special", specialClass.name);
        // notice here: new keyword
        SpecialClass.NonStaticClass nonStaticClass = specialClass.new NonStaticClass();
        assertEquals("non-static", nonStaticClass.name);
        assertEquals("1non-static", nonStaticClass.getFullName());
        SpecialClass.StaticClass staticClass = new StaticClass();
        assertEquals("static", staticClass.name);

        // anonymous class
        Driveable driveable = new Driveable() {
            @Override
            public String honk() {
                return "Hook";
            }

            @Override
            public String drive() {
                return "Drive";
            }
        };
        assertEquals("Hook", driveable.honk());
        assertEquals("Drive", driveable.drive());
    }
}
