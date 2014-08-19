/**
 * 
 */
package hudson.plugins.selenium.configuration.global.hostname;

import hudson.DescriptorExtensionList;
import hudson.ExtensionPoint;
import hudson.model.Describable;
import hudson.model.Hudson;
import java.io.Serializable;


/**
 * This extension point exists to be able to configure selenium to resolve a hostname and publish it to it's nodes and the status view.
 * 
 * @author Richard Lavoie
 * 
 */
public abstract class HostnameResolver implements Describable<HostnameResolver>, ExtensionPoint, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3819154151335977152L;

    /**
     * Retrieve the hostname to use
     * 
     * @param computer
     *            Computer to retrieve the hostname of
     * @return Host name.
     */
    public abstract String retrieveHost();

    public HostnameResolverDescriptor getDescriptor() {
        return (HostnameResolverDescriptor) Hudson.getInstance().getDescriptor(getClass());
    }

    public static DescriptorExtensionList<HostnameResolver, HostnameResolverDescriptor> all() {
        return Hudson.getInstance().<HostnameResolver, HostnameResolverDescriptor> getDescriptorList(HostnameResolver.class);
    }

}
