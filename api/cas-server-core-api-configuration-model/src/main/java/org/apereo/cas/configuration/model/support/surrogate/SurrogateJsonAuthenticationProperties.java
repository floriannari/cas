package org.apereo.cas.configuration.model.support.surrogate;

import org.apereo.cas.configuration.model.SpringResourceProperties;
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties;
import org.apereo.cas.configuration.support.RequiresModule;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is {@link SurrogateJsonAuthenticationProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-surrogate-webflow")
@Getter
@Setter
@Accessors(chain = true)
public class SurrogateJsonAuthenticationProperties extends SpringResourceProperties {
    private static final long serialVersionUID = 3599367681439517829L;
}
