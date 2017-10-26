package net.birdirbir.vaadin.gravatars;

import java.io.UnsupportedEncodingException;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;

import de.bripkens.gravatar.DefaultImage;
import de.bripkens.gravatar.Gravatar;
import de.bripkens.gravatar.Rating;
import lombok.Builder;

/**
 * @author Can Bican, can@bican.net
 *
 */
@Builder
public class GravatarResource {
  private static final int DEFAULT_SIZE = 80;
  private static final Rating DEFAULT_RATING = Rating.GENERAL_AUDIENCE;

  @Builder.Default
  private int size = DEFAULT_SIZE;
  private boolean https;
  private boolean forceDefault;
  @Builder.Default
  private Rating rating = DEFAULT_RATING;
  private DefaultImage standardDefaultImage;
  @Builder.Default
  private String customDefaultImage = null;
  @Builder.Default
  private String customDefaultImageEncoding = null;

  /**
   * @param email Email to show as the gravatar image
   * @return the url to the gravatar image
   * @throws UnsupportedEncodingException when using customDefaultImage and the encoding is invalid
   */
  public ExternalResource get(String email) throws UnsupportedEncodingException {
    return new ExternalResource(g().getUrl(email));
  }

  private Gravatar g() throws UnsupportedEncodingException {
    Gravatar g = new Gravatar().setSize(this.size).setHttps(this.https).setRating(this.rating)
        .setForceDefault(this.forceDefault).setStandardDefaultImage(this.standardDefaultImage);
    if (this.customDefaultImage != null) {
      if (this.customDefaultImageEncoding != null) {
        g = g.setCustomDefaultImage(this.customDefaultImage, this.customDefaultImageEncoding);
      } else {
        g = g.setCustomDefaultImage(this.customDefaultImage);
      }
    }
    return g;
  }

  /**
   * @param email Email to show the gravatar profile for
   * @return the url to the gravatar profile
   * @throws UnsupportedEncodingException when using customDefaultImage and the encoding is invalid
   */
  public Resource getProfile(String email) throws UnsupportedEncodingException {
    return new ExternalResource(g().getUrl(email).replaceAll("/avatar/", "/"));
  }
}
