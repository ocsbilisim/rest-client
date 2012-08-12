package org.wiztools.restclient.ui.resheader;

import com.google.inject.ImplementedBy;
import org.wiztools.commons.MultiValueMap;
import org.wiztools.restclient.ui.ViewPanel;

/**
 *
 * @author subwiz
 */
@ImplementedBy(ResHeaderPanelImpl.class)
public interface ResHeaderPanel extends ViewPanel {
    MultiValueMap<String, String> getHeaders();
    void setHeaders(MultiValueMap<String, String> headers);
}
