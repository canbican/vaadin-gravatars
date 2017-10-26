package net.birdirbir.vaadin.gravatars.demo;

import java.io.UnsupportedEncodingException;
import java.util.stream.Stream;

import javax.servlet.annotation.WebServlet;

import com.google.common.collect.ImmutableMap;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.bripkens.gravatar.DefaultImage;
import net.birdirbir.vaadin.gravatars.GravatarResource;

/**
 * @author Can Bican <can@bican.net>
 *
 */
@Theme("valo")
@Title("Gravatar Add-on Demo")
@SuppressWarnings("serial")
public class GravatarDemoUI extends UI {

  @SuppressWarnings("javadoc")
  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = GravatarDemoUI.class)
  public static class Servlet extends VaadinServlet {
    // none
  }

  @SuppressWarnings("boxing")
  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    setContent(layout);
    Stream.of(true, false).forEach(https -> {
      try {
        HorizontalLayout l = new HorizontalLayout();
        ImmutableMap.<String, ExternalResource>builder()
            .put("Normal<br/>https:" + https,
                GravatarResource.builder().build().get("can@bican.net"))
            .put("unknown<br/>https:" + https,
                GravatarResource.builder().build().get("unknown@unknown.example.com"))
            .put("unknown - blank image<br/>https:" + https,
                GravatarResource.builder().standardDefaultImage(DefaultImage.BLANK).https(https)
                    .build().get("unknown@unknown.example.com" + https))
            .put("unknown - 404 code<br/>https:" + https,
                GravatarResource.builder().standardDefaultImage(DefaultImage.HTTP_404).https(https)
                    .build().get("unknown@unknown.example.com" + https))
            .put("unknown - identicon<br/>https:" + https,
                GravatarResource.builder().standardDefaultImage(DefaultImage.IDENTICON).https(https)
                    .build().get("unknown@unknown.example.com" + https))
            .put("unknown - monster<br/>https:" + https,
                GravatarResource.builder().standardDefaultImage(DefaultImage.MONSTER).https(https)
                    .build().get("unknown@unknown.example.com" + https))
            .put("unknown - mystery man<br/>https:" + https,
                GravatarResource.builder().standardDefaultImage(DefaultImage.MYSTERY_MAN)
                    .https(https).build().get("unknown@unknown.example.com" + https))
            .put("unknown - retro<br/>https:" + https,
                GravatarResource.builder().standardDefaultImage(DefaultImage.RETRO).https(https)
                    .build().get("unknown@unknown.example.com" + https))
            .put("unknown - wavatar<br/>https:" + https,
                GravatarResource.builder().standardDefaultImage(DefaultImage.WAVATAR).https(https)
                    .build().get("unknown@unknown.example.com" + https))
            .build().forEach((k, v) -> {
              Image i = new Image(k, v);
              i.setCaptionAsHtml(true);
              l.addComponent(i);
            });
        layout.addComponent(l);
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    });
    HorizontalLayout l = new HorizontalLayout();
    try {
      Link link = new Link("with link to profile page",
          GravatarResource.builder().build().getProfile("can@bican.net"));
      link.setIcon(GravatarResource.builder().build().get("can@bican.net"));
      l.addComponent(link);
      layout.addComponent(l);
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
