package gg.jte.generated.ondemand;
import com.MMS.MMS.dto.UserDTO;
public final class JtedemoGenerated {
	public static final String JTE_NAME = "demo.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,4,6,6,6,6,6,6,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserDTO loggedUser) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.JteheadGenerated.render(jteOutput, jteHtmlInterceptor, "Test page");
		jteOutput.writeContent("\r\n\r\n<h1>Hello ");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(loggedUser.userName());
		jteOutput.writeContent("!</h1>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserDTO loggedUser = (UserDTO)params.getOrDefault("loggedUser", new com.MMS.MMS.dto.UserDTO(new org.bson.types.ObjectId(), "User"));
		render(jteOutput, jteHtmlInterceptor, loggedUser);
	}
}
