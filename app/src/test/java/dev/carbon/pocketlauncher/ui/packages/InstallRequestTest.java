// "Install by identifier": what the typed text installs (Android addition, design §5.4).
package dev.carbon.pocketlauncher.ui.packages;

import dev.carbon.pocketlauncher.core.packages.PackageService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InstallRequestTest {
    private static void github(String text, String identifier, String version) {
        InstallByIdDialog.Request r = InstallByIdDialog.Request.parse(text);
        assertEquals(text, InstallByIdDialog.Request.Kind.GITHUB, r.kind);
        assertEquals(text, identifier, r.identifier);
        assertEquals(text, version, r.version);
        assertEquals(identifier + "@" + version, r.label());
        assertTrue(r.hasPackagePage());
    }

    private static void source(String text) {
        InstallByIdDialog.Request r = InstallByIdDialog.Request.parse(text);
        assertEquals(text, InstallByIdDialog.Request.Kind.SOURCE, r.kind);
        assertEquals(text.trim(), r.source);
        assertEquals(text.trim(), r.label());
        assertFalse(r.hasPackagePage());
    }

    private static InstallByIdDialog.Request invalid(String text, String code) {
        InstallByIdDialog.Request r = InstallByIdDialog.Request.parse(text);
        assertEquals(String.valueOf(text), InstallByIdDialog.Request.Kind.INVALID, r.kind);
        assertEquals(String.valueOf(text), code, r.code);
        return r;
    }

    @Test
    public void testGitHubPackages() {
        github("Carbon/LHolo@1.0.0", "Carbon/LHolo", "1.0.0");
        github("  github.com/Carbon/LHolo#client@v1.0.0  ", "github.com/Carbon/LHolo#client", "v1.0.0");
        github("Carbon/LHolo#extra@1.0.0", "Carbon/LHolo#extra", "1.0.0");
        // A trailing '#' asks for the default variant (the request keeps the marker).
        github("Carbon/LHolo#@1.0.0", "Carbon/LHolo#", "1.0.0");
        // Repository URLs, with or without .git, become owner/repo.
        github("https://github.com/carbonthecoder/LHolo@1.0.0", "Carbon/LHolo", "1.0.0");
        github("https://github.com/carbonthecoder/LHolo.git/#client@1.0.0", "Carbon/LHolo#client", "1.0.0");
        github("Carbon/LHolo@branch:main", "Carbon/LHolo", "branch:main");
    }

    @Test
    public void testVersionRequired() {
        InstallByIdDialog.Request r = invalid("Carbon/LHolo", PackageService.ERR_PACKAGE_VERSION_REQUIRED);
        assertEquals("Carbon/LHolo", r.identifier);
        assertTrue("the package page lists the versions", r.hasPackagePage());
        invalid("https://github.com/carbonthecoder/LHolo", PackageService.ERR_PACKAGE_VERSION_REQUIRED);
        invalid("Carbon/LHolo@", PackageService.ERR_PACKAGE_VERSION_REQUIRED);
        InstallByIdDialog.Request other = invalid("gitee.com/owner/repo", PackageService.ERR_PACKAGE_VERSION_REQUIRED);
        assertFalse(other.hasPackagePage());
    }

    @Test
    public void testSources() {
        source("https://example.com/pkg.zip");
        source("https://example.com/pkg.zip#client");
        source("https://github.com/a/b/releases/download/v1.0.0/b.zip");
        source("gitee.com/owner/repo@1.0.0");
        source("gitee.com/owner/repo#client@tag:v1");
    }

    @Test
    public void testInvalid() {
        invalid(null, PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        invalid("   ", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        invalid("http://example.com/x.zip", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        invalid("ftp://example.com/x.zip", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        invalid("file:///sdcard/x.zip", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        invalid("/sdcard/x.zip", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        invalid("./x.zip", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        invalid("not a package", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        invalid("Carbon/LHolo@1.0 0", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        InstallByIdDialog.Request bad = invalid("gitee.com/owner/repo#Bad@1.0.0", PackageService.ERR_PACKAGE_INVALID_IDENTIFIER);
        assertFalse("the reason is kept", bad.detail.isEmpty());
    }
}
