package org.apereo.cas.util;

import org.apereo.cas.util.function.FunctionUtils;
import lombok.experimental.UtilityClass;
import lombok.val;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.jar.Manifest;

/**
 * Class that exposes the CAS version. Fetches the "Implementation-Version"
 * manifest attribute from the jar file.
 *
 * @author Dmitriy Kopylenko
 * @since 3.0.0
 */
@UtilityClass
@SuppressWarnings("CatchAndPrintStackTrace")
public class CasVersion {
    private static final String IMPLEMENTATION_DATE;

    /**
     * To string.
     *
     * @return the string
     */
    public static String asString() {
        return getVersion() + " - " + getSpecificationVersion();
    }

    /**
     * The full CAS version string.
     *
     * @return Return the full CAS version string.
     * @see Package#getImplementationVersion
     */
    public static String getVersion() {
        return CasVersion.class.getPackage().getImplementationVersion();
    }

    /**
     * Gets specification version from the manifest package.
     *
     * @return the specification version
     */
    public static String getSpecificationVersion() {
        return CasVersion.class.getPackage().getSpecificationVersion();
    }

    public static ZonedDateTime getDateTime() {
        return DateTimeUtils.zonedDateTimeOf(IMPLEMENTATION_DATE);
    }

    static {
        IMPLEMENTATION_DATE = FunctionUtils.doAndHandle(() -> {
            val className = CasVersion.class.getSimpleName() + ".class";
            val classPath = CasVersion.class.getResource(className).toString();
            val manifestPath = classPath.substring(0, classPath.lastIndexOf('!') + 1) + "/META-INF/MANIFEST.MF";
            val manifest = new Manifest(new URL(manifestPath).openStream());
            val attributes = manifest.getMainAttributes();
            return attributes.getValue("Implementation-Date");
        });
    }
}
