package hudson.plugins.favorite.user;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.model.Item;
import hudson.model.User;
import hudson.model.UserProperty;
import hudson.model.UserPropertyDescriptor;
import hudson.plugins.favorite.Messages;
import jenkins.model.Jenkins;
import org.apache.commons.lang.StringUtils;

public class FavoriteUserPropertyDescriptor extends UserPropertyDescriptor {

    public FavoriteUserPropertyDescriptor() {
        super(FavoriteUserProperty.class);
    }

    @Override
    public UserProperty newInstance(User user) {
        return new FavoriteUserProperty();
    }

    @Override
    @NonNull
    public String getDisplayName() {
        return Messages.favoriteUserPropertyDescriptor();
    }

    @SuppressWarnings(value = "unused") // used by jelly
    public String toItemUrl(String fullName) {
        if (StringUtils.isEmpty(fullName)) {
            return null;
        }

        Jenkins jenkins = Jenkins.get();
        Item item = jenkins.getItemByFullName(fullName);
        if (item == null) {
          return null;
        }

        return jenkins.getRootUrl() + item.getUrl();
    }

}
