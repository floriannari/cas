package org.apereo.cas.nativex;

import org.apereo.cas.util.nativex.CasRuntimeHintsRegistrar;
import org.springframework.aot.hint.RuntimeHints;

/**
 * This is {@link JpaRuntimeHints}.
 *
 * @author Misagh Moayyed
 * @since 7.1.0
 */
public class JpaRuntimeHints implements CasRuntimeHintsRegistrar {

    @Override
    public void registerHints(final RuntimeHints hints, final ClassLoader classLoader) {
        registerProxyHints(hints, org.springframework.integration.jdbc.lock.LockRepository.class);
    }
}


