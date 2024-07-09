package org.apereo.cas.nativex;

import lombok.val;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.RuntimeHints;

/**
 * This is {@link JpaRuntimeHintsTests}.
 *
 * @author Misagh Moayyed
 * @since 7.1.0
 */
@Tag("Native")
public class JpaRuntimeHintsTests {

    @Test
    void verifyHints() throws Throwable {
        val hints = new RuntimeHints();
        new JpaRuntimeHints().registerHints(hints, getClass().getClassLoader());
    }
}
