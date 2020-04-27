package controller.tags;

import model.entity.Trip;
import model.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class TripsTableTag extends SimpleTagSupport {

    public void doTag() throws JspException {

        Locale loc = (Locale) getJspContext().getAttribute("userLocale", PageContext.SESSION_SCOPE);
        ResourceBundle bundle = ResourceBundle.getBundle("locale", loc, this.getClass().getClassLoader());

        List<Trip> tripsList = (List<Trip>) getJspContext().getAttribute("tripsList", PageContext.REQUEST_SCOPE);

        if (tripsList != null) {
            String result = "";

            if (!tripsList.isEmpty()) {
                result += "<div class=\"page-table\">"
                        + "<table class=\"table\">"
                        + "<thead>"
                        + "<tr>"
                        + "<th scope=\"col\">" + bundle.getString("table.id") + "</th>"
                        + "<th scope=\"col\">" + bundle.getString("table.from") + "</th>"
                        + "<th scope=\"col\">" + bundle.getString("table.to") + "</th>"
                        + "<th scope=\"col\">" + bundle.getString("table.trip.status") + "</th>"
                        + "</tr >"
                        + "</thead >"
                        + "<tbody>";

                for (Trip trip : tripsList) {
                    result += "<tr>"
                            + "<td scope=\"col\">" + trip.getId() + "</td>"
                            + "<td scope=\"col\">" + trip.getFrom() + "</td>"
                            + "<td scope=\"col\">" + trip.getTo() + "</td>"
                            + "<td scope=\"col\">" + trip.getTripStatus() + "</td>"
                            + "</tr>";
                }

                result += "</tbody>"
                        + "</table>"
                        + "</div>";
            } else {
                result += "<p>" + bundle.getString("table.not.found.results") + "</p>";
            }

            try {
                JspWriter out = getJspContext().getOut();
                out.write(result);
            } catch (IOException e) {
                throw new JspException(e.getMessage());
            }
        }
    }

}
