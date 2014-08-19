package hudson.plugins.selenium.configuration.browser.webdriver;

import hudson.DescriptorExtensionList;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.Hudson;
import hudson.plugins.selenium.configuration.browser.AbstractSeleniumBrowser;
import hudson.plugins.selenium.configuration.browser.BrowserDescriptor;
import org.openqa.grid.common.SeleniumProtocol;

public abstract class WebDriverBrowser extends AbstractSeleniumBrowser<WebDriverBrowser> implements Describable<WebDriverBrowser> {

    /**
	 * 
	 */
    private static final long serialVersionUID = -1666042840629819766L;

    protected WebDriverBrowser(int instances, String version, String name) {
        super(SeleniumProtocol.WebDriver, instances, version, name);
    }

    @SuppressWarnings( "unchecked" )
    public Descriptor<WebDriverBrowser> getDescriptor() {
        return Hudson.getInstance().getDescriptor(getClass());
    }

    public static DescriptorExtensionList<WebDriverBrowser, WebDriverBrowserDescriptor> all() {
        return Hudson.getInstance().<WebDriverBrowser, WebDriverBrowserDescriptor> getDescriptorList(WebDriverBrowser.class);
    }

    public static abstract class WebDriverBrowserDescriptor extends BrowserDescriptor<WebDriverBrowser> {

    }

}
